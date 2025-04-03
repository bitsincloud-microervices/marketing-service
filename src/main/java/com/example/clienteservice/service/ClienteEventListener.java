package com.example.clienteservice.service;

import com.example.clienteservice.entity.Client;
import com.example.clienteservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteEventListener {

    private final ClientRepository repository;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "client-queue")
    public void processarCliente(Client client) {
        repository.save(client);
        System.out.println("Cliente recebido via evento: " + client);
    }
}

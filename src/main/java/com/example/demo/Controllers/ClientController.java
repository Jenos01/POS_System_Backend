package com.example.demo.Controllers;


import com.example.demo.Entity.Client;
import com.example.demo.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }


    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

}

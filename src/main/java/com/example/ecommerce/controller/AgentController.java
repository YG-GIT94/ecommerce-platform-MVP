package com.example.ecommerce.controller;

import com.example.ecommerce.model.Agent;
import com.example.ecommerce.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agents")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        Agent savedAgent = agentService.saveAgent(agent);
        return ResponseEntity.ok(savedAgent);
    }
}

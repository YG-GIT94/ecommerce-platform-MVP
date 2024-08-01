package com.example.ecommerce.service;

import com.example.ecommerce.model.Agent;
import com.example.ecommerce.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }
}

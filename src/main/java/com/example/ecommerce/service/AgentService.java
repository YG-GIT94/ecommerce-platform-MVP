package com.example.ecommerce.service;

import com.example.ecommerce.model.Agent;
import com.example.ecommerce.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent getAgentById(Long id) {
        Optional<Agent> agent = agentRepository.findById(id);
        return agent.orElse(null);
    }

    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public Agent updateAgent(Long id, Agent agentDetails) {
        Optional<Agent> agent = agentRepository.findById(id);
        if (agent.isPresent()) {
            Agent existingAgent = agent.get();
            existingAgent.setName(agentDetails.getName());
            existingAgent.setEmail(agentDetails.getEmail());
            existingAgent.setPhoneNumber(agentDetails.getPhoneNumber());
            return agentRepository.save(existingAgent);
        } else {
            return null;
        }
    }

    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }
}

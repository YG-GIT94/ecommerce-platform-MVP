package com.example.ecommerce.service;

import com.example.ecommerce.model.Agent;
import com.example.ecommerce.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing agents.
 */
@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    /**
     * Saves a new agent.
     * @param agent the agent to save
     * @return the saved agent
     */
    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    /**
     * Gets an agent by ID.
     * @param agentId the ID of the agent
     * @return the agent with the specified ID or null if not found
     */
    public Agent getAgentById(Long agentId) {
        return agentRepository.findById(agentId).orElse(null);
    }

    /**
     * Gets all agents.
     * @return a list of all agents
     */
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    /**
     * Deletes an agent by ID.
     * @param agentId the ID of the agent to delete
     */
    public void deleteAgentById(Long agentId) {
        agentRepository.deleteById(agentId);
    }
}

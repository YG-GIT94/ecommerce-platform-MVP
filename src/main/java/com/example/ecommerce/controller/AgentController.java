package com.example.ecommerce.controller;

import com.example.ecommerce.model.Agent;
import com.example.ecommerce.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing agents.
 */
@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    /**
     * Adds a new agent.
     * @param agent the agent to add
     * @return the saved agent
     */
    @PostMapping
    public Agent addAgent(@RequestBody Agent agent) {
        return agentService.saveAgent(agent);
    }

    /**
     * Gets an agent by ID.
     * @param agentId the ID of the agent
     * @return the agent with the specified ID
     */
    @GetMapping("/{agentId}")
    public Agent getAgent(@PathVariable Long agentId) {
        return agentService.getAgentById(agentId);
    }

    /**
     * Gets all agents.
     * @return a list of all agents
     */
    @GetMapping
    public List<Agent> getAllAgents() {
        return agentService.getAllAgents();
    }

    /**
     * Deletes an agent by ID.
     * @param agentId the ID of the agent to delete
     */
    @DeleteMapping("/{agentId}")
    public void deleteAgent(@PathVariable Long agentId) {
        agentService.deleteAgentById(agentId);
    }
}

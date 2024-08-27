package com.example.ecommerce.repository;

import com.example.ecommerce.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Agent entities.
 */
@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
}

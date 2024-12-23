package dev.rbayusetya.repository;

import dev.rbayusetya.tables.Budget;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BudgetRepository implements PanacheRepository<Budget> {
    // Inherits basic CRUD operations from PanacheRepository

    /**
     * This method returns the list of budget from userId
     * @param userId userId as parameter
     * @return a budget list from the userId
     */
    public List<Budget> findByUserId(String userId) {
        return list("userId", userId); // Finds all budgets for the given userId
    }
}

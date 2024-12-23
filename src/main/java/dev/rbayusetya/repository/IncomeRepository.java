package dev.rbayusetya.repository;

import dev.rbayusetya.tables.Income;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class IncomeRepository implements PanacheRepository<Income> {
    // Inherits basic CRUD operations from PanacheRepository

    /**
     * This method returns the list of income from budgetId
     * @param budgetId budgetId as parameter
     * @return an income list from the budgetId
     */
    public List<Income> findByBudgetId(String budgetId) {
        return list("budgetId", budgetId); // Finds all income for the given budgetId
    }

    /**
     * This method returns the list of income from userId
     * @param userId userId as parameter
     * @return an income list from the userId
     */
    public List<Income> findByUserId(String userId){
        return list("userId", userId); // Finds all income for the given budgetId
    }
}

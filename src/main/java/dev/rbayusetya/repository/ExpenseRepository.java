package dev.rbayusetya.repository;

import dev.rbayusetya.tables.Expense;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ExpenseRepository implements PanacheRepository<Expense> {
    // Inherits basic CRUD operations from PanacheRepository

    /**
     * This method returns the list of expense from budgetId
     * @param budgetId budgetId as parameter
     * @return an expense list from the budgetId
     */
    public List<Expense> findByBudgetId(String budgetId) {
        return list("budgetId", budgetId); // Finds all expense for the given budgetId
    }

    /**
     * This method returns the list of income from userId
     * @param userId userId as parameter
     * @return an expense list from userId
     */
    public List<Expense> findByUserId(String userId){
        return list("userId", userId); // Finds all income for the given budgetId
    }
}

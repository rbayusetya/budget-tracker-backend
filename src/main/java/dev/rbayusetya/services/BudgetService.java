package dev.rbayusetya.services;

import dev.rbayusetya.repository.BudgetRepository;
import dev.rbayusetya.tables.Budget;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BudgetService {
    @Inject
    BudgetRepository budgetRepository;

    public Budget createBudget(Budget budget){
        budgetRepository.persist(budget);
        return budget;
    }

    public List<Budget> getBudgets(String userId){
        return budgetRepository.find("userId",userId).list();
    }

    @Transactional
    public Budget updateBudget(Budget budget) {
        Budget existingBudget = budgetRepository.findById(budget.budgetId);
        if (existingBudget != null) {
            existingBudget.name = budget.name;
            existingBudget.startDate = budget.startDate;
            existingBudget.endDate = budget.endDate;
            existingBudget.totalAmount = budget.totalAmount;
            return existingBudget;
        }
        throw new RuntimeException("Budget not found");
    }

    @Transactional
    public boolean deleteBudget(Long budgetId) {
        return budgetRepository.deleteById(budgetId);
    }
}

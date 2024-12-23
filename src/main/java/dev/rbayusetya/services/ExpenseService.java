package dev.rbayusetya.services;

import dev.rbayusetya.repository.ExpenseRepository;
import dev.rbayusetya.tables.Expense;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ExpenseService {
    @Inject
    ExpenseRepository expenseRepository;

    public Expense addExpense(Expense expense){
        expenseRepository.persist(expense);
        return expense;
    }

    public List<Expense> getExpenses(String budgetId){
        return expenseRepository.find("budgetId",budgetId).list();
    }

    @Transactional
    public Expense updateExpense(Expense expense){
        Expense existingExpense = expenseRepository.findById(expense.expenseId);
        if(existingExpense!=null){
            existingExpense.budgetId = expense.budgetId;
            existingExpense.expenseId = expense.expenseId;
            existingExpense.amount = expense.expenseId;
            existingExpense.date = expense.date;
            existingExpense.description = expense.description;
            existingExpense.category = expense.category;
            return existingExpense;
        }
        throw new RuntimeException("Expense not found");
    }

    @Transactional
    public boolean deleteExpense(Long expenseId) {
        return expenseRepository.deleteById(expenseId);
    }
}

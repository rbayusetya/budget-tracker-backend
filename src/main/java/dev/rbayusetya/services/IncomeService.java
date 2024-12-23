package dev.rbayusetya.services;

import dev.rbayusetya.repository.IncomeRepository;
import dev.rbayusetya.tables.Income;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

public class IncomeService {
    @Inject
    IncomeRepository incomeRepository;

    public Income addIncome(Income in){
        incomeRepository.persist(in);
        return in;
    }

    public List<Income> getIncome(String budgetId){
        return incomeRepository.find("budgetId",budgetId).list();
    }

    @Transactional
    public Income updateIncome(Income income){
        Income existingIncome = incomeRepository.findById(income.incomeId);
        if(existingIncome!=null){
            existingIncome.budgetId = income.budgetId;
            existingIncome.incomeId = income.incomeId;
            existingIncome.amount = income.amount;
            existingIncome.date = income.date;
            existingIncome.description = income.description;
            existingIncome.source = income.source;
            return existingIncome;
        }
        throw new RuntimeException("Expense not found");
    }

    @Transactional
    public boolean deleteIncome(Long incomeId) {
        return incomeRepository.deleteById(incomeId);
    }
}

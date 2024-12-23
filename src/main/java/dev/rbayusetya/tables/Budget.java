package dev.rbayusetya.tables;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="budgets")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long budgetId; //using long because will be auto-incremented
    @Column(nullable = false)
    public String userId;
    @Column(nullable = false)
    public String name;
    @Column
    public long startDate;
    @Column
    public long endDate;
    @Column(nullable = false)
    public double totalAmount;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    List<Expense> expenseList;

    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    List<Income> incomeList;
}

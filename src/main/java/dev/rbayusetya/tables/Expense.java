package dev.rbayusetya.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue
    public String expenseId;
    @Column(nullable = false)
    public String budgetId;
    @Column
    public String category;
    @Column(nullable = false)
    public double amount;
    @Column(nullable = false)
    public long date;
    @Column
    public String description;
}

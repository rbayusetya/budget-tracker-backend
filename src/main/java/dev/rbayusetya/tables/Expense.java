package dev.rbayusetya.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long expenseId; //using Long because will be auto-incremented.
    @Column(nullable = false)
    public String budgetId;
    @Column
    public String category;
    @Column(nullable = false)
    public double amount;
    @Column(nullable = false)
    public Long date;
    @Column
    public String description;
}

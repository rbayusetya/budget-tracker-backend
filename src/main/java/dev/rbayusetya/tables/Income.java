package dev.rbayusetya.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long incomeId; //using Long because will be auto-incremented.
    @Column(nullable = false)
    public String budgetId;
    @Column
    public String source;
    @Column(nullable = false)
    public double amount;
    @Column(nullable = false)
    public Long date;
    @Column
    public String description;
}

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
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long userId;
    @Column(nullable = false, unique = true)
    public String email;
    @Column(nullable = false)
    public String password;
    @Column
    public String firstName;
    @Column
    public String lastName;
    @Column(nullable = false)
    public String fullName;
    @Column(nullable = false)
    public long createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Budget> budgetList;
}

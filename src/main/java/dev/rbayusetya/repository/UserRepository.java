package dev.rbayusetya.repository;

import dev.rbayusetya.tables.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    /**
     * Find a user by their email.
     * @param email the email of the user.
     * @return an Optional containing the User if found, otherwise empty.
     */
    public Optional<User> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    /**
     * Authenticate a user by email and password.
     * @param email    the email of the user.
     * @param password the hashed password of the user.
     * @return an Optional containing the User if credentials match, otherwise empty.
     */
    public Optional<User> authenticate(String email, String password) {
        return find("email = ?1 and password = ?2", email, password).firstResultOptional();
    }

    /**
     * Check if an email is already registered.
     * @param email the email to check.
     * @return true if the email exists, false otherwise.
     */
    public boolean emailExists(String email) {
        return count("email", email) > 0;
    }
}

package dev.rbayusetya.services;

import dev.rbayusetya.repository.UserRepository;
import dev.rbayusetya.tables.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;

    /**
     * Handles user login by validating email and password.
     * @param email    the user's email.
     * @param password the user's plaintext password.
     * @return the authenticated User if valid credentials, else throws an exception.
     */
    public User login(String email, String password) {
        return userRepository.authenticate(email, hashPassword(password))
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }

    /**
     * Registers a new user after validating email uniqueness.
     * @param user the User object containing user details.
     * @return the created User.
     */
    @Transactional
    public User register(User user) {
       if(validateEmail(user)){
           // Hash the password before saving
           user.password = hashPassword(user.password);
           userRepository.persist(user);
       }

        return user;
    }

    @Transactional
    public User updateData(User user){
        if(userRepository.findByEmail(user.email).isPresent()){
            User existingUser = userRepository.findByEmail(user.email).get();
            existingUser.userId = user.userId;
            existingUser.password = hashPassword(user.password);
            existingUser.budgetList = user.budgetList;
            existingUser.firstName = user.firstName;
            existingUser.lastName = user.lastName;
            existingUser.fullName = user.fullName;
        }
        return user;
    }

    private boolean validateEmail(User user){
        boolean result = false;
        if(!userRepository.emailExists(user.email)){
            result = true;
            throw new RuntimeException("Email already registered");
        }
        return result;
    }

    /**
     * Authenticates a user using a token (e.g., JWT).
     * @param token the authentication token.
     * @return true if the token is valid, false otherwise.
     */
    public boolean authenticate(String token) {
        // Add logic to validate the token (e.g., JWT decoding and verification)
        return validateToken(token);
    }

    /**
     * Generates a hashed version of the password.
     * @param password the plaintext password.
     * @return the hashed password.
     */
    private String hashPassword(String password) {
        // Replace this with a proper password hashing library like BCrypt
        return Integer.toHexString(password.hashCode());
    }

    /**
     * Validates a token (dummy implementation for now).
     * @param token the authentication token.
     * @return true if valid, false otherwise.
     */
    private boolean validateToken(String token) {
        // Dummy implementation for now; replace with proper token validation logic.
        return token != null && token.length() > 10;
    }
}


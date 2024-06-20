package com.capgemini.wsb.fitnesstracker.user.api;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User addUser(User user);
    User findUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}

package uni.fmi.demo.repository;

import uni.fmi.demo.model.User;

import java.util.List;

public interface UserRepository {
    /**
     * Create new user
     */
    void addUser(User u);

    /**
     * Delete user
     */
    void deleteUser(Long id);

    /**
     * Find user by id
     */
    User findById(Long id);

    /**
     * Update user information
     */
    void updateUser(User user);

    List<User> getAllUsers();
}

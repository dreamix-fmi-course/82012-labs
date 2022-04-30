package uni.fmi.demo.repository;

import org.springframework.stereotype.Repository;
import uni.fmi.demo.model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultUserRepository implements UserRepository {
    private final Map<Long, User> userMap = new ConcurrentHashMap<>();

    @Override
    public void addUser(User u) {
        validateUser(u);
        userMap.put(u.getId(), u);
    }

    @Override
    public void deleteUser(Long id) {
        validateId(id);
        userMap.remove(id);
    }

    @Override
    public User findById(Long id) {
        validateId(id);
        return userMap.get(id);
    }

    @Override
    public void updateUser(User user) {
        validateUser(user);
        deleteUser(user.getId());
        userMap.put(user.getId(), user);
    }

    @Override
    public List<User> getAllUsers() {
        return userMap.values().stream().toList();
    }

    private void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }
}

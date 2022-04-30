package uni.fmi.demo.model;

import lombok.Data;

import java.util.Objects;

@Data
public class User {
    private Long id;
    private String userName;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(userName, user.userName)
                && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email);
    }
}

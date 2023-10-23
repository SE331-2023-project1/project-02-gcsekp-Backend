package se331.rest.lab.security.identity;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);

}

package restApi.Gproject.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import restApi.Gproject.User.User;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Optional <User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail2);

    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<User> findByName(String name);

    
    
}

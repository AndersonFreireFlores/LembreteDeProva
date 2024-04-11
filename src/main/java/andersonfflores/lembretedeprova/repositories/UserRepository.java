package andersonfflores.lembretedeprova.repositories;

import andersonfflores.lembretedeprova.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
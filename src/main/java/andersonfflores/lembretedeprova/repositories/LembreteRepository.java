package andersonfflores.lembretedeprova.repositories;

import andersonfflores.lembretedeprova.entities.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LembreteRepository extends JpaRepository<Lembrete, UUID> {
}
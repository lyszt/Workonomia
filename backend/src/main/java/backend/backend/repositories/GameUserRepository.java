package backend.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backend.entities.GameUser;

public interface GameUserRepository extends JpaRepository<GameUser, Long> {
    Optional<GameUser> findByEmail(String email);
}

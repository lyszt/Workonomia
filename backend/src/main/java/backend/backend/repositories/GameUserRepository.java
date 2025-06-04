package backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.backend.entities.GameUser;

public interface GameUserRepository extends JpaRepository<GameUser, Long> {
    
}

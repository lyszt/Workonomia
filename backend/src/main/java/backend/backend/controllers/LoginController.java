package backend.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.entities.GameUser;
import backend.backend.repositories.GameUserRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoginController {
    GameUserRepository repos;

    @GetMapping("/users")
    public List<GameUser> getAllUsers() {
        return repos.findAll();
    }
    
    @GetMapping("/user/{id}")
    public GameUser getUserById(@PathVariable Long id) {
        return repos.findById(id).get();
    }

    @PostMapping("/userregister")
    public GameUser saveUser(@RequestBody GameUser user) {
        return repos.save(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        repos.deleteById(id);
    }    
}

package backend.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/auth")
    public ResponseEntity<?> authUser(@RequestBody GameUser user){
        Optional<GameUser> userOptional = repos.findByEmail(user.getEmail());
        if(userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
        GameUser existing_user = userOptional.get();
        if(user.getPassword().equals(existing_user.getPassword())){
            return ResponseEntity.status(HttpStatus.OK).body("Autenticação foi um sucesso.");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }

    

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        repos.deleteById(id);
    }    
}

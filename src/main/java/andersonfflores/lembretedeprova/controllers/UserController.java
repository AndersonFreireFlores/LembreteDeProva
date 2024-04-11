package andersonfflores.lembretedeprova.controllers;

import andersonfflores.lembretedeprova.entities.User;
import andersonfflores.lembretedeprova.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping(value = "/{id}")
    public Optional<User> getUser(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return service.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id ,@RequestBody User user) {
           return service.updateUser(id,user);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable UUID id) {
        service.deleteByID(id);
    }

    @DeleteMapping
    public void deleteAllUsers() {
        service.deleteAll();
    }

}

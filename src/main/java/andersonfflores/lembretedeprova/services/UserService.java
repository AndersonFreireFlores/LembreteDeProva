package andersonfflores.lembretedeprova.services;

import andersonfflores.lembretedeprova.entities.User;
import andersonfflores.lembretedeprova.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Optional<User> findById(UUID id){
        return repository.findById(id);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User createUser(User user){
        return repository.save(user);
    }

    public User updateUser(UUID id, User user){
        Optional<User> userOptional = repository.findById(id);
        if(userOptional.isPresent()){
            userOptional.get().setName(user.getName());
            userOptional.get().setEmail(user.getEmail());

            return repository.save(userOptional.get());
        }
        return null;
    }

    public void deleteByID(UUID id){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}

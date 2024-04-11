package andersonfflores.lembretedeprova.controllers;

import andersonfflores.lembretedeprova.entities.Lembrete;
import andersonfflores.lembretedeprova.services.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/lembretes")
public class LembreteController {

    @Autowired
    LembreteService service;

    @GetMapping(value = "/{id}")
    public Optional<Lembrete> getLembreteById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Lembrete> getAllLembretes() {
        return service.findAll();
    }

    @PostMapping
    public Lembrete createLembrete(@RequestBody Lembrete lembrete) {
        return service.create(lembrete);
    }

    @PutMapping(value = "/{id}")
    public Lembrete updateLembrete(@PathVariable UUID id ,@RequestBody Lembrete lembrete) {
        return service.update(id,lembrete);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLembrete(@PathVariable UUID id) {
        service.delete(id);
    }

    @DeleteMapping
    public void deleteAllLembretes() {
        service.deleteAll();
    }
}

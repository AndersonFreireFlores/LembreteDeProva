package andersonfflores.lembretedeprova.services;

import andersonfflores.lembretedeprova.entities.Lembrete;
import andersonfflores.lembretedeprova.repositories.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LembreteService {

    @Autowired
    LembreteRepository repository;

    @Autowired
    MailService mailService;

    public Optional<Lembrete> findById(UUID id){
        return repository.findById(id);
    }

    public List<Lembrete> findAll(){
        return repository.findAll();
    }

    public Lembrete create (Lembrete lembrete){
        return repository.save(lembrete);
    }

    public  Lembrete update(UUID id,Lembrete lembrete){
        Optional<Lembrete> lembreteOptional = repository.findById(id);
        if(lembreteOptional.isPresent()){
            lembreteOptional.get().setCriador(lembrete.getCriador());
            lembreteOptional.get().setMateria(lembrete.getMateria());
            lembreteOptional.get().setProfessor(lembrete.getProfessor());
            lembreteOptional.get().setDescrição(lembrete.getDescrição());
            lembreteOptional.get().setLembreteDate(lembrete.getLembreteDate());

            return repository.save(lembreteOptional.get());
        }
        return null;
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }


    @EventListener(ApplicationReadyEvent.class)
    public void SendingLembretes() {

        List<Lembrete> listLembretes  = repository.findAll();

        List<Lembrete> lembretesDeHoje = listLembretes.stream()
                .filter(Lembrete::dateVerifier).toList();

        for (Lembrete lembrete : lembretesDeHoje) {
            mailService.sendMail(lembrete.getCriador().getEmail(),lembrete.getMateria() + " do Professor: "+lembrete.getProfessor(), lembrete.getDescrição());
        }
    }


}

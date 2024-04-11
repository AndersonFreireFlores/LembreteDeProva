package andersonfflores.lembretedeprova.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Lembrete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String Materia;

    String professor;

    String descrição;

    @ManyToOne
    @JoinColumn(name = "criador_id")
    User criador;

    LocalDateTime creationDate;

    LocalDate lembreteDate;


}

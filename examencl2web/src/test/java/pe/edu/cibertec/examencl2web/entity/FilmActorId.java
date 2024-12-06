package pe.edu.cibertec.examencl2web.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmActorId {

    private Integer actorId;
    private Integer filmId;

}
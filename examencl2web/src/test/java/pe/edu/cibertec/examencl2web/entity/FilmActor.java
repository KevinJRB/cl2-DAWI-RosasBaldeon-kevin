package pe.edu.cibertec.examencl2web.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActor {

    @EmbeddedId
    private FilmActorId actorId;

    @MapsId("filmId")
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    private Date lastUpdate;
}
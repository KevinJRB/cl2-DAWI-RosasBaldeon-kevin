package pe.edu.cibertec.examencl2web.entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmCategoryId {
    private Integer categoryId;
    private Integer filmId;

}

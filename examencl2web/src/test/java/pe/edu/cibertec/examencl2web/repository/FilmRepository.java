package pe.edu.cibertec.examencl2web.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.examencl2web.entity.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}


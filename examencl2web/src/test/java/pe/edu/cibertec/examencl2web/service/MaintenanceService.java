package pe.edu.cibertec.examencl2web.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import pe.edu.cibertec.examencl2web.dto.FilmDetailDto;
import pe.edu.cibertec.examencl2web.dto.FilmDto;
import pe.edu.cibertec.examencl2web.dto.FilmEditDto;
import pe.edu.cibertec.examencl2web.entity.Language;

import java.util.List;

public interface MaintenanceService  {

    @Cacheable(value = "films")
    List<FilmDto> getAllFilms();

    FilmDetailDto getFilmById(int id);

    @CacheEvict(value = "films", allEntries = true)
    void updateFilm(FilmEditDto filmEditDto);

    List<Language> getAllLanguages();

    @CacheEvict(value = "films", allEntries = true)
    void deleteFilm(int id);

    @CacheEvict(value = "films", allEntries = true)
    void saveFilm(FilmEditDto filmEditDto);
}


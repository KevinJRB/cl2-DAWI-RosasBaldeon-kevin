package pe.edu.cibertec.examencl2web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.examencl2web.dto.FilmDetailDto;
import pe.edu.cibertec.examencl2web.dto.FilmDto;
import pe.edu.cibertec.examencl2web.dto.FilmEditDto;
import pe.edu.cibertec.examencl2web.entity.Film;
import pe.edu.cibertec.examencl2web.entity.Language;
import pe.edu.cibertec.examencl2web.repository.FilmRepository;
import pe.edu.cibertec.examencl2web.repository.LanguageRepository;
import pe.edu.cibertec.examencl2web.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;



    @Override
    public List<FilmDto> getAllFilms() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("OBTENIENDO DATOS DE MYSQL");
        List<FilmDto> films = new ArrayList<FilmDto>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto(film.getFilmId(), film.getTitle(), film.getLanguage().getName(), film.getRentalRate());
            films.add(filmDto);
        });
        System.out.println("------------------------------------------------------------------");
        return films;
    }

    @Override
    public FilmDetailDto getFilmById(int id) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("DETALLE DEL DATO");
        Optional<Film> optional = filmRepository.findById(id);
        System.out.println("------------------------------------------------------------------");

        return optional.map(
                film -> new FilmDetailDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate())

        ).orElse(null);

    }

    @Override
    public void updateFilm(FilmEditDto filmEditDto) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("ACTUALIZANDO DATOS");
        Film film = filmRepository.findById(filmEditDto.filmId())
                .orElseThrow(() -> new RuntimeException("Film not found"));

        Language language = languageRepository.findById(filmEditDto.languageId())
                .orElseThrow(() -> new RuntimeException("Language not found"));

        film.setTitle(filmEditDto.title());
        film.setDescription(filmEditDto.description());
        film.setReleaseYear(filmEditDto.releaseYear());
        film.setLanguage(language);
        film.setRentalDuration(filmEditDto.rentalDuration());
        film.setRentalRate(filmEditDto.rentalRate());
        film.setLength(filmEditDto.length());
        film.setReplacementCost(filmEditDto.replacementCost());
        film.setRating(filmEditDto.rating());
        film.setSpecialFeatures(filmEditDto.specialFeatures());
        film.setLastUpdate(new Date());

        System.out.println("------------------------------------------------------------------");
        filmRepository.save(film);
    }

    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public void deleteFilm(int id) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("ELIMINANDO DATOS");
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        System.out.println("------------------------------------------------------------------");
        filmRepository.delete(film);
    }

    @Override
    public void saveFilm(FilmEditDto filmEditDto) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("REGISTRANDO DATOS");

        Language language = languageRepository.findById(filmEditDto.languageId())
                .orElseThrow(() -> new RuntimeException("Language not found"));

        Film film = new Film();
        film.setTitle(filmEditDto.title());
        film.setDescription(filmEditDto.description());
        film.setReleaseYear(filmEditDto.releaseYear());
        film.setLanguage(language);
        film.setRentalDuration(filmEditDto.rentalDuration());
        film.setRentalRate(filmEditDto.rentalRate());
        film.setLength(filmEditDto.length());
        film.setReplacementCost(filmEditDto.replacementCost());
        film.setRating(filmEditDto.rating());
        film.setSpecialFeatures(filmEditDto.specialFeatures());
        film.setLastUpdate(new Date());
        System.out.println("------------------------------------------------------------------");
        filmRepository.save(film);
    }


}
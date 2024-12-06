package pe.edu.cibertec.examencl2web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.examencl2web.dto.FilmDetailDto;
import pe.edu.cibertec.examencl2web.dto.FilmDto;
import pe.edu.cibertec.examencl2web.dto.FilmEditDto;
import pe.edu.cibertec.examencl2web.entity.Language;
import pe.edu.cibertec.examencl2web.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {

        List<FilmDto> films = maintenanceService.getAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {

        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        model.addAttribute("filmDetailDto", filmDetailDto);
        return "maintenance-detail";
    }

    @GetMapping("/edit/{id}")
    public String editFilmForm(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        List<Language> languages = maintenanceService.getAllLanguages();

        model.addAttribute("filmDetailDto", filmDetailDto);
        model.addAttribute("languages", languages);

        return "maintenance-edit";
    }

    @PostMapping("/edit")
    public String updateFilm(FilmEditDto filmEditDto) {
        maintenanceService.updateFilm(filmEditDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Integer id) {
        maintenanceService.deleteFilm(id);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/new")
    public String newFilmForm(Model model) {
        List<Language> languages = maintenanceService.getAllLanguages();
        model.addAttribute("filmEditDto", new FilmEditDto(null, null, null, null, null, null, null, null, null, null, null, null, null));
        model.addAttribute("languages", languages);
        return "maintenance-new";
    }

    @PostMapping("/new")
    public String saveNewFilm(@ModelAttribute FilmEditDto filmEditDto) {
        maintenanceService.saveFilm(filmEditDto);
        return "redirect:/maintenance/start";
    }
}

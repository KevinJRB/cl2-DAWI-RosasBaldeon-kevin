package pe.edu.cibertec.examencl2web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.examencl2web.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}


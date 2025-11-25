package pe.edu.codigo.mvvm.repository;

import pe.edu.codigo.mvvm.domain.Tarea;

import java.util.List;
import java.util.Optional;

public interface TareaRepository {
    List<Tarea> findAll();
    Optional<Tarea> findById(Integer id);
    Tarea save(Tarea tarea);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}

package pe.edu.codigo.mvvm.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.codigo.mvvm.domain.Tarea;
import pe.edu.codigo.mvvm.repository.TareaRepository;
import pe.edu.codigo.mvvm.service.TareaService;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository repositorio;

    // Inyección por constructor (Best Practice)
    public TareaServiceImpl(TareaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Tarea> obtenerTodas() {
        return repositorio.findAll();
    }

    @Override
    public Tarea obtenerPorId(Integer id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));
    }

    @Override
    public Tarea guardar(Tarea tarea) {
        return repositorio.save(tarea);
    }

    @Override
    public Tarea actualizar(Integer id, Tarea tareaActualizada) {
        // Verificar si existe antes de actualizar
        if (!repositorio.existsById(id)) {
            throw new RuntimeException("No se puede actualizar: ID no existe");
        }
        tareaActualizada.setId(id); // Asegurar que el ID sea el correcto
        return repositorio.save(tareaActualizada);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repositorio.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: ID no existe");
        }
        repositorio.deleteById(id);
    }
}
package pe.edu.codigo.mvvm.repository.impl;

import org.springframework.stereotype.Repository;
import pe.edu.codigo.mvvm.domain.Tarea;
import pe.edu.codigo.mvvm.repository.TareaRepository;

import java.util.*;

@Repository
public class TareaRepositoryImpl implements TareaRepository {

    // Nuestra "Base de Datos" temporal
    private final Map<Integer, Tarea> db = new HashMap<>();
    private int idSequence = 1;

    public TareaRepositoryImpl() {
        // Datos de prueba para que Angular tenga algo que mostrar al inicio
        save(new Tarea(null, "Aprender Spring Boot API", true));
        save(new Tarea(null, "Conectar con Angular", false));
    }

    @Override
    public List<Tarea> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public Optional<Tarea> findById(Integer id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Tarea save(Tarea tarea) {
        if (tarea.getId() == null) {
            tarea.setId(idSequence++); // Asignar nuevo ID
        }
        db.put(tarea.getId(), tarea);
        return tarea;
    }

    @Override
    public void deleteById(Integer id) {
        db.remove(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return db.containsKey(id);
    }
}
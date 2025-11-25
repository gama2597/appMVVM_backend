package pe.edu.codigo.mvvm.service;

import pe.edu.codigo.mvvm.domain.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> obtenerTodas();
    Tarea obtenerPorId(Integer id);
    Tarea guardar(Tarea tarea);
    Tarea actualizar(Integer id, Tarea tarea);
    void eliminar(Integer id);
}

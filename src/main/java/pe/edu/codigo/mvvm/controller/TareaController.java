package pe.edu.codigo.mvvm.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.codigo.mvvm.domain.Tarea;
import pe.edu.codigo.mvvm.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "http://localhost:4200")
public class TareaController {

    private final TareaService servicio;

    public TareaController(TareaService servicio) {
        this.servicio = servicio;
    }

    // 1. GET - Obtener todas
    @GetMapping
    public ResponseEntity<List<Tarea>> listar() {
        return ResponseEntity.ok(servicio.obtenerTodas());
    }

    // 2. GET - Obtener una por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerUno(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(servicio.obtenerPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 3. POST - Crear nueva
    @PostMapping
    public ResponseEntity<Tarea> crear(@Valid @RequestBody Tarea tarea) {
        Tarea nuevaTarea = servicio.guardar(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED); // Retorna 201 Created
    }

    // 4. PUT - Actualizar existente
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Integer id, @Valid @RequestBody Tarea tarea) {
        try {
            return ResponseEntity.ok(servicio.actualizar(id, tarea));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. DELETE - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        try {
            servicio.eliminar(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
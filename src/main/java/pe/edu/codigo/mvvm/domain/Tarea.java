package pe.edu.codigo.mvvm.domain;

import jakarta.validation.constraints.NotBlank;

public class Tarea {

    private Integer id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    private boolean completado;

    public Tarea(Integer id, String titulo, boolean completado) {
        this.id = id;
        this.titulo = titulo;
        this.completado = completado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El título es obligatorio") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank(message = "El título es obligatorio") String titulo) {
        this.titulo = titulo;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}

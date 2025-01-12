/**
 * Representa una tarea en el sistema con identificación única, descripción, marca temporal
 * de creación y estado de completitud.
 */
package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    /** Identificador único de la tarea */
    private final String id;
    
    /** Descripción de la tarea */
    private String description;
    
    /** Marca temporal de cuando se creó la tarea */
    private LocalDateTime createdAt;
    
    /** Bandera que indica si la tarea ha sido completada */
    private boolean completed;

    /**
     * Construye una nueva Tarea con la descripción especificada.
     * Genera automáticamente un ID único, establece el tiempo de creación al actual,
     * e inicializa la tarea como no completada.
     *
     * @param description La descripción de la tarea
     */
    public Task(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.completed = false;
    }

    /**
     * @return El identificador único de la tarea
     */
    public String getId() { return id; }

    /**
     * @return La descripción de la tarea
     */
    public String getDescription() { return description; }

    /**
     * Actualiza la descripción de la tarea
     * @param description La nueva descripción a establecer
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * @return La marca temporal de cuando se creó la tarea
     */
    public LocalDateTime getCreatedAt() { return createdAt; }

    /**
     * @return true si la tarea está completada, false en caso contrario
     */
    public boolean isCompleted() { return completed; }

    /**
     * Actualiza el estado de completitud de la tarea
     * @param completed El nuevo estado de completitud a establecer
     */
    public void setCompleted(boolean completed) { this.completed = completed; }

    /**
     * Devuelve una representación en cadena del objeto Task.
     * 
     * @return Una cadena que contiene el id, descripción y estado de completitud de la tarea
     */
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
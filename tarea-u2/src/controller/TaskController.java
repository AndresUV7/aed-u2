/**
 * Controlador que maneja la lógica de negocio entre el repositorio de tareas y la vista.
 * Implementa el patrón MVC gestionando la comunicación entre el modelo y la vista.
 */
package controller;

import model.Task;
import model.TaskRepository;
import view.TaskView;

import java.util.List;
import java.util.Optional;

public class TaskController {
    /** Repositorio que maneja el almacenamiento de tareas */
    private final TaskRepository repository;
    
    /** Vista que maneja la interfaz de usuario */
    private final TaskView view;

    /**
     * Constructor que inicializa el controlador con sus dependencias.
     * @param repository Repositorio de tareas a utilizar
     * @param view Vista a utilizar para la interfaz de usuario
     */
    public TaskController(TaskRepository repository, TaskView view) {
        this.repository = repository;
        this.view = view;
    }

    /**
     * Crea y agrega una nueva tarea al repositorio.
     * @param description Descripción de la tarea a crear
     */
    public void addTask(String description) {
        Task task = new Task(description);
        repository.addTask(task);
        view.displayMessage("Tarea agregada exitosamente.");
    }

    /**
     * Muestra la próxima tarea pendiente.
     */
    public void showNextTask() {
        Optional<Task> nextTask = repository.getNextTask();
        if (nextTask.isPresent()) {
            view.displayTask(nextTask.get());
        } else {
            view.displayMessage("No hay tareas pendientes.");
        }
    }

    /**
     * Muestra todas las tareas pendientes.
     */
    public void showAllPendingTasks() {
        List<Task> pendingTasks = repository.getAllPendingTasks();
        if (pendingTasks.isEmpty()) {
            view.displayMessage("No hay tareas pendientes.");
        } else {
            view.displayTaskList(pendingTasks);
        }
    }

    /**
     * Muestra todas las tareas completadas.
     */
    public void showAllCompletedTasks() {
        List<Task> completedTasks = repository.getAllCompletedTasks();
        if (completedTasks.isEmpty()) {
            view.displayMessage("No hay tareas completadas.");
        } else {
            view.displayTaskList(completedTasks);
        }
    }

    /**
     * Marca una tarea específica como completada.
     * @param taskId ID de la tarea a marcar como completada
     */
    public void markTaskAsCompleted(String taskId) {
        boolean success = repository.markTaskAsCompleted(taskId);
        if (success) {
            view.displayMessage("Tarea marcada como completada exitosamente.");
        } else {
            view.displayMessage("No se encontró la tarea especificada.");
        }
    }

    /**
     * Elimina una tarea específica.
     * @param taskId ID de la tarea a eliminar
     */
    public void deleteTask(String taskId) {
        boolean success = repository.deleteTask(taskId);
        if (success) {
            view.displayMessage("Tarea eliminada exitosamente.");
        } else {
            view.displayMessage("No se encontró la tarea especificada.");
        }
    }
}

/**
 * Repositorio que gestiona el almacenamiento y manipulación de tareas.
 * Utiliza una pila para las tareas pendientes y una cola para las completadas.
 */
package model;

import java.util.*;

public class TaskRepository {
    /** Pila que almacena las tareas pendientes */
    private Stack<Task> pendingTasks;
    
    /** Cola que almacena las tareas completadas */
    private Queue<Task> completedTasks;

    /**
     * Constructor que inicializa las estructuras de datos para almacenar las tareas.
     */
    public TaskRepository() {
        this.pendingTasks = new Stack<>();
        this.completedTasks = new LinkedList<>();
    }

    /**
     * Agrega una nueva tarea a la pila de tareas pendientes.
     * @param task La tarea a agregar
     */
    public void addTask(Task task) {
        pendingTasks.push(task);
    }

    /**
     * Obtiene la próxima tarea pendiente sin removerla de la pila.
     * @return Un Optional conteniendo la próxima tarea, o empty si no hay tareas pendientes
     */
    public Optional<Task> getNextTask() {
        if (pendingTasks.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(pendingTasks.peek());
    }

    /**
     * Obtiene una lista de todas las tareas pendientes.
     * @return Lista con todas las tareas pendientes
     */
    public List<Task> getAllPendingTasks() {
        return new ArrayList<>(pendingTasks);
    }

    /**
     * Obtiene una lista de todas las tareas completadas.
     * @return Lista con todas las tareas completadas
     */
    public List<Task> getAllCompletedTasks() {
        return new ArrayList<>(completedTasks);
    }

    /**
     * Marca una tarea como completada y la mueve a la cola de tareas completadas.
     * @param taskId ID de la tarea a marcar como completada
     * @return true si la tarea fue encontrada y marcada como completada, false en caso contrario
     */
    public boolean markTaskAsCompleted(String taskId) {
        Stack<Task> tempStack = new Stack<>();
        Task foundTask = null;

        while (!pendingTasks.isEmpty()) {
            Task task = pendingTasks.pop();
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                foundTask = task;
            } else {
                tempStack.push(task);
            }
        }

        while (!tempStack.isEmpty()) {
            pendingTasks.push(tempStack.pop());
        }

        if (foundTask != null) {
            completedTasks.offer(foundTask);
            return true;
        }
        return false;
    }

    /**
     * Elimina una tarea de la pila de tareas pendientes.
     * @param taskId ID de la tarea a eliminar
     * @return true si la tarea fue encontrada y eliminada, false en caso contrario
     */
    public boolean deleteTask(String taskId) {
        Stack<Task> tempStack = new Stack<>();
        boolean found = false;

        while (!pendingTasks.isEmpty()) {
            Task task = pendingTasks.pop();
            if (!task.getId().equals(taskId)) {
                tempStack.push(task);
            } else {
                found = true;
            }
        }

        while (!tempStack.isEmpty()) {
            pendingTasks.push(tempStack.pop());
        }

        return found;
    }
}
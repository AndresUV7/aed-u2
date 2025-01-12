/**
 * Vista que maneja la presentación de información al usuario.
 * Implementa la interfaz de usuario en consola para el sistema de gestión de tareas.
 */
package view;

import model.Task;
import java.util.List;

public class TaskView {
    /**
     * Muestra un mensaje en la consola.
     * @param message Mensaje a mostrar
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Muestra los detalles de una tarea específica.
     * @param task Tarea a mostrar
     */
    public void displayTask(Task task) {
        System.out.println("=== Tarea ===");
        System.out.println("ID: " + task.getId());
        System.out.println("Descripción: " + task.getDescription());
        System.out.println("Completada: " + (task.isCompleted() ? "Sí" : "No"));
        System.out.println("============");
    }

    /**
     * Muestra una lista de tareas.
     * @param tasks Lista de tareas a mostrar
     */
    public void displayTaskList(List<Task> tasks) {
        System.out.println("=== Lista de Tareas ===");
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId());
            System.out.println("Descripción: " + task.getDescription());
            System.out.println("Completada: " + (task.isCompleted() ? "Sí" : "No"));
            System.out.println("--------------------");
        }
        System.out.println("=====================");
    }

    /**
     * Muestra el menú principal del sistema.
     */
    public void displayMenu() {
        System.out.println("\n=== Sistema de Gestión de Tareas ===");
        System.out.println("1. Agregar nueva tarea");
        System.out.println("2. Ver próxima tarea");
        System.out.println("3. Ver todas las tareas pendientes");
        System.out.println("4. Ver todas las tareas completadas");
        System.out.println("5. Marcar tarea como completada");
        System.out.println("6. Eliminar tarea");
        System.out.println("7. Salir");
        System.out.println("Seleccione una opción: ");
    }
}

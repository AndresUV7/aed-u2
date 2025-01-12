import java.util.Scanner;

import controller.TaskController;
import model.TaskRepository;
import view.TaskView;

/**
 * Clase principal que inicializa y ejecuta el sistema de gestión de tareas.
 * Implementa el ciclo principal del programa y maneja la interacción del usuario.
 */
public class Main {
    /**
     * Punto de entrada principal del programa.
     * Inicializa los componentes necesarios y ejecuta el ciclo principal de la aplicación.
     * @param args Argumentos de línea de comando (no utilizados)
     */
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        TaskView view = new TaskView();
        TaskController controller = new TaskController(repository, view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            view.displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.println("Ingrese la descripción de la tarea:");
                    String description = scanner.nextLine();
                    controller.addTask(description);
                    break;
                case 2:
                    controller.showNextTask();
                    break;
                case 3:
                    controller.showAllPendingTasks();
                    break;
                case 4:
                    controller.showAllCompletedTasks();
                    break;
                case 5:
                    System.out.println("Ingrese el ID de la tarea a completar:");
                    String completeId = scanner.nextLine();
                    controller.markTaskAsCompleted(completeId);
                    break;
                case 6:
                    System.out.println("Ingrese el ID de la tarea a eliminar:");
                    String deleteId = scanner.nextLine();
                    controller.deleteTask(deleteId);
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}
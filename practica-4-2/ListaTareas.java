import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTareas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tareas = new ArrayList<>();

        for (int i = 1; i <= 4; i++) {
            System.out.print("Tarea " + i + ": ");
            tareas.add(scanner.nextLine());
        }

        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
        System.out.println("Cantidad: " + tareas.size());

        System.out.print("Tarea a buscar: ");
        String buscada = scanner.nextLine();

        if (tareas.contains(buscada)) {
            System.out.println("La tarea existe. Se elimina.");
            tareas.remove(buscada);
        } else {
            System.out.println("La tarea no existe.");
        }

        System.out.println("Lista actualizada: " + tareas);
        scanner.close();
    }
}

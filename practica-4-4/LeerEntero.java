import java.util.Scanner;

public class LeerEntero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cantidad;
        boolean valida = false;

        do {
            System.out.print("Cantidad no negativa: ");
            String entrada = scanner.nextLine();

            try {
                cantidad = Integer.parseInt(entrada.trim());

                if (cantidad >= 0) {
                    System.out.println("Cantidad aceptada: " + cantidad);
                    valida = true;
                } else {
                    System.out.println("No puede ser negativa.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes escribir un entero válido.");
            }

        } while (!valida);

        scanner.close();
    }
}

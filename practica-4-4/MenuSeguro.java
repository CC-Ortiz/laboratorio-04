import java.util.Scanner;

public class MenuSeguro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println();
            System.out.println("1. Consultar");
            System.out.println("2. Registrar");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            String entrada = scanner.nextLine();

            try {
                opcion = Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("La opción no es numérica.");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1 -> System.out.println("Consultando...");
                case 2 -> System.out.println("Registrando...");
                case 0 -> System.out.println("Programa finalizado.");
                default -> System.out.println("La opción no existe.");
            }
        }

        scanner.close();
    }
}

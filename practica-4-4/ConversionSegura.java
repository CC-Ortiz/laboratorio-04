import java.util.Scanner;

public class ConversionSegura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cantidad: ");
        String entrada = scanner.nextLine();

        try {
            int cantidad = Integer.parseInt(entrada);
            System.out.println("Cantidad registrada: " + cantidad);
        } catch (NumberFormatException e) {
            System.out.println("Debes escribir un número entero.");
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}

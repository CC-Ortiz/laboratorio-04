import java.util.Scanner;

public class ConversionDirecta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Cantidad: ");
        String entrada = scanner.nextLine();

        int cantidad = Integer.parseInt(entrada);

        System.out.println("Cantidad registrada: " + cantidad);

        scanner.close();
    }
}

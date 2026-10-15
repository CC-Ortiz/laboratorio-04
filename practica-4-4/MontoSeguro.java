import java.util.Scanner;

public class MontoSeguro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double monto = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print("Monto: ");
            String entrada = scanner.nextLine().trim();

            try {
                double valor = Double.parseDouble(entrada);

                if (!Double.isFinite(valor) || valor <= 0) {
                    System.out.println("Debes escribir un monto positivo y finito.");
                } else {
                    monto = valor;
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes escribir un monto numérico.");
            }
        }

        System.out.println("Monto aceptado: $" + monto);
        scanner.close();
    }
}

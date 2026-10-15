import java.util.Scanner;

public class CalculadoraSegura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println();
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: la opción debe ser numérica.");
                opcion = -1;
                continue;
            }

            if (opcion == 0) {
                System.out.println("Programa finalizado.");
                break;
            }
            if (opcion < 1 || opcion > 4) {
                System.out.println("Esa opción no existe.");
                continue;
            }

            double a;
            double b;
            try {
                System.out.print("Primer número: ");
                a = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Segundo número: ");
                b = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: debes escribir números.");
                continue;
            }

            if (!Double.isFinite(a) || !Double.isFinite(b)) {
                System.out.println("Entrada inválida: no se admiten NaN ni Infinity.");
                continue;
            }

            switch (opcion) {
                case 1 -> System.out.println("Resultado: " + (a + b));
                case 2 -> System.out.println("Resultado: " + (a - b));
                case 3 -> System.out.println("Resultado: " + (a * b));
                case 4 -> {
                    if (b == 0) {
                        System.out.println("Operación no permitida: división entre cero.");
                    } else {
                        System.out.println("Resultado: " + (a / b));
                    }
                }
                default -> { }
            }
        }

        scanner.close();
    }
}

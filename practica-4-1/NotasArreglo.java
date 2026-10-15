import java.util.Scanner;

public class NotasArreglo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[5];

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        double suma = 0;
        double mayor = notas[0];
        double menor = notas[0];
        int aprobadas = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Posición " + i + ": " + notas[i]);
            suma += notas[i];
            if (notas[i] > mayor) mayor = notas[i];
            if (notas[i] < menor) menor = notas[i];
            if (notas[i] >= 3.0) aprobadas++;
        }

        System.out.println("Promedio: " + (suma / notas.length));
        System.out.println("Nota mayor: " + mayor);
        System.out.println("Nota menor: " + menor);
        System.out.println("Aprobadas: " + aprobadas);

        scanner.close();
    }
}

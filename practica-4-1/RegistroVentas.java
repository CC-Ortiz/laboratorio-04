public class RegistroVentas {

    public static void main(String[] args) {
        double[] ventas = {120000, 85000, 95000, 150000, 60000};

        System.out.println("Primera venta: " + ventas[0]);
        System.out.println("Última venta: " + ventas[ventas.length - 1]);
        System.out.println("Cantidad de ventas: " + ventas.length);

        ventas[2] = 100000;
        System.out.println("Tercera venta modificada: " + ventas[2]);
    }
}

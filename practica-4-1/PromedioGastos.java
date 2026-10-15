public class PromedioGastos {

    public static void main(String[] args) {
        double[] gastos = {30000, 45000, 20000, 10000};

        double total = 0;
        int mayores = 0;
        for (int i = 0; i < gastos.length; i++) {
            total += gastos[i];
            if (gastos[i] > 25000) {
                mayores++;
            }
        }

        double totalForEach = 0;
        for (double g : gastos) {
            totalForEach += g;
        }

        System.out.println("Total: " + total);
        System.out.println("Cantidad: " + gastos.length);
        System.out.println("Promedio: " + (totalForEach / gastos.length));
        System.out.println("Mayores que 25000: " + mayores);
    }
}

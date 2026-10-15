public class ArreglosBasicos {

    public static void main(String[] args) {
        String[] productos = {"Teclado", "Mouse", "Monitor"};

        System.out.println(productos[0]);
        System.out.println(productos[1]);
        System.out.println(productos[2]);
        System.out.println("Cantidad: " + productos.length);

        productos[1] = "Mouse inalámbrico";
        for (String p : productos) {
            System.out.println(p);
        }

        int[] cantidades = new int[4];
        cantidades[0] = 5;
        cantidades[1] = 8;
        cantidades[2] = 2;
        cantidades[3] = 10;
        System.out.println(cantidades[2]);
        System.out.println(cantidades.length);

        String[] tipos = {"INGRESO", "GASTO"};
        for (String tipo : tipos) {
            System.out.println(tipo);
        }
    }
}

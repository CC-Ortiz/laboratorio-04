import java.util.ArrayList;
import java.util.List;

public class ListaProductos {

    public static void main(String[] args) {
        List<String> productos = new ArrayList<>();

        productos.add("Teclado");
        productos.add("Mouse");
        productos.add("Monitor");

        System.out.println(productos);
        System.out.println("Cantidad: " + productos.size());

        productos.set(1, "Mouse inalámbrico");
        System.out.println("Primero: " + productos.get(0));
        System.out.println("¿Hay monitor? " + productos.contains("Monitor"));
        productos.remove("Monitor");
        System.out.println("Después: " + productos);

        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i));
        }

        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Ana");
        nombres.remove("Ana");
        System.out.println(nombres);

        List<Integer> cantidades = new ArrayList<>();
        cantidades.add(5);
        cantidades.add(8);
        System.out.println(cantidades.get(0));

    }
}

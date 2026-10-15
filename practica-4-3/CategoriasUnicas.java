import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoriasUnicas {

    public static void main(String[] args) {
        Set<String> categorias = new HashSet<>();

        categorias.add("Transporte");
        categorias.add("Alimentación");
        categorias.add("Transporte");
        categorias.add("Salud");

        System.out.println("Cantidad: " + categorias.size());
        System.out.println("¿Hay transporte? " + categorias.contains("Transporte"));

        for (String categoria : categorias) {
            System.out.println(categoria);
        }

        List<Movimiento> movimientos = new ArrayList<>();
        movimientos.add(new Movimiento("GASTO", "Transporte", 30000));
        movimientos.add(new Movimiento("GASTO", "Transporte", 20000));
        movimientos.add(new Movimiento("GASTO", "Salud", 40000));

        Set<String> usadas = new HashSet<>();
        for (Movimiento m : movimientos) {
            if (m.getTipo().equals("GASTO")) {
                usadas.add(m.getCategoria());
            }
        }
        System.out.println("Categorías diferentes de gasto: " + usadas.size());
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReporteFinanciero {

    public static void main(String[] args) {
        List<Movimiento> movimientos = new ArrayList<>();
        movimientos.add(new Movimiento("INGRESO", "Salario", 2000000));
        movimientos.add(new Movimiento("GASTO", "Transporte", 60000));
        movimientos.add(new Movimiento("GASTO", "Alimentación", 250000));
        movimientos.add(new Movimiento("INGRESO", "Otros", 150000));
        movimientos.add(new Movimiento("GASTO", "Transporte", 40000));
        movimientos.add(new Movimiento("GASTO", "Salud", 90000));

        Set<String> todas = new HashSet<>();
        Set<String> deGastos = new HashSet<>();
        Map<String, Double> totales = new HashMap<>();

        for (Movimiento m : movimientos) {
            todas.add(m.getCategoria());
            if (m.getTipo().equals("GASTO")) {
                deGastos.add(m.getCategoria());
                totales.put(m.getCategoria(),
                        totales.getOrDefault(m.getCategoria(), 0.0) + m.getValor());
            }
        }

        System.out.println("Todas las categorías: " + todas);
        System.out.println("Categorías de gastos: " + deGastos);
        System.out.println("Gastos por categoría:");
        for (Map.Entry<String, Double> e : totales.entrySet()) {
            System.out.println("  " + e.getKey() + ": $" + e.getValue());
        }
        System.out.println("Categorías de gasto distintas: " + deGastos.size());
    }
}

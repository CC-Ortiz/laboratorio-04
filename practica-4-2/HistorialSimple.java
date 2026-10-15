import java.util.ArrayList;
import java.util.List;

public class HistorialSimple {

    public static void main(String[] args) {
        List<Movimiento> movimientos = new ArrayList<>();

        movimientos.add(new Movimiento("INGRESO", "Salario", 1500000));
        movimientos.add(new Movimiento("GASTO", "Transporte", 30000));
        movimientos.add(new Movimiento("GASTO", "Alimentación", 45000));

        for (Movimiento movimiento : movimientos) {
            System.out.println(
                movimiento.getTipo() + " | "
                + movimiento.getCategoria() + " | $"
                + movimiento.getValor()
            );
        }

        System.out.println("Movimientos: " + movimientos.size());

        double totalGastos = 0;
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals("GASTO")) {
                totalGastos += movimiento.getValor();
            }
        }
        System.out.println("Total de gastos: " + totalGastos);

        List<Movimiento> copia = new ArrayList<>(movimientos);
        copia.remove(0);
        System.out.println("Original: " + movimientos.size());
        System.out.println("Copia: " + copia.size());
    }
}

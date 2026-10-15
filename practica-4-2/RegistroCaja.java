import java.util.ArrayList;
import java.util.List;

public class RegistroCaja {

    public static void main(String[] args) {
        List<Movimiento> movimientos = new ArrayList<>();

        movimientos.add(new Movimiento("INGRESO", "Ventas", 500000));
        movimientos.add(new Movimiento("GASTO", "Proveedores", 120000));
        movimientos.add(new Movimiento("INGRESO", "Servicios", 80000));
        movimientos.add(new Movimiento("GASTO", "Transporte", 30000));

        double totalIngresos = 0;
        double totalGastos = 0;

        for (int i = 0; i < movimientos.size(); i++) {
            Movimiento m = movimientos.get(i);
            System.out.println((i + 1) + ". " + m.getTipo() + " | " + m.getCategoria()
                    + " | $" + m.getValor());

            if (m.getTipo().equals("INGRESO")) {
                totalIngresos += m.getValor();
            } else {
                totalGastos += m.getValor();
            }
        }

        System.out.println("Total de ingresos: " + totalIngresos);
        System.out.println("Total de gastos: " + totalGastos);
        System.out.println("Cantidad de movimientos: " + movimientos.size());
    }
}

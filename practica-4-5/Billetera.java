import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Billetera con historial. Mantiene saldo, contadores, acumulados y la lista de
 * movimientos. No usa Scanner ni imprime menús.
 */
public class Billetera {

    private final String titular;
    private double saldo;
    private int cantidadIngresos;
    private double totalIngresos;
    private int cantidadGastos;
    private double totalGastos;
    private final List<Movimiento> movimientos; // propia de cada instancia (no static)

    public Billetera(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("El titular es obligatorio.");
        }
        this.titular = titular.trim();
        this.saldo = 0;
        this.cantidadIngresos = 0;
        this.totalIngresos = 0;
        this.cantidadGastos = 0;
        this.totalGastos = 0;
        this.movimientos = new ArrayList<>();
    }

    // ---------------- Consultas básicas ----------------

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getCantidadIngresos() {
        return cantidadIngresos;
    }

    public int getCantidadGastos() {
        return cantidadGastos;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public double getTotalGastos() {
        return totalGastos;
    }

    // ---------------- Operaciones ----------------

    /** true si se registró; false si se rechazó (no cambia saldo, contadores ni historial). */
    public boolean registrarIngreso(double valor, String categoria) {
        if (!esMontoValido(valor) || !esCategoriaValida(categoria)) {
            return false;
        }

        // Se crea primero el movimiento: si algo fallara, aún no se modificó ningún dato.
        Movimiento movimiento = new Movimiento(Movimiento.INGRESO, categoria, valor);

        saldo += valor;
        cantidadIngresos++;
        totalIngresos += valor;
        movimientos.add(movimiento);
        return true;
    }

    /** true si se registró; false si se rechazó (no cambia saldo, contadores ni historial). */
    public boolean registrarGasto(double valor, String categoria) {
        if (!esMontoValido(valor) || !esCategoriaValida(categoria) || valor > saldo) {
            return false;
        }

        Movimiento movimiento = new Movimiento(Movimiento.GASTO, categoria, valor);

        saldo -= valor;
        cantidadGastos++;
        totalGastos += valor;
        movimientos.add(movimiento);
        return true;
    }

    // ---------------- Historial y reportes ----------------

    /** Copia del historial en orden de registro; modificarla no altera la lista interna. */
    public List<Movimiento> getMovimientos() {
        return new ArrayList<>(movimientos);
    }

    public int getCantidadMovimientos() {
        return movimientos.size();
    }

    /**
     * Movimientos de un tipo, en orden de registro.
     * @throws IllegalArgumentException si el tipo no es INGRESO ni GASTO.
     */
    public List<Movimiento> buscarPorTipo(String tipo) {
        if (tipo == null || !(tipo.equals(Movimiento.INGRESO) || tipo.equals(Movimiento.GASTO))) {
            throw new IllegalArgumentException("Tipo no reconocido: use INGRESO o GASTO.");
        }

        List<Movimiento> encontrados = new ArrayList<>();
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals(tipo)) {
                encontrados.add(movimiento);
            }
        }
        return encontrados;
    }

    /** Todas las categorías usadas (ingresos y gastos), sin repetir. */
    public Set<String> getCategoriasUtilizadas() {
        Set<String> categorias = new HashSet<>();
        for (Movimiento movimiento : movimientos) {
            categorias.add(movimiento.getCategoria());
        }
        return categorias;
    }

    /** Total gastado por categoría; solo incluye movimientos GASTO. Vacío si no hay gastos. */
    public Map<String, Double> gastosPorCategoria() {
        Map<String, Double> totales = new HashMap<>();
        for (Movimiento movimiento : movimientos) {
            if (movimiento.getTipo().equals(Movimiento.GASTO)) {
                double acumulado = totales.getOrDefault(movimiento.getCategoria(), 0.0);
                totales.put(movimiento.getCategoria(), acumulado + movimiento.getValor());
            }
        }
        return totales;
    }

    // ---------------- Validaciones privadas ----------------

    private boolean esMontoValido(double valor) {
        return Double.isFinite(valor) && valor > 0;
    }

    private boolean esCategoriaValida(String categoria) {
        return categoria != null && !categoria.isBlank();
    }
}

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/** Interacción con el usuario: menú, lectura de datos y presentación de resultados. */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String titular = leerLinea(scanner, "Nombre del titular: ");
        while (titular.isEmpty()) {
            titular = leerLinea(scanner, "El nombre es obligatorio. Intenta nuevamente: ");
        }

        Billetera billetera = new Billetera(titular);
        int opcion;

        do {
            mostrarMenu(billetera);
            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1 -> registrarIngreso(scanner, billetera);
                case 2 -> registrarGasto(scanner, billetera);
                case 3 -> System.out.println("Saldo actual: $" + formato(billetera.getSaldo()));
                case 4 -> mostrarHistorial(billetera);
                case 5 -> consultarPorTipo(scanner, billetera);
                case 6 -> mostrarCategorias(billetera);
                case 7 -> mostrarResumen(billetera);
                case 0 -> System.out.println("Programa finalizado.");
                case -1 -> System.out.println("Debes ingresar una opción numérica.");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // ---------------- Menú ----------------

    static void mostrarMenu(Billetera billetera) {
        System.out.println();
        System.out.println("================================");
        System.out.println("       MI BILLETERA JAVA");
        System.out.println("================================");
        System.out.println("Titular: " + billetera.getTitular());
        System.out.println("Saldo disponible: $" + formato(billetera.getSaldo()));
        System.out.println();
        System.out.println("1. Registrar ingreso");
        System.out.println("2. Registrar gasto");
        System.out.println("3. Consultar saldo");
        System.out.println("4. Mostrar movimientos");
        System.out.println("5. Consultar movimientos por tipo");
        System.out.println("6. Consultar categorías utilizadas");
        System.out.println("7. Resumen financiero");
        System.out.println("0. Salir");
        System.out.println();
    }

    // ---------------- Opciones ----------------

    static void registrarIngreso(Scanner scanner, Billetera billetera) {
        String categoria = leerLinea(scanner, "Categoría: ");
        if (categoria.isEmpty()) {
            System.out.println("La categoría no puede estar vacía. Ingreso no registrado.");
            return;
        }

        double valor = leerMonto(scanner, "Valor: ");
        if (Double.isNaN(valor)) {
            System.out.println("Debes escribir un monto numérico.");
        } else if (billetera.registrarIngreso(valor, categoria)) {
            System.out.println("Ingreso registrado.");
        } else {
            System.out.println("El monto debe ser positivo y finito. Ingreso no registrado.");
        }
    }

    static void registrarGasto(Scanner scanner, Billetera billetera) {
        String categoria = leerLinea(scanner, "Categoría: ");
        if (categoria.isEmpty()) {
            System.out.println("La categoría no puede estar vacía. Gasto no registrado.");
            return;
        }

        double valor = leerMonto(scanner, "Valor: ");
        if (Double.isNaN(valor)) {
            System.out.println("Debes escribir un monto numérico.");
        } else if (billetera.registrarGasto(valor, categoria)) {
            System.out.println("Gasto registrado.");
        } else if (Double.isFinite(valor) && valor > billetera.getSaldo()) {
            System.out.println("Saldo insuficiente. Gasto no registrado.");
        } else {
            System.out.println("El monto debe ser positivo y finito. Gasto no registrado.");
        }
    }

    static void mostrarHistorial(Billetera billetera) {
        List<Movimiento> movimientos = billetera.getMovimientos();

        System.out.println();
        System.out.println("================================");
        System.out.println("           HISTORIAL");
        System.out.println("================================");

        if (movimientos.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }
        imprimirMovimientos(movimientos);
    }

    static void consultarPorTipo(Scanner scanner, Billetera billetera) {
        String tipo = leerLinea(scanner, "Tipo (INGRESO o GASTO): ").toUpperCase();

        if (!tipo.equals(Movimiento.INGRESO) && !tipo.equals(Movimiento.GASTO)) {
            System.out.println("Tipo no reconocido. Escribe INGRESO o GASTO.");
            return;
        }

        List<Movimiento> encontrados = billetera.buscarPorTipo(tipo);

        System.out.println();
        System.out.println("Movimientos de tipo " + tipo + ":");
        if (encontrados.isEmpty()) {
            System.out.println("No hay movimientos de ese tipo.");
        } else {
            imprimirMovimientos(encontrados);
        }
    }

    static void mostrarCategorias(Billetera billetera) {
        Set<String> categorias = billetera.getCategoriasUtilizadas();

        System.out.println();
        if (categorias.isEmpty()) {
            System.out.println("Aún no se han utilizado categorías.");
            return;
        }

        System.out.println("Categorías utilizadas (" + categorias.size() + "):");
        for (String categoria : new TreeSet<>(categorias)) { // TreeSet solo para presentar ordenado
            System.out.println("- " + categoria);
        }
    }

    static void mostrarResumen(Billetera billetera) {
        System.out.println();
        System.out.println("================================");
        System.out.println("       RESUMEN FINANCIERO");
        System.out.println("================================");
        System.out.println("Titular: " + billetera.getTitular());
        System.out.println("Saldo: $" + formato(billetera.getSaldo()));
        System.out.println("Ingresos realizados: " + billetera.getCantidadIngresos());
        System.out.println("Total ingresado: $" + formato(billetera.getTotalIngresos()));
        System.out.println("Gastos realizados: " + billetera.getCantidadGastos());
        System.out.println("Total gastado: $" + formato(billetera.getTotalGastos()));
        System.out.println();
        System.out.println("Gastos por categoría:");

        Map<String, Double> gastos = billetera.gastosPorCategoria();
        if (gastos.isEmpty()) {
            System.out.println("Sin gastos registrados.");
        } else {
            for (Map.Entry<String, Double> entrada : new TreeMap<>(gastos).entrySet()) {
                System.out.println(entrada.getKey() + ": $" + formato(entrada.getValue()));
            }
        }
    }

    static void imprimirMovimientos(List<Movimiento> movimientos) {
        for (int i = 0; i < movimientos.size(); i++) {
            Movimiento m = movimientos.get(i);
            System.out.println((i + 1) + ". " + m.getTipo() + " | "
                    + m.getCategoria() + " | $" + formato(m.getValor()));
        }
    }

    // ---------------- Lectura segura (solo nextLine + parse) ----------------

    static String leerLinea(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        if (!scanner.hasNextLine()) {
            System.out.println();
            System.out.println("Entrada finalizada. Programa terminado.");
            System.exit(0);
        }
        return scanner.nextLine().trim();
    }

    /** Devuelve la opción, -1 si el texto no es un entero, 99 si es negativa. */
    static int leerOpcion(Scanner scanner) {
        String entrada = leerLinea(scanner, "Seleccione una opción: ");
        try {
            int opcion = Integer.parseInt(entrada);
            return opcion < 0 ? 99 : opcion;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /** Devuelve el monto escrito, o NaN si el texto no es numérico. */
    static double leerMonto(Scanner scanner, String mensaje) {
        String entrada = leerLinea(scanner, mensaje);
        try {
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    /** Muestra el número sin notación científica. */
    static String formato(double valor) {
        String texto = BigDecimal.valueOf(valor).toPlainString();
        return texto.contains(".") ? texto : texto + ".0";
    }
}

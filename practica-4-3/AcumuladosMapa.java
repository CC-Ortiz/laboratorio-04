import java.util.HashMap;
import java.util.Map;

public class AcumuladosMapa {

    public static void main(String[] args) {
        Map<String, Double> totales = new HashMap<>();

        String categoria = "Transporte";
        double valor = 30000;

        double anterior = totales.getOrDefault(categoria, 0.0);
        totales.put(categoria, anterior + valor);

        valor = 45000;
        anterior = totales.getOrDefault(categoria, 0.0);
        totales.put(categoria, anterior + valor);

        System.out.println("Transporte: $" + totales.get("Transporte"));

        for (Map.Entry<String, Double> entrada : totales.entrySet()) {
            System.out.println(entrada.getKey() + ": $" + entrada.getValue());
        }
    }
}

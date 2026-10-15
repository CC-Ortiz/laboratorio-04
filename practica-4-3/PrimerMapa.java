import java.util.HashMap;
import java.util.Map;

public class PrimerMapa {

    public static void main(String[] args) {
        Map<String, Double> gastos = new HashMap<>();

        gastos.put("Transporte", 30000.0);
        gastos.put("Alimentación", 45000.0);

        System.out.println(gastos.get("Transporte"));
        System.out.println(gastos.containsKey("Salud"));

        gastos.put("Transporte", 50000.0);

        System.out.println(gastos.get("Transporte"));
        System.out.println("Categorías: " + gastos.size());

        Map<String, Double> valores = new HashMap<>();
        valores.put("Salud", 10000.0);
        valores.put("Salud", 20000.0);
        valores.put("Transporte", 5000.0);
        System.out.println(valores.get("Salud"));
        System.out.println(valores.size());

        double salud = gastos.getOrDefault("Salud", 0.0);
        System.out.println("Salud: " + salud);
    }
}

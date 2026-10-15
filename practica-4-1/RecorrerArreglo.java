public class RecorrerArreglo {

    public static void main(String[] args) {
        String[] categorias = {"Transporte", "Alimentación", "Salud"};

        for (int i = 0; i < categorias.length; i++) {
            System.out.println(i + " -> " + categorias[i]);
        }

        for (String categoria : categorias) {
            System.out.println(categoria);
        }
    }
}

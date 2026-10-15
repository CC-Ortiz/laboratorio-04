public class PruebaProducto {

    public static void main(String[] args) {
        try {
            ProductoValidado producto = new ProductoValidado("Teclado", -500);
            System.out.println(producto.getNombre());
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo crear: " + e.getMessage());
        }

        try {
            int numero = Integer.parseInt("abc");
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println("No se pudo convertir.");
        } finally {
            System.out.println("Terminó el intento de conversión.");
        }

        try {
            int opcion = Integer.parseInt("hola");
            System.out.println(opcion);
        } catch (NumberFormatException e) {
            System.out.println("Entrada incorrecta.");
        }
    }
}

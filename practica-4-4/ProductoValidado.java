public class ProductoValidado {

    private final String nombre;
    private final double precio;

    public ProductoValidado(String nombre, double precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre obligatorio.");
        }

        if (!Double.isFinite(precio) || precio <= 0) {
            throw new IllegalArgumentException("Precio inválido.");
        }

        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

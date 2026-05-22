/**
 * Representa una biblioteca con un nombre, una ciudad y una capacidad máxima de libros.
 * Permite agregar y retirar libros, consultar el espacio disponible y el porcentaje de ocupación.
 *
 * @author Helen
 * @version 1.0
 * @since 2025
 */
public class Biblioteca {

    /** Nombre de la biblioteca. */
    private String nombre;

    /** Ciudad donde se encuentra la biblioteca. */
    private String ciudad;

    /** Capacidad máxima de libros que puede almacenar la biblioteca. */
    private int capacidad;

    /** Cantidad actual de libros almacenados. */
    private int librosActuales;

    /**
     * Crea una nueva biblioteca con un nombre, ciudad y capacidad máxima.
     *
     * @param nombre Nombre de la biblioteca.
     * @param ciudad Ciudad donde está ubicada.
     * @param capacidad Número máximo de libros que puede almacenar.
     */
    public Biblioteca(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.librosActuales = 0;
    }

    /**
     * Agrega una cantidad de libros a la biblioteca si hay espacio suficiente.
     *
     * @param cantidad Número de libros a agregar.
     * @return true si se agregaron correctamente, false si la cantidad es inválida o no hay espacio.
     */
    public boolean agregarLibro(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        if (librosActuales + cantidad > capacidad) {
            return false;
        }
        librosActuales += cantidad;
        return true;
    }

    /**
     * Retira una cantidad de libros de la biblioteca si es posible.
     *
     * @param cantidad Número de libros a retirar.
     * @return true si se retiraron correctamente, false si la cantidad es inválida o supera los libros actuales.
     */
    public boolean retirarLibro(int cantidad) {
        if (cantidad <= 0 || cantidad > librosActuales) {
            return false;
        }
        librosActuales -= cantidad;
        return true;
    }

    /**
     * Obtiene el espacio disponible en la biblioteca.
     *
     * @return Número de libros que aún se pueden almacenar.
     */
    public int getEspacioDisponible() {
        return capacidad - librosActuales;
    }

    /**
     * Calcula el porcentaje de ocupación de la biblioteca.
     *
     * @return Porcentaje de ocupación entre 0 y 100.
     */
    public double getPorcentajeOcupacion() {
        if (capacidad == 0) return 0.0;
        return (librosActuales * 100.0) / capacidad;
    }

    /**
     * Indica si la biblioteca está llena.
     *
     * @return true si no queda espacio disponible, false en caso contrario.
     */
    public boolean estaLlena() {
        return librosActuales >= capacidad;
    }

    /** @return Nombre de la biblioteca. */
    public String getNombre() { return nombre; }

    /** @return Ciudad donde se encuentra la biblioteca. */
    public String getCiudad() { return ciudad; }

    /** @return Capacidad máxima de libros. */
    public int getCapacidad() { return capacidad; }

    /** @return Cantidad actual de libros almacenados. */
    public int getLibrosActuales() { return librosActuales; }

    /**
     * Devuelve una representación textual de la biblioteca.
     *
     * @return Cadena con el formato: "Nombre (Ciudad) - librosActuales/capacidad libros".
     */
    @Override
    public String toString() {
        return nombre + " (" + ciudad + ") - " + librosActuales + "/" + capacidad + " libros";
    }
}

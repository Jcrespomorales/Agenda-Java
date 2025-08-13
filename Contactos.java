public class Contactos {
    private String nombre;
    private String email;
    private int telefono;

    public Contactos(String nombre, String email, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Funciones para obtener datos privados
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public int getTelefono() {
        return telefono;
    }

    // Funciones para modificar datos privados
    public void setNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }
    public void setEmail(String nuevoEmail) {
        nombre = nuevoEmail;
    }
    public void setTelefono(String nuevoTelefono) {
        nombre = nuevoTelefono;
    }
    

    @Override
    public String toString() {
        System.out.println("\nNuevo contacto creado");
        System.out.println("----------------------");
        return "\nNombre: " + nombre + "\nEmail: " + email + "\nTeléfono: " + telefono;

}
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AgendaContactos {

    public static void main(String[] args) {

        Scanner scannerInput = new Scanner(System.in);

        var opcionesAgenda = new HashMap<Integer, String>();
        opcionesAgenda.put(1, "Añadir contacto");
        opcionesAgenda.put(2, "Editar contacto");
        opcionesAgenda.put(3, "Buscar contacto");
        opcionesAgenda.put(4, "Mostrar todos los contactos");
        opcionesAgenda.put(5, "Guardar en local");
        opcionesAgenda.put(6, "Eliminar contacto");
        opcionesAgenda.put(0, "Salir");

        int opcionElegida = 999;

        var listaContactos = new ArrayList<Contactos>();

        // Menú Inicio
        System.out.println("\nAgenda de contactos");
        System.out.println("-------------------");
        for (var entry : opcionesAgenda.entrySet()) {
            if (entry.getKey() != 0) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        System.out.println("0 - " + opcionesAgenda.get(0));

                
        while (!opcionesAgenda.containsKey(opcionElegida)) {            
            System.out.println("\nPor favor elige una opcion del 1 al 6");
            System.out.println("Si desea salir pulse 0"); 
            opcionElegida = scannerInput.nextInt();
            scannerInput.nextLine();
        }

        switch (opcionElegida) {
            case 0:
                System.out.println("\nSaliendo de la aplicación....\nAdios!!");            
                break;
            case 1:
                System.out.println("\nHa elegido la opción de Añadir contactos");
                System.out.println("Introduce el nombre del contacto: ");
                String nombreContacto = scannerInput.nextLine();
                System.out.println("Nombre: " + nombreContacto);
                System.out.println("Introduce una dirección de email: ");
                String emailContacto = scannerInput.nextLine();
                System.out.println("Introduce un telefono");
                int telefonoContacto = scannerInput.nextInt();
                Contactos x = new Contactos(nombreContacto, emailContacto, telefonoContacto);
                System.out.println("Nombre: " + x.getNombre() + "\nEmail: " + x.getEmail() + "\nTeléfono: " + x.getTelefono() );
                listaContactos.add(x);
                System.out.println(listaContactos.get(0));
                
                
        



                break;
            case 2:
                System.out.println("\nHa elegido la opción de ");
                break;
            case 3:
                System.out.println("\nHa elegido la opción de ");
                break;
            case 4:
                System.out.println("\nHa elegido la opción de ");
                break;
            case 5:
                System.out.println("\nHa elegido la opción de ");
                break;
            case 6:
                System.out.println("\nHa elegido la opción de ");
                break;
        
            default:
                break;
        }

        scannerInput.close();
    }

    // Función para elegir una opción del menú Inicio
    public static int elegirOpcion(Scanner scannerInput) {
        int opcionElegida = scannerInput.nextInt();
        return opcionElegida;
    }

    // Función añadir contactos
    public static void añadirContactos() {
        System.out.println("Introduce el nombre: ");
        
    }

    

}



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AgendaContactos {

    public static void main(String[] args) {

        // Variables 
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
        String nuevoContacto = "";

        

        // Menú Inicio
        switch (menuInicio(scannerInput, opcionesAgenda, opcionElegida)) {
            case 0:
                System.out.println("\nSaliendo de la aplicación....\nAdios!!");            
                break;
            case 1:
                añadirContactos(scannerInput, listaContactos, nuevoContacto, opcionElegida, opcionesAgenda);
                break;
            case 2:
                System.out.println("\nHa elegido la opción de ");
                break;
            case 3:
                System.out.println("\nHa elegido la opción de ");
                break;
            case 4:
                mostrarContactos(listaContactos);
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

    
    // Función de Menú de Inicio
    public static int menuInicio(Scanner scannerInput, HashMap<Integer, String> opcionesAgenda, int opcionElegida ) {
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
        return opcionElegida;
    }


    // Función añadir contactos
    public static void añadirContactos(Scanner scannerInput, ArrayList<Contactos> listaContactos, String nuevoContacto, int opcionElegida, HashMap<Integer, String> opcionesAgenda) {            
            System.out.println("\nHa elegido la opción de Añadir contactos");
            System.out.println("Introduce el nombre del contacto: ");
            String nombreContacto = scannerInput.nextLine();
            System.out.println("Introduce una dirección de email: ");
            String emailContacto = scannerInput.nextLine();
            System.out.println("Introduce un telefono");
            int telefonoContacto = scannerInput.nextInt();
            scannerInput.nextLine();
            listaContactos.add(new Contactos(nombreContacto, emailContacto, telefonoContacto));
            System.out.println("\nNuevo conctacto añadido con exito:");
            System.out.println("Nombre: " + listaContactos.getLast().getNombre() + "\nEmail: " + listaContactos.getLast().getEmail() + "\nTeléfono : " + listaContactos.getLast().getTelefono());
            System.out.println("\nIntroduce N para crear un nuevo contacto o cualquier tecla para volver al menu principal");
            nuevoContacto = scannerInput.nextLine().toUpperCase();
            if (nuevoContacto.equals("N")) {
                añadirContactos(scannerInput, listaContactos, nuevoContacto, opcionElegida, opcionesAgenda);
                
            } else {
                menuInicio(scannerInput, opcionesAgenda, opcionElegida);                                
            }
            
        
        
    }

    // Función mostrar todos los contactos
    public static void mostrarContactos(ArrayList<Contactos> listaContactos) {
        for (Object conctacto : listaContactos) {
            System.out.println(conctacto);
            
        }
    }

    

}



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
                editarContactos(null, scannerInput, nuevoContacto, listaContactos);
                
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

    public static void editarContactos(Contactos contactoEditable, Scanner scannerInput, String nuevoContacto, ArrayList<Contactos> listaContactos) {
        System.out.println("\nEditar contactos");
        System.out.println("-----------------");
        System.out.println("Escribe el nombre del contacto que quieres editar:");
        String nombreBuscado = scannerInput.nextLine();
        boolean encontrado = false;
        for (Contactos contacto : listaContactos) {
            if (nombreBuscado.equalsIgnoreCase(contacto.getNombre())) {
                System.out.println("Indica el nuevo nombre para el contacto: ");
                String nuevoNombre = scannerInput.nextLine();
                contacto.setNombre(nuevoNombre);
                System.out.println("Contacto actualizado:");
                System.out.println(contacto);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado ningún usuario con el nombre " + nombreBuscado);
        }
    }

    // Función mostrar todos los contactos
    public static void mostrarContactos(ArrayList<Contactos> listaContactos) {
        System.out.println("Mostrar contactos");
        System.out.println("---------------");
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contactos contacto : listaContactos) {
                System.out.println(contacto.getNombre());
            }
        }
    }

    

}



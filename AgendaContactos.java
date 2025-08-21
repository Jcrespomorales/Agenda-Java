import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
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
        String crearNuevoContacto = "";

        
        // Menú Inicio
        menuInicio(scannerInput, opcionesAgenda, opcionElegida, crearNuevoContacto, listaContactos);

        scannerInput.close();
    }

    
    // Función de Menú de Inicio
    public static void menuInicio(Scanner scannerInput, HashMap<Integer, String> opcionesAgenda, int opcionElegida, String crearNuevoContacto, ArrayList<Contactos> listaContactos) {
        opcionElegida = 999;
        System.out.println("\nAgenda de contactos");
        System.out.println("-------------------");
        for (var entry : opcionesAgenda.entrySet()) {
            if (entry.getKey() != 0) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        System.out.println("0 - " + opcionesAgenda.get(0)); 
        try {
            while (!opcionesAgenda.containsKey(opcionElegida)) {            
                System.out.println("\nPor favor elige una opcion del 1 al 6");
                System.out.println("Si desea salir pulse 0"); 
                opcionElegida = scannerInput.nextInt();
                scannerInput.nextLine();
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Ingresa un número, ningún otro caracter es válido"); 
            intervaloTiempo(1000);  
            scannerInput.nextLine();
            menuInicio(scannerInput, opcionesAgenda, opcionElegida, crearNuevoContacto, listaContactos);
        }
        switch (opcionElegida) {
            case 0:
                System.out.println("\nSaliendo de la aplicación....\nAdios!!");            
                break;
            case 1:
                añadirContactos(scannerInput, listaContactos, crearNuevoContacto, opcionElegida, opcionesAgenda);
                menuInicio(scannerInput, opcionesAgenda, opcionElegida, crearNuevoContacto, listaContactos);
                break;
            case 2:
                editarContactos(null, scannerInput, listaContactos);
                menuInicio(scannerInput, opcionesAgenda, opcionElegida, crearNuevoContacto, listaContactos);
                
            case 3:
                buscarContacto(listaContactos, scannerInput);
                menuInicio(scannerInput, opcionesAgenda, opcionElegida, crearNuevoContacto, listaContactos);
                break;
            case 4:
                mostrarContactos(listaContactos);
                menuInicio(scannerInput, opcionesAgenda, opcionElegida, crearNuevoContacto, listaContactos);
                break;
            case 5:
                guardarContactosEnArchivo(listaContactos);
                menuInicio(scannerInput, opcionesAgenda, opcionElegida, crearNuevoContacto, listaContactos);
                break;
            case 6:
                eliminarContacto(listaContactos, scannerInput);
                menuInicio(scannerInput, opcionesAgenda, opcionElegida, crearNuevoContacto, listaContactos);
                break;
        
            default:
                break;
        }

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
                System.out.println("\nVolviendo al menú principal....");                               
            } 
            intervaloTiempo(2000);  
    }

    // Función editar contacto
    public static void editarContactos(Contactos contactoEditable, Scanner scannerInput, ArrayList<Contactos> listaContactos) {
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
        System.out.println("\nVolviendo al menú principal....");                                       
        intervaloTiempo(2000);  
    }

    // Función buscar contacto
    public static void buscarContacto(ArrayList<Contactos> listaContactos, Scanner scannerInput) {
        System.out.println("\nBuscar contacto");
        System.out.println("---------------");
        System.out.println("Ingresa el nombre del contacto que buscas: ");
        String contactoBuscado = scannerInput.nextLine();        
        for (Contactos contacto : listaContactos) {
            if (contactoBuscado.toLowerCase().equals(contacto.getNombre().toLowerCase())) {
                System.out.println("\nNombre: " + contacto.getNombre() + "\nEmail: " + contacto.getEmail() + "\nTeléfono: " + contacto.getTelefono());                
            } else {
                System.out.println("No se ha encontrado ningún contacto con ese nombre");                
            }
            
        }
        System.out.println("\nVolviendo al menú principal....");                                       
        intervaloTiempo(2000);   
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
                System.out.println(" - " + contacto.getNombre());
            }
        }
        System.out.println("\nVolviendo al menú principal....");                                       
        intervaloTiempo(2000);
    }


    // Guardar contactos en un archivo local
    public static void guardarContactosEnArchivo(ArrayList<Contactos> listaContactos) {
        String rutaEscritorio = System.getProperty("user.home") + "\\Desktop\\contactos_agenda.txt";
        try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(rutaEscritorio))) {
            for (Contactos contacto : listaContactos) {
                writer.write(contacto.toString());
                writer.newLine();
                writer.write("----------------------");
                writer.newLine();
            }
            System.out.println("Contactos guardados en: " + rutaEscritorio);
        } catch (Exception e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        }
    }

    // Función eliminar contacto
    public static void eliminarContacto(ArrayList<Contactos> listaContactos, Scanner scanerInput) {
        System.out.println("\nEliminar contacto");
        System.out.println("-----------------");
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            System.out.println("Ingresa el nombre del contacto que quieres eliminar: ");
            String nombreEliminable = scanerInput.nextLine();
            for (int i = 0; i < listaContactos.size(); i++) {
                if (listaContactos.get(i).getNombre().toLowerCase().equals(nombreEliminable.toLowerCase())) {
                    listaContactos.remove(i);
                    System.out.println("Contacto eliminado con exito: " + nombreEliminable);
                } else {
                    System.out.println("No hay ningún contacto en la lista con este nombre : " + nombreEliminable);
                }
                System.out.println("\nVolviendo al menú principal....");                                       
                intervaloTiempo(2000);
            }                
        }
                
            
        

    }




    // Función intervalo de tiempo
    public static void intervaloTiempo(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   
    }

    

}



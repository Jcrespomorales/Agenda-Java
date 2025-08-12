import java.util.ArrayList;
import java.util.Scanner;

public class AgendaContactos {

    public static void main(String[] args) {

        Scanner scannerInput = new Scanner(System.in);
        ArrayList<Integer> opcionesAgenda = new ArrayList<>();
        opcionesAgenda.add(0);
        opcionesAgenda.add(1);
        opcionesAgenda.add(2);
        opcionesAgenda.add(3);
        opcionesAgenda.add(4);
        opcionesAgenda.add(5);
        opcionesAgenda.add(6);
        int opcionElegida = 999;

        // Menú Inicio
        System.out.println("Agenda de contactos");
        System.out.println("-------------------");
        System.out.println("\n1- Añadir contacto");
        System.out.println("2- Editar contacto");
        System.out.println("3- Buscar contacto");
        System.out.println("4- Mostrar todos los contactos");
        System.out.println("5- Guardar en local");
        System.out.println("6- Eliminar contacto");
        System.out.println("0- Salir");    
                
        while (!opcionesAgenda.contains(opcionElegida)) {            
            System.out.println("\nPor favor elige una opcion del 1 al 6");
            System.out.println("Si desea salir pulse 0"); 
            opcionElegida = scannerInput.nextInt();
        }

        switch (opcionElegida) {
            case 0:
                System.out.println("\nSaliendo de la aplicación....\nAdios!!");            
                break;
            case 1:
                System.out.println("\nHa elegido la opción de ");
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

}



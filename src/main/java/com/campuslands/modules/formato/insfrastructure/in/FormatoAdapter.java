package com.campuslands.modules.formato.insfrastructure.in;

import java.util.Scanner;

import com.campuslands.modules.formato.aplication.FormatoService;
import com.campuslands.modules.formato.domain.models.Formato;
import com.campuslands.modules.validation.InputVali;

public class FormatoAdapter {
     private final FormatoService formatoService;

    public FormatoAdapter(FormatoService formatoService) {
        this.formatoService = formatoService;
    }


     public void start() {
        InputVali inputVali = new InputVali();
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Formatos");
        System.out.println("1. Crear Actores");
        System.out.println("2. Actualizar Actores");
        System.out.println("3. Buscar Actores por ID");
        System.out.println("4. Eliminar Actores");
        System.out.println("5. Listar todos los Actores");
        System.out.println("6. Salir");
        System.out.println("");
        
        int choice = inputVali.readInt("Ingrese la opción: ");
        scanner.nextLine(); // Consumir el salto de línea
        
        switch (choice) {
            case 1:
                System.out.println("--- Menú de Creación de Actores ---");
                String descripcion = inputVali.stringNotNull("Ingrese el nombre del Actor: ");
                Formato newActor = new Formato(descripcion);
                formatoService.createFormato(newActor);
                System.out.println("Actor registrado exitosamente!!");
                break;
            
            case 2:
            System.out.println("--- Menú de Actualizacion de Actores ---");
            String descripcionUp = inputVali.stringNotNull("Ingrese el nombre del Actor: ");
            Formato formatoUp = new Formato(descripcionUp);
            formatoService.updateFormato(formatoUp);
            System.out.println("Actor registrado exitosamente!!");
            System.out.println("Actor ACtualizado exitosamente!!");
                break;
            
            case 3:
                    int id = inputVali.readInt("Ingrese el ID del aeropuerto a buscar: " );
                    formatoService.getFormatoById(id); 
                break;
            
            case 4:
                int deleteId = inputVali.readInt("Ingrese el ID del aeropuerto a eliminar: ");
                formatoService.deleteFormato(deleteId);;
                break;
            
            case 5:
                
                formatoService.getAllFormatos().forEach(a -> {
                    System.out.println("ID: " + a.getId() + ", descripcion: " + a.getDescription());
                    });
                break;
            
            case 6:
                scanner.close();
                System.exit(0);
                break;
            
            default:
                System.out.println("Opción inválida, inténtelo de nuevo.");
        }
    }
}
}

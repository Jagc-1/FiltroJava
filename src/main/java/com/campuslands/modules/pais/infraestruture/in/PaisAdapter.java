package com.campuslands.modules.pais.infraestruture.in;

import java.util.Scanner;

import com.campuslands.modules.pais.aplication.PaisService;
import com.campuslands.modules.pais.domain.models.Pais;
import com.campuslands.modules.validation.InputVali;

public class PaisAdapter {
      private final PaisService paisService;

    public PaisAdapter(PaisService paisService) {
        this.paisService = paisService;
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
                Pais newActor = new Pais(descripcion);
                paisService.createPais(newActor);
                System.out.println("Actor registrado exitosamente!!");
                break;
            
            case 2:
            System.out.println("--- Menú de Actualizacion de Actores ---");
            String descripcionUp = inputVali.stringNotNull("Ingrese el nombre del Actor: ");
            Pais formatoUp = new Pais(descripcionUp);
            paisService.updatePais(formatoUp);
            System.out.println("Actor registrado exitosamente!!");
            System.out.println("Actor ACtualizado exitosamente!!");
                break;
            
            case 3:
                    int id = inputVali.readInt("Ingrese el ID del aeropuerto a buscar: " );
                    paisService.getPaisById(id); 
                break;
            
            case 4:
                int deleteId = inputVali.readInt("Ingrese el ID del aeropuerto a eliminar: ");
                paisService.deletePais(deleteId);
                break;
            
            case 5:
                
                paisService.getAllPaises().forEach(a -> {
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

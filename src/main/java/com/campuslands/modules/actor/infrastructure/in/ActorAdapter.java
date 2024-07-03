package com.campuslands.modules.actor.infrastructure.in;

import java.util.Scanner;

import com.campuslands.modules.actor.aplication.ActorService;
import com.campuslands.modules.actor.domain.models.Actor;
import com.campuslands.modules.validation.InputVali;

public class ActorAdapter {
    private final ActorService actorService;

    public ActorAdapter(ActorService actorService) {
        this.actorService = actorService;
    }


     public void start() {
        InputVali inputVali = new InputVali();
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
        System.out.println("Menú de Gestión de Actores");
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
                String nombre = inputVali.stringNotNull("Ingrese el nombre del Actor: ");
                int idnacionalidad =  inputVali.readInt("Ingrese el ID de la nacionalidad del actor: ");
                int edad =  inputVali.readInt("Ingrese la edad del actor: ");
                int idgenero =  inputVali.readInt("Ingrese el ID del genero del actor: ");
                Actor newActor = new Actor(nombre, idnacionalidad, edad, idgenero);
                actorService.createActor(newActor);
                System.out.println("Actor registrado exitosamente!!");
                break;
            
            case 2:
            System.out.println("--- Menú de Creación de Actores ---");
                String nombreUp = inputVali.stringNotNull("Ingrese el nombre del Actor: ");
                int idnacionalidadUp =  inputVali.readInt("Ingrese el ID de la nacionalidad del actor: ");
                int edadUp =  inputVali.readInt("Ingrese la edad del actor: ");
                int idgeneroUp =  inputVali.readInt("Ingrese el ID del genero del actor: ");
                Actor updateActor = new Actor(nombreUp, idnacionalidadUp, edadUp, idgeneroUp);
                actorService.createActor(updateActor);
            System.out.println("Actor ACtualizado exitosamente!!");
                break;
            
            case 3:
                    int id = inputVali.readInt("Ingrese el ID del aeropuerto a buscar: " );
                    actorService.getActorById(id); 
                break;
            
            case 4:
                int deleteId = inputVali.readInt("Ingrese el ID del aeropuerto a eliminar: ");
                actorService.deleteActor(deleteId);
                break;
            
            case 5:
                
                actorService.getAllActors().forEach(a -> {
                    System.out.println("ID: " + a.getId() + ", nombre: " + a.getNombre() + ", id Nacionalidad: " + a.getIdnacionalidad()+ ", edad: " + a.getEdad()+ ", Id genero: " + a.getIdgenero());
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

package com.campuslands;

import com.campuslands.modules.actor.infrastructure.out.ActorOutModule;
import com.campuslands.modules.formato.insfrastructure.out.FormatoOutModule;
import com.campuslands.modules.pais.infraestruture.out.PaisOutModule;
import com.campuslands.modules.validation.InputVali;


public class Main {
    public static void main(String[] args) {
        

        boolean executing = true;
        InputVali inputVali = new InputVali();

        while (executing) {
            System.out.println("Qué acción desea realizar, digite una opcion numérica");
            int choice = inputVali.readInt(
                    ("1. Menú de Gestión de Actores \n2. Menú de Gestión de Formato \n3. Menú de Gestión de Pais \n4. Menú de Gestión de Formato\n5. \n6. \n7. \n8. \n0. Salir"));
            switch (choice) {
                case 1:
                    ActorOutModule actorOutModule = new ActorOutModule();
                    actorOutModule.module().start();
                break;
                case 2:
                    FormatoOutModule formatoOutModule = new FormatoOutModule();
                    formatoOutModule.module().start();
                    break;
                case 3:
                    PaisOutModule paisOutModule = new PaisOutModule();
                    paisOutModule.module().start();
                    break;
                case 4:

                break;
                case 5:

                break;
                case 6:

                break;
                case 7:

                break;
                case 8:
                case 0:
                    executing = false;
                    System.out.println("Gracias por usar nuestros servicios");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }
    }
}
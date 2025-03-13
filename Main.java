/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Facultad de Ingeniería
 * Departamento de Ciencias de la Computación
 * Curso: CC2016 – Algoritmos y Estructura de Datos
 * Autor: Danile Figueroa
 * Fecha: 12 de Marzo de 2025
 * 
 * Clase: Principal
 * Da un menú para la escoger una opcion de pokemon.
 */

 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Selecciona una implementación de Map: 1) HashMap, 2) TreeMap, 3) LinkedHashMap");
         int opcion = scanner.nextInt();
         scanner.nextLine();
 
         Pokedex gestor = new Pokedex(opcion);
 
         while (true) {
             System.out.println("\nMenu:");
             System.out.println("1. Agregar Pokémon a la pokedex");
             System.out.println("2. Mostrar datos un Pokemon");
             System.out.println("3. Mostrar tu equipo ordenado por tipos");
             System.out.println("4. Mostrar todos los Pokémon ordenados por tipos");
             System.out.println("5. Buscar Pokemon por habilidad (Pon una comilla antes del nombre de la habilidad)");
             System.out.println("6. Salir");
             System.out.print("Selecciona una opción: ");
             int eleccion = scanner.nextInt();
             scanner.nextLine();
 
             switch (eleccion) {
                 case 1:
                     System.out.print("Ingresa el nombre del Pokémon: ");
                     String nombre = scanner.nextLine();
                     gestor.agregarPokemonAColeccion(nombre);
                     break;
                 case 2:
                     System.out.print("Ingresa el nombre del Pokémon: ");
                     nombre = scanner.nextLine();
                     gestor.mostrarDatosPokemon(nombre);
                     break;
                 case 3:
                     gestor.mostrarColeccionOrdenadaPorTipo();
                     break;
                 case 4:
                     gestor.mostrarTodosLosPokemonOrdenadosPorTipo();
                     break;
                 case 5:
                     System.out.print("Ingresa la habilidad: ");
                     String habilidad = scanner.nextLine();
                     gestor.mostrarPokemonPorHabilidad(habilidad);
                     break;
                 case 6:
                     System.out.println("Saliste del programa :(");
                     return;
                 default:
                     System.out.println("Opción no valida.");
             }
         }
     }
 }
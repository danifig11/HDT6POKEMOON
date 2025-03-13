/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Facultad de Ingeniería
 * Departamento de Ciencias de la Computación
 * Curso: CC2016 – Algoritmos y Estructura de Datos
 * Autor: Danile Figueroa
 * Fecha: 12 de Marzo de 2025
 * 
 * Clase: Pokedex
 * Gestiona la carga y manipulación de los datos de Pokémon.
 */

 import java.io.*;
 import java.nio.file.*;
 import java.util.*;
 
 public class Pokedex {
     private Map<String, Pokemon> baseDeDatosPokemon;
     private Map<String, Pokemon> coleccionUsuario;
     private String rutaArchivoCSV = "pokemon_data_pokeapi.csv";
 
     public Pokedex(int opcionMapa) {
         this.baseDeDatosPokemon = FabricaMapas.obtenerMapa(opcionMapa);
         this.coleccionUsuario = new HashMap<>();
         cargarDatosPokemon();
     }
 
     private void cargarDatosPokemon() {
         try (BufferedReader br = Files.newBufferedReader(Paths.get(rutaArchivoCSV))) {
             String linea;
             String[] encabezados = br.readLine().split(","); 
 
             int posNombre = -1, posTipo1 = -1, posTipo2 = -1, posHabilidad = -1;
             for (int i = 0; i < encabezados.length; i++) {
                 String columna = encabezados[i].trim().toLowerCase();
                 if (columna.equals("name")) posNombre = i;
                 if (columna.equals("type1")) posTipo1 = i;
                 if (columna.equals("type2")) posTipo2 = i;
                 if (columna.equals("abilities")) posHabilidad = i;
             }
 
             if (posNombre == -1 || posTipo1 == -1 || posHabilidad == -1) {
                 System.out.println("Error: No se encontraron las columnas en el CSV.");
                 return;
             }
 
             while ((linea = br.readLine()) != null) {
                 String[] valores = linea.split(",");
 
                 if (valores.length > Math.max(posNombre, Math.max(posTipo1, Math.max(posTipo2, posHabilidad)))) {
                     String nombre = valores[posNombre].trim();
                     String tipo1 = valores[posTipo1].trim();
                     String tipo2 = (posTipo2 != -1 && !valores[posTipo2].trim().isEmpty()) ? valores[posTipo2].trim() : "Ninguno";
                     String habilidad = valores[posHabilidad].trim();
 
                     habilidad = String.join(", ", Arrays.stream(habilidad.split(","))
                                                 .map(String::trim)
                                                 .toArray(String[]::new));
 
                     Pokemon p = new Pokemon(nombre, tipo1, tipo2, habilidad);
                     baseDeDatosPokemon.put(nombre, p);
                 }
             }
         } catch (IOException e) {
             System.out.println("NO PUEDO LEER EL CSV AAAH!");
         }
     }
 
     public void agregarPokemonAColeccion(String nombre) {
         if (!baseDeDatosPokemon.containsKey(nombre)) {
             System.out.println("Mjmmm parece que ya está en tu pokédex");
             return;
         }
         if (coleccionUsuario.containsKey(nombre)) {
             System.out.println("Hey parece que ya lo tienes, el profesor Oak está orgulloso de ti");
             return;
         }
         coleccionUsuario.put(nombre, baseDeDatosPokemon.get(nombre));
         System.out.println(nombre + " WAUW, tu nuevo Pokémon ha sido agregado a la colección.");
     }
 
     public void mostrarDatosPokemon(String nombre) {
         if (baseDeDatosPokemon.containsKey(nombre)) {
             System.out.println(baseDeDatosPokemon.get(nombre));
         } else {
             System.out.println("Pokémon no encontrado.");
         }
     }
 
     public void mostrarColeccionOrdenadaPorTipo() {
         List<Pokemon> listaOrdenada = new ArrayList<>(coleccionUsuario.values());
         listaOrdenada.sort(Comparator.comparing(p -> p.tipo1));
         listaOrdenada.forEach(System.out::println);
     }
 
     public void mostrarTodosLosPokemonOrdenadosPorTipo() {
         List<Pokemon> listaOrdenada = new ArrayList<>(baseDeDatosPokemon.values());
         listaOrdenada.sort(Comparator.comparing(p -> p.tipo1));
         listaOrdenada.forEach(System.out::println);
     }
 
     public void mostrarPokemonPorHabilidad(String habilidad) {
         boolean encontrado = false;
         habilidad = habilidad.trim().toLowerCase(); 
 
         for (Pokemon p : baseDeDatosPokemon.values()) {
             if (p.habilidad != null && !p.habilidad.isEmpty()) {
                 String[] habilidadesPokemon = p.habilidad.split(",");
                 for (String h : habilidadesPokemon) {
                     if (h.trim().equalsIgnoreCase(habilidad)) {
                         System.out.println(p);
                         encontrado = true;
                     }
                 }
             }
         }
 
         if (!encontrado) {
             System.out.println("No se encontraron Pokémon con la habilidad: " + habilidad);
         }
     }
 }
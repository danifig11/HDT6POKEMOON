/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Facultad de Ingeniería
 * Departamento de Ciencias de la Computación
 * Curso: CC2016 – Algoritmos y Estructura de Datos
 * Autor: Daniel Figueroa
 * Fecha: 12 de Marzo de 2025
 * 
 * Clase: PokedexTest
 * Pruebas JUNIT para ver las funcionalidades principales de la Pokedex.
 */

 import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;
 import java.util.*;
 
 class PokedexTest {
     private Pokedex pokedex;
 
     @BeforeEach
     void setUp() {
         pokedex = new Pokedex(1); 
     }
 
     @Test
     void testAgregarPokemonAColeccion() {
         pokedex.agregarPokemonAColeccion("Pikachu");
         assertTrue(pokedex.coleccionUsuario.containsKey("Pikachu"), "Pikachu debería estar en la colección del usuario.");
     }
 
     @Test
     void testMostrarDatosPokemon() {
         pokedex.mostrarDatosPokemon("Charizard");
         assertNotNull(pokedex.baseDeDatosPokemon.get("Charizard"), "Charizard debería existir en la base de datos.");
     }
 
     @Test
     void testMostrarColeccionOrdenadaPorTipo() {
         pokedex.agregarPokemonAColeccion("Bulbasaur"); 
         pokedex.agregarPokemonAColeccion("Charmander"); 
         pokedex.agregarPokemonAColeccion("Squirtle"); 
 
         List<String> tiposOrdenados = new ArrayList<>();
         for (Pokemon p : pokedex.coleccionUsuario.values()) {
             tiposOrdenados.add(p.tipo1);
         }
 
         List<String> copiaOrdenada = new ArrayList<>(tiposOrdenados);
         Collections.sort(copiaOrdenada);
         assertEquals(copiaOrdenada, tiposOrdenados, "La colección de usuario no está ordenada correctamente por tipo.");
     }
 
     @Test
     void testMostrarTodosLosPokemonOrdenadosPorTipo() {
         List<String> tiposOrdenados = new ArrayList<>();
         for (Pokemon p : pokedex.baseDeDatosPokemon.values()) {
             tiposOrdenados.add(p.tipo1);
         }
 
         List<String> copiaOrdenada = new ArrayList<>(tiposOrdenados);
         Collections.sort(copiaOrdenada);
         assertEquals(copiaOrdenada, tiposOrdenados, "La lista completa de Pokémon no está ordenada correctamente por tipo.");
     }
 
     @Test
     void testMostrarPokemonPorHabilidad() {
         pokedex.mostrarPokemonPorHabilidad("Damp");
         boolean encontrado = false;
 
         for (Pokemon p : pokedex.baseDeDatosPokemon.values()) {
             String[] habilidades = p.habilidad.split(",");
             for (String h : habilidades) {
                 if (h.trim().equalsIgnoreCase("Damp")) {
                     encontrado = true;
                     break;
                 }
             }
         }
         assertTrue(encontrado, "No se encontraron Pokémon con la habilidad 'Damp'.");
     }
 }
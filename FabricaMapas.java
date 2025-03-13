/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Facultad de Ingeniería
 * Departamento de Ciencias de la Computación
 * Curso: CC2016 – Algoritmos y Estructura de Datos
 * Autor: Danile Figueroa
 * Fecha: 12 de Marzo de 2025
 * 
 * Clase: FabricaMapas
 * Usa Factory para escoger el Map.
 */

 import java.util.*;

 public class FabricaMapas {
     public static Map<String, Pokemon> obtenerMapa(int opcion) {
         switch (opcion) {
             case 1: return new HashMap<>();
             case 2: return new TreeMap<>();
             case 3: return new LinkedHashMap<>();
             default: return new HashMap<>();
         }
     }
 }
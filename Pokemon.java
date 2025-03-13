/*
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * Facultad de Ingeniería
 * Departamento de Ciencias de la Computación
 * Curso: CC2016 – Algoritmos y Estructura de Datos
 * Autor: Danile Figueroa
 * Fecha: 12 de Marzo de 2025
 * 
 * Clase: Pokemon
 * Es Pokémon con sus hablidades y ataques principales.
 */

 public class Pokemon {
    String nombre;
    String tipo1;
    String tipo2;
    String habilidad;

    public Pokemon(String nombre, String tipo1, String tipo2, String habilidad) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.habilidad = habilidad;
    }

    @Override
    public String toString() {
        return nombre + " | Tipo1: " + tipo1 + " | Tipo2: " + tipo2 + " | Habilidad: " + habilidad;
    }
}
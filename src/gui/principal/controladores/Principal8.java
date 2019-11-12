/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.principal.controladores;

import gui.personas.modelos.Cargo;
import gui.personas.modelos.GestorPersonas;

/**
 *
 * @author Rosalba Caldez
 */
public class Principal8 {
    public static void main(String[] args) {
        GestorPersonas gPersonas = GestorPersonas.crear();
        
//        System.out.println(gPersonas.nuevoProfesor("Juarez", "Juan Jose", 1234567, Cargo.ASOCIADO));
//        System.out.println(gPersonas.nuevoProfesor("Diaz", "Juan", 13345678, Cargo.JTP)); // Se agrega
//        System.out.println(gPersonas.nuevoProfesor("Juarez", "Ana María", 14345678, Cargo.ADJUNTO));
//        System.out.println(gPersonas.nuevoProfesor("San Martin","Jose Manuel", 15345678, Cargo.ADG));
//        System.out.println(gPersonas.nuevoProfesor("Ortega", "Laura", 16345678, Cargo.ASOCIADO));
//        System.out.println(gPersonas.nuevoProfesor("Rodriguez","Juliana", 15345678, Cargo.TITULAR));
//        
//        System.out.println(gPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345") + "1");
//        System.out.println(gPersonas.nuevoAlumno("Martinez", "Ricardo Juan", 34567891, "16343")+"2");
//        System.out.println(gPersonas.nuevoAlumno("Gimenez", "María José", 34567892, "16344")+"3");

//        gPersonas.modificarAlumno(gPersonas.dameAlumno("16345"), "Perez", "Zancho", "16345");
//        
//        gPersonas.borrarProfesor(gPersonas.dameProfesor(1234567));

//        System.out.println("PERSONAS");    
//        
//        gPersonas.mostrarPersonas();
        gPersonas.borrarAlumno(gPersonas.dameAlumno("16345"));
        gPersonas.borrarAlumno(gPersonas.dameAlumno("16343"));
        gPersonas.borrarAlumno(gPersonas.dameAlumno("16344"));
        gPersonas.borrarAlumno(gPersonas.dameAlumno(null));
        
    }
        
    
}

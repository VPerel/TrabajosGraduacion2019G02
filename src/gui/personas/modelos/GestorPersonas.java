/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.personas.modelos;

import gui.interfaces.IGestorPersonas;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.GestorTrabajos;
import gui.trabajos.modelos.RolEnTrabajo;
import gui.trabajos.modelos.Trabajo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Valentina Perelmut
 */
public class GestorPersonas implements IGestorPersonas{
    public static GestorPersonas gestor;
    private List<Persona> personas = new ArrayList<>();
    public static final String ARCHIVO = "./Personas.txt";
    public static final char SEPARADOR = ',';
    public static final String ERROR_LECTURA = "Error al leer del archivo";
    public static final String ERROR_ESCRITURA = "Error al escribir en el archivo";
    
    private GestorPersonas(){
        this.leerArchivo();
    }
    
    public static GestorPersonas crear(){
        if(gestor == null){
            gestor = new GestorPersonas();
        }
        return gestor;
    }
    
    
    /**
     * Crea una persona y la agrega a la lista siempre y cuando: 
     *  -  Los valores de los parámetros recibidos sean correctos.
     *  -  No exista otro profesor igual en la lista.
     * @param apellidos
     * @param nombres
     * @param dni
     * @param cargo
     * @return Informa si se agrego o no el profesor a la lista. 
     */
    public String nuevoProfesor(String apellidos, String nombres, int dni, Cargo cargo) {
        
        try{
            if(apellidos.isEmpty()){
                return "No se agregó el profesor a la lista.";
            }
            if(nombres.isEmpty()){
                return "No se agregó el profesor a la lista.";
            }
        }
        catch(NullPointerException e){
            return "No se agregó el profesor a la lista.";
        }
        
        if(dni <= 0){
            return "No se agregó el profesor a la lista.";
        }
        if(cargo == null){
            return "No se agregó el profesor a la lista.";
        }
        Profesor profesor = new Profesor(apellidos, nombres,dni,cargo);
        if(this.personas.contains(profesor)){
           return "No se agregó el profesor a la lista."; 
        }
        this.personas.add(profesor);
        this.escribirArchivo();
        return "Se agregó el profesor a la lista.";
    }
    /**
     * Crea un nuevo alumno y lo agrega a la lista siempre y cuando los parametros sean correctos y no exista ya un alumno igual en la lista
     * @param apellidos
     * @param nombres
     * @param dni
     * @param cx
     * @return Devuelve un String indicando si se agregó o no el alumno a la lista.
     */
    
    public String nuevoAlumno(String apellidos, String nombres, int dni, String cx) {
        
        try{
            if(apellidos.isEmpty()){
                return "No se agregó el alumno a la lista.";
            }
        }
        catch(NullPointerException e){
            return "No se agregó el alumno a la lista.";
        }
        
        try{
            if(nombres.isEmpty()){
                return "No se agregó el alumno a la lista.";
            }
        }
        catch(NullPointerException e){
            return "No se agregó el alumno a la lista.";
        }
        
        if(dni<=0){
            return "No se agregó el alumno a la lista.";
        }
        
        try{
            if(cx.isEmpty()){
                return "No se agregó el alumno a la lista.";
            }
        }
        catch(NullPointerException e){
            return "No se agregó el alumno a la lista.";
        }
        
        Alumno alumno = new Alumno(apellidos, nombres,dni,cx);
        
        if(this.personas.contains(alumno)){
            return "No se agregó el alumno a la lista.";
        }
        personas.add(alumno);
        this.escribirArchivo();
        return "Se agregó el alumno a la lista.";
    }

    /**
     * Busca si existen Profesores cuyo apellido coincida con el filtro especificado. 
     * Devuelve el resultado en una lista, si no hay coincidencias, devuelve una lista vacia.
     * @param apellidos
     * @return 
     */
    
    public List<Profesor> buscarProfesores(String apellidos) {
        List<Profesor> coincidencias = new ArrayList<>();
        if(apellidos == null){ 
            // Recorre la lista de personas
            for(Persona p : this.personas){
                // A todas las personas que sean instancias de Profesor las anade a la lista coincidencias
                // ya que el filtro es null
                if(p instanceof Profesor){
                    coincidencias.add((Profesor)p);
                }
            }
            return coincidencias; //Si el filtro es nulo, devuelve todos los profesores
        }
        
        for(Persona p : this.personas){
            if(p instanceof Profesor){
                if(p.getApellido().contains(apellidos)){
                    coincidencias.add((Profesor)p);
                }
            }
        }
        return coincidencias;
    }
    
    /**
     * Busca si existen alumnos cuyo apellido coincida con el filtro especificado. 
     * Devuelve el resultado en una lista, si no hay coincidencias retornará la lista vacía.
     * @param apellidos
     * @return 
     */
    
    public List<Alumno> buscarAlumnos(String apellidos) {
        List<Alumno> coincidencias = new ArrayList<>();
        if(apellidos == null){ 
            // Recorre la lista de personas
            for(Persona p : this.personas){
                // A todas las personas que sean instancias de Alumno las anade a la lista coincidencias
                // ya que el filtro es null
                if(p instanceof Alumno){
                    coincidencias.add((Alumno)p);
                }
            }
            return coincidencias; //Si el filtro es nulo, devuelve todos los alumno
        }
        
        for(Persona p : this.personas){
            if(p instanceof Alumno){
                if(p.getApellido().contains(apellidos)){
                    coincidencias.add((Alumno)p);
                }
            }
        }
        return coincidencias;
    }
    /**
     * Busca si existe un profesor cuyo documento coincide con el filtro especificado. 
     * Si encuentra coincidencias devuelve el profesor encontrado, sino devuelve null.
     * @param documento
     * @return 
     */
   
    public Profesor dameProfesor(int documento) {
        for(Persona p : this.personas){
            if(p instanceof Profesor){
                if(p.getDni() == documento){
                    return (Profesor) p;
                }
            }
        }
        return null;
    }
    /**
     * Busca si existe un Alumno cuyo cx coincida con el filtro especificado.
     * Si encuentra coincidencias, devuelve el alumno encontrado, sino devuelve null.
     * @param cx
     * @return 
     */
   
    public Alumno dameAlumno(String cx) {
        for(Persona p : this.personas){
            if(p instanceof Alumno){
                Alumno a = (Alumno) p;
                if(a.getCx().equals(cx)){
                   return a; 
                }
            }
        }
        return null;
    }
    
    /**
     * Muestra las personas de la lista.
     */
   
    public void mostrarPersonas() {
        Comparator<Persona> compApellidoYNombre = new Comparator<Persona>(){
            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getApellido().compareToIgnoreCase(o2.getApellido()) == 0){
                    return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                }
                else{
                    return o1.getApellido().compareToIgnoreCase(o2.getApellido());
                }
            }
            
        };

        this.personas.sort(compApellidoYNombre);

        for(Persona p : this.personas){
            p.mostrar();
        }
    }
    
    /**
     * Muestra los Alumnos de la lista
     */
   
    public void mostrarAlumnos() {
        for(Persona p : this.personas){
            if(p instanceof Alumno){
                p.mostrar();
            }       
        }
    }
    
    /**
     * Muestra los Profesores de la lista
     */
   
    public void mostrarProfesores() {
        for(Persona p : this.personas){
            if(p instanceof Profesor){
                p.mostrar();
            }       
        }
    }
    
    /**
     * permite modificar los datos de un profesor/alumno
     * realiza las validaciones de datos que sean necesarias
     * no se debe poder modificar el DNI
     * deberá informar el resultado de la operación
     * @param profesor
     * @param apellidos
     * @param nombres
     * @param cargo
     * @return 
     */
    
    public String modificarProfesor(Profesor profesor, String apellidos, String nombres, Cargo cargo) {
        
        try{
            if(apellidos.isEmpty()){
                return "Apellido Invalido.";
            }
        }
        catch(NullPointerException e){
            return "Apellido invalido.";
        }
        try{
            if(nombres.isEmpty()){
                return "Nombre Invalido.";
            }
        }
        catch(NullPointerException e){
            return "Nombre invalido.";
        }
        
        
        if(cargo == null){
            return "Cargo invalido.";
        }
        
        if(!this.personas.contains(profesor)){
            return "El profesor no está en la lista.";
        }
        profesor.setApellido(apellidos);
        profesor.setNombre(nombres);
        profesor.setCargo(cargo);
        
        this.escribirArchivo();
        return "La informacion ha sido modificada.";
    }

    
    public String modificarAlumno(Alumno alumno, String apellidos, String nombres, String cx) {
        try{
            if(apellidos.isEmpty()){
                return "Apellido Invalido.";
            }
        }
        catch(NullPointerException e){
            return "Apellido invalido.";
        }
        try{
            if(nombres.isEmpty()){
                return "Nombre Invalido.";
            }
        }
        catch(NullPointerException e){
            return "Nombre invalido.";
        }
        try{
            if(cx.isEmpty()){
                return "CX Invalido.";
            }
        }
        catch(NullPointerException e){
            return "CX invalido.";
        }
        
        if(!this.personas.contains(alumno)){
            return "El alumno no se encuentra en la lista.";
        }
        
        alumno.setApellido(apellidos);
        alumno.setNombre(nombres);
        alumno.setCx(cx);
        
        this.escribirArchivo();
        return "La informacion ha sido modificada.";
    }
    
    /**
     * permite borrar un profesor/alumno.
     * no se pueden borrar profesores / alumnos que se encuentren vinculados a un Trabajo.
     * Informa el resultado de la operación.
     * @param profesor
     * @return 
     */
    
    public String borrarProfesor(Profesor profesor) {
        GestorTrabajos gestor = GestorTrabajos.crear();
        
        for(Trabajo t : gestor.getTrabajos()){
            for(RolEnTrabajo rot : t.getRolTrabajo()){
                if(rot.getProfesor().equals(profesor)){
                    return "El profesor esta vinculado al trabajo " + t.getTitulo().toUpperCase();
                }
            }
        }
        
        if(!this.personas.contains(profesor)){
            return "El profesor no está en la lista.";
        }
        
        this.personas.remove(profesor);
        this.escribirArchivo();
        return "El profesor ha sido eliminado.";
    }

    
    public String borrarAlumno(Alumno alumno) {
        GestorTrabajos gestor = GestorTrabajos.crear();
        
        for(Trabajo t : gestor.getTrabajos()){
            for(AlumnoEnTrabajo aot : t.getAlumTrabajo()){
                if(aot.getAlumno().equals(alumno)){
                    return "El alumno esta vinculado al trabajo " + t.getTitulo().toUpperCase();
                }
            }
        }
        
        if(!this.personas.contains(alumno)){
            return "El alumno no está en la lista.";
        }
        
        this.personas.remove(alumno);
        this.escribirArchivo();
        return "El alumno ha sido eliminado.";
    }
     /**
      * Formato:
      * Si es profesor:
      * Apellidos,nombres,dni,cargo
      * Si es alumno:
      * Apellidos, nombres, dni, cx
      */
    private void escribirArchivo(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(ARCHIVO)))){
            for(Persona p : this.personas){
                if(p instanceof Profesor){
                    String cadena = p.getApellido() + SEPARADOR;
                    cadena += p.getNombre() + SEPARADOR;
                    cadena += Integer.toString(p.getDni()) + SEPARADOR;
                    cadena += ((Profesor) p).getCargo().toString();
                    bw.write(cadena);
                    bw.newLine();
                }
                if(p instanceof Alumno){
                    String cadena = p.getApellido() + SEPARADOR;
                    cadena += p.getNombre() + SEPARADOR;
                    cadena += Integer.toString(p.getDni()) + SEPARADOR;
                    cadena += ((Alumno) p).getCx();
                    bw.write(cadena);
                    bw.newLine();
                }
            }
        }
        catch(IOException ioe){
            System.out.println(ERROR_ESCRITURA);
        }
    }
       
    /**
     * Lee el archivo de texto y carga el ArrayList
     */
    private void leerArchivo(){
        File file = new File(ARCHIVO); 
        if(file.exists()){
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String cadena;
                while((cadena = br.readLine()) != null){
                    String[] vector = cadena.split(Character.toString(SEPARADOR));
                    String apellidos = vector[0];
                    String nombre = vector[1];
                    int dni = Integer.parseInt(vector[2]);
                    
                    try{//Si el vector[3] no puede convertirse a entero, entra a catch
                        Integer.parseInt(vector[3]);
                        String cx = vector[3];
                        this.personas.add(new Alumno(apellidos,nombre,dni,cx));
                        
                    }
                    catch(NumberFormatException nfe){
                        Cargo cargo = Cargo.valueOf(vector[3]);
                        this.personas.add(new Profesor(apellidos,nombre,dni,cargo));
                    }
                }
            }
            catch(IOException ioe){
                System.out.println(ERROR_LECTURA);
            }
        }
        
    }
    
}

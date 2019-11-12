/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.areas.modelos;

import gui.interfaces.IGestorAreas;
import gui.trabajos.modelos.GestorTrabajos;
import gui.trabajos.modelos.Trabajo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Rosalba Caldez
 */
public class GestorAreas implements IGestorAreas {
    
    private List<Area> areas = new ArrayList<>();
    public static GestorAreas gestor;
    public static final String ARCHIVO = "./Areas.txt";
    public static final char SEPARADOR = ',';
    public static final String ERROR_LECTURA = "Error al leer el archivo.";
    public static final String ERROR_ESCRITURA = "Error al escribir en el archivo.";
    
    private GestorAreas(){ 
        this.leerArchivo();
    }
    /**
     * Solo crea un gestor de areas si previamente no se creo uno. 
     * @return 
     */
    public static GestorAreas crear(){
        if(gestor == null){
            gestor = new GestorAreas();
        }
        return gestor;
    }

    /**
     * Permite crear un area nueva y agregarla a la lista de Areas siempre y cuando no exista otra igual.
     * El area no puede tener como nombre una cadena vacía o nula. 
     * @param nombre Nombre del area.
     * @return String - dice si se aregó o no el area a la lista. 
     */
    @Override
    public String nuevaArea(String nombre) {
        if((nombre != null) && (!nombre.isEmpty())){
            if(!this.areas.contains(new Area(nombre))){
            this.areas.add(new Area(nombre));
            this.escribirArchivo();
            return "Se agregó el área a la lista.";
            }
        }
        
        return "No se agregó el area a la lista";
    }
    
    /**
     * Muestra todas las areas creadas. 
     */
    @Override
    public void mostrarAreas() {
        Collections.sort(areas);
        for(Area a : this.areas){
            a.mostrar();
        }
    }
    
    /**
     * Busca si existe un area cuyo nombre coincida con el filtro especificado (nombre). 
     * @param nombre - Busqueda
     * @return Area si la encuentra, null si no la encuentra
     */
    
    public Area dameArea(String nombre) {
        for(Area a : areas){
            if(a.nombre.equalsIgnoreCase(nombre)){
                return a;
            }
        }
        return null;
    }

    public List<Area> getAreas() {
        
        return areas;
          
    }
    
    
    
    /**
     * Para buscar si exiten Areas cuyo nombre contenga el filtro especificado. Si el filtro es null, devuelve todas las areas.
     * Devuelve el resultado en una lista, si no hay coincidencias devuelve una lista vacia. 
     * @param nombre
     * @return 
     */
    @Override
    public List<Area> buscarArea(String nombre) {
        if((nombre == null)||(nombre.isEmpty())){
            return this.areas;
        }
        List<Area> coincidencias = new ArrayList<>();
        for(Area a : this.areas){
            if(a.nombre.toLowerCase().contains(nombre.toLowerCase())){
                coincidencias.add(a);
            }
        }
        return coincidencias;
    }
    
    
    public String borrarArea(Area area) {
        GestorTrabajos ge = GestorTrabajos.crear();
        
        for(Trabajo trab: ge.getTrabajos()){
            if(trab.getArea().contains(area)){
                return "No se puede borrar el area ya que esta en el trabajo " + trab.getTitulo().toUpperCase();
            }
        }
        if(!this.areas.contains(area)){
            return "El area no se encuentra en la lista.";
        }
        this.areas.remove(area);
        this.escribirArchivo();
        return "El area fue borrada";
    }    
    
    /**
     * Se lee del archivo de texto y carga el ArrayList. 
     * El archivo debe cerrarse al finalizar
     * Se utiliza BufferedReader
     */
    private void leerArchivo(){
        File file = new File(ARCHIVO);
        if(file.exists()){
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String cadena;
                while((cadena = br.readLine()) != null){
                    String[] vector = cadena.split(Character.toString(SEPARADOR));
                    String nombre = vector[0];
                    Area unArea = new Area(nombre);
                    this.areas.add(unArea);
                }
            }
            catch(IOException ioe){
                System.out.println(ERROR_LECTURA);
            }
        }
    }
    
    /**
     * Escribe en el archivo de texto el ArrayList una sola Area
     *Formato:
     * nombre, 
     * Emplea Buffers
     */
    private void escribirArchivo(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(ARCHIVO)))){
            for(Area ar : this.areas){
                String cadena = ar.verNombre().toUpperCase() + SEPARADOR;
                bw.write(cadena);
                bw.newLine();
            }     
        }
        catch(IOException ioe){
            System.out.println(ERROR_ESCRITURA);
        }
    }
    
}

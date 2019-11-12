/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.areas.modelos;

import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Rosalba Caldez
 */
public class ModeloComboAreas extends DefaultComboBoxModel {
    
    public ModeloComboAreas(){
        GestorAreas ge = GestorAreas.crear();
        
        Collections.sort(ge.getAreas());
             
        for(Area a : ge.getAreas()){
            this.addElement(a);
        } 
    }
    
    public ModeloComboAreas(String filtro){
        GestorAreas ge = GestorAreas.crear();
        
        List<Area> areas = ge.buscarArea(filtro);
        
        Collections.sort(areas);
        
        for(Area a : areas){
            this.addElement(a);
        }                
       
    }
    
}

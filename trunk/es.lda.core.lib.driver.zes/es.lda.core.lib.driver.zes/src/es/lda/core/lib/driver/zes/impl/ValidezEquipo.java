/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.lda.core.lib.driver.zes.impl;

/**
 *
 * @author Jose Antonio
 */
public class ValidezEquipo {
    /**
     * Comando que se envia para validar
     */ 
    public String Comando;
    /** 
     * Respuesta del comando que se envia
     */ 
    public String Respuesta;
    /** 
     * Indice del principo si se quiere coger ó trocear la respuesta
     */ 
    public int PrincipioRespuesta;
    /** 
     * Indice del final si se quiere coger ó trocear la respuesta
     */ 
    public int FinalRespuesta;
   
    public ValidezEquipo() {
    }
    
}

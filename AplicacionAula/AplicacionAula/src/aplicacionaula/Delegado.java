/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacionaula;

/**
 *
 * @author Ivan
 */
public class Delegado extends Alumno{
    public Delegado(String nom){
        super(nom);
        String cargo = "En funciones";
    }
    String Mandar(){
        return "Aqui el delegado soy yo";
    }
    public void pregunta(String pregunta){
    System.out.println("El delegado"+nombre+" tiene una duda:  "+pregunta);
  }
    
    
}

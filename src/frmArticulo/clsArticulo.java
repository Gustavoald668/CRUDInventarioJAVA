/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frmArticulo;

/**
 *
 * @author gusta
 */
public class clsArticulo {
 
    // Atributos que necesito que tenga mi objeto articulo
    private string codigo;
    private string descripcion;
    private double precio;
    
    //constructor
    public clsArticulo(string codigo, string descripcion, double precio ){
        this.codigo= codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    //Imprime en consola los datos del articulo.
    public string aTexto(){
          string articulo = this.codigo+"|"+ this.descripcion + "|" + this.precio;
          return articulo;
    }
    
    //guardar informacion
    public vuid guardar (){
        system. , print }(this.aTexto)|;
                
    }
}
//prueba 
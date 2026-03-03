/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario.general;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class clsArticulo {
 
    // Atributos que necesito que tenga mi objeto articulo
    private String codigo;
    private String descripcion;
    private double precio;
    
    //constructor
    public clsArticulo(String codigo, String descripcion, double precio ){
        this.codigo= codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    //sobrecarga de metodo constructor
    public clsArticulo(){}
    //Imprime en consola los datos del articulo.
    public String aTexto(){
          String articulo = this.codigo+"|"+ this.descripcion + "|" + this.precio;
          return articulo;
    }
    
    //guardar informacion
    public void guardar (){
        //insertando la clase de MODELO
        mArticulos article = new mArticulos();
        //enviamos la cadena de texto para guardaren el archivo
        article.insertar(this.aTexto());
        
                
    }
    
    public void llenarLista (){
        mArticulos mArticle = new mArticulos();
        ArrayList<String> datos = datos = mArticle.consultar();
        // Llamamos la variable con los datos el modelo
        ArrayList<String> datos = Marticle.consultar();
        
        DefaultListModel<String> modelista = new DefaultListModel<> ();
        for (String registro: datos) {
            moddelLista.addElement(registro);
        }
        
        // devolvemos los datos registrados en el modelo de lista 
        retrun ModelLista;
    }
}
  
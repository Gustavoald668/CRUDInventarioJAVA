package inventario.general;

import java.util.ArrayList;
import javax.swing.DefaultListModel; // Importante para que funcione el modelo de lista

/**
 * @author gusta
 */
public class clsArticulo {
 
    // Atributos
    private String codigo;
    private String descripcion;
    private double precio;
    
    // Constructor con parámetros
    public clsArticulo(String codigo, String descripcion, double precio ){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Sobrecarga de método constructor (vacío)
    public clsArticulo(){}

    // Convierte los datos a una cadena separada por tuberías |
    public String aTexto(){
          return this.codigo + "|" + this.descripcion + "|" + this.precio;
    }
    
    // Guardar información usando la clase Modelo
    public void guardar(){
        mArticulos modelo = new mArticulos();
        modelo.insertar(this.aTexto());
    }
    
    // Método para llenar la lista (Corregido de 'void' a 'DefaultListModel')
    public DefaultListModel<String> llenarLista(){
        mArticulos mArticle = new mArticulos();
        ArrayList<String> datos = mArticle.consultar();
        
        DefaultListModel<String> modelista = new DefaultListModel<>();
        for (String registro : datos) {
            modelista.addElement(registro);
        }
        
        return modelista; 
    }
}
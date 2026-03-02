/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario.general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class mArticulos {
    public void insertar(String cadenaArticulo){
        
      try {
            // Esta linea crea el archivo donde se guarda la informacion
            FileWriter archivo = new FileWriter("listado_Articulos.txt",true);
            // Buffer temporal que se encarga de guardar los datos en el archivo
            BufferedWriter buffer = new BufferedWriter(archivo);
            
            // Escribe en el archivo de texto
            buffer.write(cadenaArticulo); 
            // Agrega un salto de linea al registro
            buffer.newLine(); 
            // Guarda los registros en el archivo
            buffer.close();
            //}lblSaludo.setText("¡Archivo guardado con éxito!");

        } catch (IOException e) {
            //lblSaludo.setText("Error al guardar el archivo: " + e.getMessage());
        }
       public void consultar(){
           
           ArrayList<Stringring> listaRegistros = new ArrayList<>();
           
           try (BufferedReadereader br = new BufferredReader){(new FileReder (listado articulo.txt)){
               string linea;
               while ((linea = br.readLine())) != null){
               string[]datos= linea.split("|");
                   datos(0)
                           "codigo"+ datos [0] +"Descripcion" + datos[1] + "precio: " + datos[2] ;
                           listaRegistros.add(datoBonito);
               }
               
           }catch (IOExceptionxeption e) {
                   System.out.println(listaRegistros);+ 
                   }
           }
       }
    }
   
}

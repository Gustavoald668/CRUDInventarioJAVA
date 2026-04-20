/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario.general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gustavo
 */
public class clsCSV {
    String archivo = "Inventario.csv";
    
    public void importarDatos(){
        try(BufferedReader br = new BufferedReader( new FileReader(archivo))){
            
            br.readLine();
            
            String linea;
            double totalGeneral = 0;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                //Asignacion de valorespara insertar Datos
                clsArticulo cArticulo = new clsArticulo(
                   datos[0], datos [1], Double.parseDouble(datos[2]));
                // Almacena en archivo txt
                cArticulo.guardar();
                
                
            }
            br.close();
            System.out.println("El total invertido en el inventario es: " + totalGeneral);
        }catch(IOException e){
            System.out.println("Mensaje de error" + e.getMessage());
        }
    }
}    

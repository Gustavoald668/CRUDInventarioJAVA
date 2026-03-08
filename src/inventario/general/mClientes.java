package inventario.general;

import java.io.*;
import java.util.ArrayList;

/**
 * @author gusta
 */
public class mClientes {
    String archivo = "Clientes.txt";

    public void insertar(String linea) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(linea);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> consultar() {
        ArrayList<String> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
}
package inventario.general;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public ArrayList<String> consultar() {
        ArrayList<String> datos = new ArrayList<>();
        File file = new File(archivo);
        if (!file.exists()) {
            return datos;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
        return datos;
    }

    public void delete(String lineaEliminar, String nombreArchivo) {
        File archivoOriginal = new File(nombreArchivo);
        File archivoTemporal = new File("temp_clientes.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
             PrintWriter pw = new PrintWriter(new FileWriter(archivoTemporal))) {

            String lineaBusqueda;
            while ((lineaBusqueda = br.readLine()) != null) {
                if (!lineaBusqueda.trim().equals(lineaEliminar.trim())) {
                    pw.println(lineaBusqueda);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        // Importante: El renombrado debe ser fuera del bloque try para que el archivo no esté "en uso"
        if (archivoOriginal.delete()) {
            archivoTemporal.renameTo(archivoOriginal);
        }
    }
}
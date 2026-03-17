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
 * @author gustavo
 */
public class mArticulos {

    String archivoNombre = "listado_articulos.txt";

    public void insertar(String cadenaArticulo) {
        // Usamos try-with-resources para asegurar que el archivo se cierre solo
        try (FileWriter archivo = new FileWriter(archivoNombre, true);
             BufferedWriter buffer = new BufferedWriter(archivo);
             PrintWriter out = new PrintWriter(buffer)) {
            
            out.println(cadenaArticulo);
            
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public ArrayList<String> consultar() {
        ArrayList<String> listaRegistros = new ArrayList<>();
        File file = new File(archivoNombre);

        if (!file.exists()) return listaRegistros;

        try (BufferedReader br = new BufferedReader(new FileReader(archivoNombre))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                // Verificamos que la línea tenga los 3 datos para evitar errores de índice
                if (datos.length >= 3) {
                    String datoBonito = "Codigo: " + datos[0] + " | Descripcion: " + datos[1] + " | Precio: " + datos[2];
                    listaRegistros.add(datoBonito);
                } else {
                    listaRegistros.add(linea); // Si no tiene formato, agrega la línea tal cual
                }
            }
        } catch (IOException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
        return listaRegistros;
    }

    public void update(String lineaActual, String lineaNueva, String archivoOriginal) {
        File fileOriginal = new File(archivoOriginal);
        File fileTemporal = new File("temporal_art.txt");
        boolean actualizado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal))) {

            String lineaLeida;
            while ((lineaLeida = br.readLine()) != null) {
                if (lineaLeida.trim().equals(lineaActual.trim())) {
                    bw.write(lineaNueva);
                    actualizado = true;
                } else {
                    bw.write(lineaLeida);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }

        if (actualizado) {
            fileOriginal.delete();
            fileTemporal.renameTo(fileOriginal);
        } else {
            fileTemporal.delete();
        }
    }

    public void delete(String lineaEliminar, String archivoOriginal) {
        File fileOriginal = new File(archivoOriginal);
        File fileTemporal = new File("temp_del_art.txt");
        boolean eliminado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileTemporal))) {

            String lineaLeida;
            while ((lineaLeida = br.readLine()) != null) {
                // Si la línea NO es la que queremos borrar, la escribimos en el temporal
                if (!lineaLeida.trim().equals(lineaEliminar.trim())) {
                    bw.write(lineaLeida);
                    bw.newLine();
                } else {
                    eliminado = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }

        if (eliminado) {
            if (fileOriginal.delete()) {
                fileTemporal.renameTo(fileOriginal);
                System.out.println("Registro eliminado físicamente.");
            }
        } else {
            fileTemporal.delete();
        }
    }
}
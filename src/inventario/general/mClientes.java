package inventario.general;
import java.io.*;
import java.util.ArrayList;

public class mClientes {

    // Cambiamos los 4 parámetros por uno solo para recibir el String de aTexto()
    public boolean insertar(String linea) {
        try {
            FileWriter fw = new FileWriter("lista_clientes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            pw.println(linea); // Imprime la línea ya formateada
            
            pw.close();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Tienes que agregar este método para que llenarLista() funcione
    public ArrayList<String> consultar() {
        ArrayList<String> datos = new ArrayList<>();
        try {
            FileReader fr = new FileReader("lista_clientes.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
        return datos;
    }
}
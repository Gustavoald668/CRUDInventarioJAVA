package inventario.general;

import java.io.*;

public class mClientes {
    
    public boolean guardarRegistro(String id, String nombre, String tipo, String razon) {
        try {
            FileWriter fw = new FileWriter("lista_clientes.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            pw.println(id + "|" + nombre + "|" + tipo + "|" + razon);
            
            pw.close();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
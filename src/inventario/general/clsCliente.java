package inventario.general;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * @author gusta
 */
public class clsCliente {
    private String noCliente;
    private String nombre;
    private String tipoCliente;
    private String razonSocial;

    public clsCliente(String noCliente, String nombre, String tipoCliente, String razonSocial) {
        this.noCliente = noCliente;
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.razonSocial = razonSocial;
    }

    public clsCliente() {}

    public String aTexto() {
        return this.noCliente + "|" + this.nombre + "|" + this.tipoCliente + "|" + this.razonSocial;
    }

    public void guardar() {
        mClientes modelo = new mClientes();
        modelo.insertar(this.aTexto());
    }

    public DefaultListModel<String> llenarLista() {
        mClientes modelo = new mClientes();
        ArrayList<String> datos = modelo.consultar();
        DefaultListModel<String> lista = new DefaultListModel<>();
        for (String registro : datos) {
            lista.addElement(registro);
        }
        return lista;
    }
}
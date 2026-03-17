package inventario.general;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * @author gusta
 */
public class clsArticulo {

    // Atributos
    private String codigo;
    private String descripcion;
    private double precio;

    // Constructor con parámetros
    public clsArticulo(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Constructor vacío (necesario para inicializar objetos antes de asignarles datos)
    public clsArticulo() {
    }

    // --- MÉTODOS DE ACCESO (Getters y Setters) ---
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // --- LÓGICA DE NEGOCIO ---

    /**
     * Convierte los datos del objeto a una cadena con formato para el archivo .txt
     * Ejemplo: "A01|Laptop|1500.0"
     */
    public String aTexto() {
        return this.codigo + "|" + this.descripcion + "|" + this.precio;
    }

    /**
     * Guarda el artículo actual en el archivo a través del modelo
     */
    public void guardar() {
        mArticulos modelo = new mArticulos();
        modelo.insertar(this.aTexto());
    }

    /**
     * Recupera los datos y los formatea para un JList de Swing
     */
    public DefaultListModel<String> llenarLista() {
        mArticulos mArticle = new mArticulos();
        ArrayList<String> datos = mArticle.consultar();

        DefaultListModel<String> modelista = new DefaultListModel<>();
        for (String registro : datos) {
            modelista.addElement(registro);
        }

        return modelista;
    }

    /**
     * Elimina el registro que coincida exactamente con los datos de este objeto
     */
    public void eliminar() {
        // CORRECCIÓN: La línea original debe ser idéntica a como se guardó
        String lineaAEliminar = this.aTexto();
        
        System.out.println("Intentando eliminar registro: " + lineaAEliminar);
        
        mArticulos mArticle = new mArticulos();
        // Se envía la línea exacta y el nombre del archivo
        mArticle.delete(lineaAEliminar, "listado_articulos.txt");
    }
}
package servidor;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Producto implements Serializable {
    private int id;
    private String nombre;
    private ImageIcon img;
    private String desc;
    private float precio;
    private int inventario;

    public Producto(int id, String nombre, ImageIcon imagen, String descripcion, float precio, int inventario) {
        this.id = id;
        this.nombre = nombre;
        this.img = imagen;
        this.desc = descripcion;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ImageIcon getImagen(){
        return img;
    }
    
    public void setImagen(ImageIcon imagen){
        this.img = imagen;
    }
    
    public String getDescripcion(){
        return desc;
    }
    
    public void setDescripcion(String descripcion){
        this.desc = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    @Override
    public String toString() {
        return  id + "," + nombre + "," + precio + "," + inventario;
    }
}
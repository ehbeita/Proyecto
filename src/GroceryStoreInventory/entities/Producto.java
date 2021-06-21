package GroceryStoreInventory.entities;

abstract public class Producto {

    private String nombre;
    private String tipoUnidad;
    private Double precioUnidad;
    private int cantidadStock;
    private String descripcion;
    private String codigo;
    public static final int FRUTA=1;
    public static final int VEG=2;
    public static final int CARB=3;
    public static final int CARN=4;
    public static final int LACT=5;

    public Producto (String nombre, String tipoUnidad, Double precioUnidad, int cantidadStock,
                     String descripcion, String codigo){
        this.nombre=nombre;
        this.tipoUnidad=tipoUnidad;
        this.precioUnidad=precioUnidad;
        this.cantidadStock=cantidadStock;
        this.descripcion=descripcion;
        this.codigo=codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getTipoUnidad(){
        return this.tipoUnidad;
    }

    public Double getPrecioUnidad(){
        return this.precioUnidad;
    }

    public int getCantidadStock(){
        return this.cantidadStock;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public void removerStock(int cantidad){
        this.cantidadStock=this.cantidadStock-cantidad;
    }

    public void agregarStock(int cantidad){
        this.cantidadStock=this.cantidadStock+cantidad;
    }

    public boolean inStock(){
        if(this.cantidadStock>0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean enoughInStock(int cantidad){
        if(this.cantidadStock<cantidad){
            return true;
        }
        else{
            return false;
        }
    }

    public abstract int tipo();

    public abstract void infoProducto();

}

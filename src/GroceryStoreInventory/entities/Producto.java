package GroceryStoreInventory.entities;

//Clase Producto abstracta de la cual implementan de 0 a 100%
abstract public class Producto {

    //atributos de la clase Producto abstracta
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

    //constructor por con parametros.
    public Producto (String nombre, String tipoUnidad, Double precioUnidad, int cantidadStock,
                     String descripcion, String codigo){
        this.nombre=nombre;
        this.tipoUnidad=tipoUnidad;
        this.precioUnidad=precioUnidad;
        this.cantidadStock=cantidadStock;
        this.descripcion=descripcion;
        this.codigo=codigo;
    }
    //cada uno de los sets y gets de la clase abstracta de la cual heredan ciertos sets y gets
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

    //metodo para remover del stock
    public void removerStock(int cantidad){
        this.cantidadStock=this.cantidadStock-cantidad;
    }

    //metodo para agregar del stock
    public void agregarStock(int cantidad){
        this.cantidadStock=this.cantidadStock+cantidad;
    }

    //metodo para saber si hay stock
    public boolean inStock(){
        if(this.cantidadStock>0){
            return true;
        }
        else{
            return false;
        }
    }

    //metodo para saber si hay suficiente stock para remover la cantidad ingresada
    public boolean enoughInStock(int cantidad){
        if(this.cantidadStock<cantidad){
            return true;
        }
        else{
            return false;
        }
    }

    //metodo abstracto del cual las clases que implementan, indican su tipo
    public abstract int tipo();

    //metodo abstracto del cual las clases que implementan, indican su informacion de producto
    public abstract void infoProducto();

}

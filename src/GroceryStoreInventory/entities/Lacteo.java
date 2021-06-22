package GroceryStoreInventory.entities;

//Clase Lacteo que hereda de Producto
public class Lacteo extends Producto {

    private String presentacion;//los lacteos tienen diferentes presentaciones.

    //constructor por con parametros.
    public Lacteo(String nombre, String tipoUnidad, Double precioUnidad, int cantidadStock,
                  String descripcion, String codigo, String presentacion){
        super(nombre, tipoUnidad, precioUnidad, cantidadStock, descripcion, codigo);
        this.presentacion=presentacion;
    }

    //obtiene el tipo de producto
    @Override
    public int tipo() {
        return Producto.LACT;
    }

    //obtiene la presentacion del producto
    public String getPresentacion(){
        return this.presentacion;
    }

    //obtiene la informacion del producto
    @Override
    public void infoProducto(){
        String info="";

        info="------ Informacion del Producto "+this.getCodigo()+" ------"+"\n"
                +"Nombre : "+this.getNombre()+"\n"
                +"Tipo de Unidad : "+this.getTipoUnidad()+"\n"
                +"Presentacion : "+this.getPresentacion()+"\n"
                +"Precio por unidad : "+this.getPrecioUnidad()+"\n";

        if(this.inStock()){
            info=info+"Cantidad en stock : "+this.getCantidadStock()+"\n";
        }
        else{
            info=info+"No hay unidades en stock \n";
        }

        info=info+"Descripcion : "+this.getDescripcion()+"\n";
    }
}

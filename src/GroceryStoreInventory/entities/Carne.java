package GroceryStoreInventory.entities;

public class Carne extends Producto{

    public Carne(String nombre, String tipoUnidad, Double precioUnidad, int cantidadStock,
                 String descripcion, String codigo){
        super(nombre, tipoUnidad, precioUnidad, cantidadStock, descripcion, codigo);
    }

    @Override
    public int tipo() {
        return Producto.CARN;
    }

    @Override
    public void infoProducto(){
        String info="";

        info="------ Informacion del Producto "+this.getCodigo()+" ------"+"\n"
                +"Nombre : "+this.getNombre()+"\n"
                +"Tipo de Unidad : "+this.getTipoUnidad()+"\n"
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

package GroceryStoreInventory.entities;

public class Lacteo extends Producto{

    private String presentacion;

    public Lacteo(String nombre, String tipoUnidad, Double precioUnidad, int cantidadStock,
                  String descripcion, String codigo, String presentacion){
        super(nombre, tipoUnidad, precioUnidad, cantidadStock, descripcion, codigo);
        this.presentacion=presentacion;
    }

    @Override
    public int tipo() {
        return Producto.LACT;
    }

    public String getPresentacion(){
        return this.presentacion;
    }

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

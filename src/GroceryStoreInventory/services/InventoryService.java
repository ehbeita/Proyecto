package GroceryStoreInventory.services;

import GroceryStoreInventory.repositories.Repository;
import GroceryStoreInventory.entities.Producto;
import GroceryStoreInventory.entities.Carbohidrato;
import GroceryStoreInventory.entities.Carne;
import GroceryStoreInventory.entities.Fruta;
import GroceryStoreInventory.entities.Lacteo;
import GroceryStoreInventory.entities.Vegetal;
import GroceryStoreInventory.ui.ErrorEnCantidadStockExcepcion;
import GroceryStoreInventory.ui.ErrorEnPrecioExcepcion;

import java.util.Date;
import java.util.List;

public class InventoryService {

    private Repository repository;
    private static final int FRUTA=1;
    private static final int VEG=2;
    private static final int CARB=3;
    private static final int CARN=4;
    private static final int LACT=5;

    public InventoryService(Repository repository){
        this.repository=repository;
    }

    public void saveProducto(String nombre, String tipoUnidad, String precioUnidad,
                             String cantidadStock, String descripcion,
                             String codigo, String presentacion, int tipo) throws ErrorEnPrecioExcepcion,
                             ErrorEnCantidadStockExcepcion{
        double precio=0;
        try{
            precio=Double.parseDouble(precioUnidad);
        }
        catch(NumberFormatException e) {
            try {
                throw new ErrorEnPrecioExcepcion(precioUnidad);
            } catch (ErrorEnPrecioExcepcion errorEnPrecioException) {
                errorEnPrecioException.printStackTrace();
            }
        }

        int cantidad=0;
        try{
            cantidad=Integer.parseInt(cantidadStock);
        }
        catch(NumberFormatException e) {
            try {
                throw new ErrorEnCantidadStockExcepcion(cantidadStock);
            } catch (ErrorEnCantidadStockExcepcion errorEnCantidadStockException) {
                errorEnCantidadStockException.printStackTrace();
            }
        }
        Producto producto;
        producto = null;
        if (tipo==FRUTA){
            producto = new Fruta(nombre,tipoUnidad, precio, cantidad, descripcion, codigo);
        }
        else{
            if (tipo==VEG){
                producto = new Vegetal(nombre,tipoUnidad, precio, cantidad, descripcion, codigo);
            }
            else{
                if (tipo==CARB){
                    producto = new Carbohidrato(nombre,tipoUnidad, precio, cantidad, descripcion, codigo, presentacion);
                }
                else{
                    if (tipo==CARN){
                        producto = new Carne(nombre,tipoUnidad, precio, cantidad, descripcion, codigo);
                    }
                    else{
                        if (tipo==LACT){
                            producto = new Lacteo(nombre,tipoUnidad, precio, cantidad, descripcion,
                                    codigo, presentacion);
                        }
                    }
                }
            }
        }
        this.repository.saveProducto(producto,new Date());
    }

    public List<String> get(){
        return this.repository.get();
    }
}

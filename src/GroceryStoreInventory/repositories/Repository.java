package GroceryStoreInventory.repositories;

import java.util.Date;
import java.util.List;
import GroceryStoreInventory.entities.Producto;

//interfaz repositorio con sus metodos se escritura y lectura que clases implementaran
public interface Repository {
    void saveProducto(Producto producto, Date fechaAct);
    List<String> get();
}

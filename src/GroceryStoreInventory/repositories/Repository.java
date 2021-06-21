package GroceryStoreInventory.repositories;

import java.util.Date;
import java.util.List;
import GroceryStoreInventory.entities.Producto;

public interface Repository {
    void saveProducto(Producto producto, Date fechaAct);
    List<String> get();
}

package GroceryStoreInventory.repositories;

import GroceryStoreInventory.entities.Producto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InventoryRepository implements Repository{

    @Override
    public void saveProducto(Producto producto, Date fechaAct){
        File archivo = new File("ProductoRepository.txt");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        BufferedWriter bw;

        try {
            bw = new BufferedWriter(new FileWriter(archivo));

            if (archivo.exists()) {
                //bw.append(persona.getNombre() + " - " + marca + " - " + format.format(fecha) + "\n");
            } else {
                //bw.write(persona.getNombre() + " - " + marca + " - " + format.format(fecha) + "\n");
            }
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Hubo un problema con el almacenamiento del producto");
        }
    }

    @Override
    public List<String> get(){
        return null;
    }
}

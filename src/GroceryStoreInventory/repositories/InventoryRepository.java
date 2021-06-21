package GroceryStoreInventory.repositories;

import GroceryStoreInventory.entities.Carbohidrato;
import GroceryStoreInventory.entities.Producto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class InventoryRepository implements Repository{

    private static final int FRUTA=1;
    private static final int VEG=2;
    private static final int CARB=3;
    private static final int CARN=4;
    private static final int LACT=5;

    @Override
    public void saveProducto(Producto producto, Date fechaAct){
        File archivo = new File("ProductoRepository.txt");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        BufferedWriter bw;

        try {
            bw = new BufferedWriter(new FileWriter(archivo));

            if (archivo.exists()) {
                if (producto.tipo() == FRUTA || producto.tipo() == VEG || producto.tipo() == CARN) {
                    bw.append(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                            "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                            "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() + "\n");
                } else {
                    if (producto.tipo() == CARB) {
                        bw.append(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                                "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                                "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() +
                                "|" + ((Carbohidrato) producto).getPresentacion() + "\n");
                    }
                    else{
                        if (producto.tipo() == LACT) {
                            bw.append(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                                    "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                                    "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() +
                                    "|" + ((Carbohidrato) producto).getPresentacion() + "\n");
                        }
                    }
                }
            }
            else{
                if (producto.tipo() == FRUTA || producto.tipo() == VEG || producto.tipo() == CARN) {
                    bw.write(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                            "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                            "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() + "\n");
                } else {
                    if (producto.tipo() == CARB) {
                        bw.write(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                                "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                                "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() +
                                "|" + ((Carbohidrato) producto).getPresentacion() + "\n");
                    }
                    else{
                        if (producto.tipo() == LACT) {
                            bw.write(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                                    "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                                    "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() +
                                    "|" + ((Carbohidrato) producto).getPresentacion() + "\n");
                        }
                    }
                }
            }
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Hubo un problema con el almacenamiento del producto.");
        }
    }

    @Override
    public List<String> get(){
        List<String> productos = new ArrayList<>();
        try {
            File myObj = new File("ProductoRepository.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String linea = myReader.nextLine();
                productos.add(linea);
                System.out.println(linea);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hubo un problema con el archivo: no se encuentra.");
            e.printStackTrace();
        }
        return productos;
    }
}

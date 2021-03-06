package GroceryStoreInventory.repositories;

import GroceryStoreInventory.entities.Carbohidrato;
import GroceryStoreInventory.entities.Lacteo;
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

// Clase de repositorio de inventario que implementa de la interfaz repositorio
public class InventoryRepository implements Repository{

    //variables estaticas finales para manejar los tipos de productos
    private static final int FRUTA=1;
    private static final int VEG=2;
    private static final int CARB=3;
    private static final int CARN=4;
    private static final int LACT=5;

    //metodo para salvar el producto
    @Override
    public void saveProducto(Producto producto, Date fechaAct){
        File archivo = new File("ProductoRepository.txt");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        BufferedWriter bw;
        //obtiene el archivo para poder escribir en el.
        try {
            if (archivo.exists()) {//si existe ingresa el producto
                bw = new BufferedWriter(new FileWriter(archivo, true));
                if (producto.tipo() == FRUTA || producto.tipo() == VEG || producto.tipo() == CARN) {
                    bw.append(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                            "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                            "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() + "\n");
                } else {//si es carbohidrato annade sus atributos extras
                    if (producto.tipo() == CARB) {
                        bw.append(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                                "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                                "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() +
                                "|" + ((Carbohidrato) producto).getPresentacion() + "\n");
                    }
                    else{//si es lacteo annade sus atributos extras
                        if (producto.tipo() == LACT) {
                            bw.append(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                                    "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                                    "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() +
                                    "|" + ((Lacteo) producto).getPresentacion() + "\n");
                        }
                    }
                }
            }
            else{//si el archivo no existe, ingresa el producto
                bw = new BufferedWriter(new FileWriter(archivo));
                if (producto.tipo() == FRUTA || producto.tipo() == VEG || producto.tipo() == CARN) {
                    bw.write(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                            "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                            "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() + "\n");
                } else {//si es carbohidrato annade sus atributos extras
                    if (producto.tipo() == CARB) {
                        bw.write(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                                "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                                "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() +
                                "|" + ((Carbohidrato) producto).getPresentacion() + "\n");
                    }
                    else{//si es lacteo annade sus atributos extras
                        if (producto.tipo() == LACT) {
                            bw.write(producto.tipo() + "|" + producto.getCodigo() + "|" + producto.getNombre() +
                                    "|" + producto.getTipoUnidad() + "|" + producto.getPrecioUnidad() +
                                    "|" + producto.getCantidadStock() + "|" + producto.getDescripcion() +
                                    "|" + ((Lacteo) producto).getPresentacion() + "\n");
                        }
                    }
                }
            }
            bw.close();
        }
        catch (Exception e){// registra la excepcion al escribir
            e.printStackTrace();
            System.out.println("Hubo un problema con el almacenamiento del producto.");
        }
    }

    //metodo que implementa el obtener todos los productos del archivo
    @Override
    public List<String> get(){
        List<String> productos = new ArrayList<>();
        try {//trata de leer el archivo, recorriendo cada linea.
            //en cada linea pregunta por el primer valor para saber que tipo de
            //producto es y en base a eso indica su tipo.
            //Los atributos del archivo para cada linea de producto
            //registrado es dividido por "|" para llevar un control.
            File myObj = new File("ProductoRepository.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String linea = myReader.nextLine();
                String[] lines = linea.split("\\|");
                String tipo="";
                if(Integer.parseInt(lines[0])==FRUTA){
                    tipo="Fruta";
                }
                else{
                    if(Integer.parseInt(lines[0])==VEG){
                        tipo="Vegetal";
                    }
                    else{
                        if(Integer.parseInt(lines[0])==CARB){
                            tipo="Carbohidrato";
                        }
                        else{
                            if(Integer.parseInt(lines[0])==CARN){
                                tipo="Carne";
                            }
                            else{
                                if(Integer.parseInt(lines[0])==LACT){
                                    tipo="Lacteo";
                                }
                            }
                        }
                    }
                }
                String info="";
                if (Integer.parseInt(lines[0])==FRUTA || Integer.parseInt(lines[0])==VEG ||
                        Integer.parseInt(lines[0])==CARN) {
                        info = "------ Informacion del Producto " + lines[1] + " ------" + "\n"
                            + "Tipo :" + tipo + "\n"
                            + "Nombre : " + lines[2] + "\n"
                            + "Tipo de Unidad : " + lines[3] + "\n"
                            + "Precio por unidad : " + lines[4] + "\n";

                    if (Integer.parseInt(lines[5])>0) { //if in stock
                        info = info + "Cantidad en stock : " + lines[5] + "\n";
                    } else {
                        info = info + "No hay unidades en stock \n";
                    }

                    info = info + "Descripcion : " + lines[6] + "\n";
                }
                else{
                    if (Integer.parseInt(lines[0])==CARB || Integer.parseInt(lines[0])==LACT) {
                        info = "------ Informacion del Producto " + lines[1] + " ------" + "\n"
                                + "Tipo :" + tipo + "\n"
                                + "Nombre : " + lines[2] + "\n"
                                + "Tipo de Unidad : " + lines[3] + "\n"
                                + "Presentacion : " + lines[7] + "\n"
                                + "Precio por unidad : " + lines[4] + "\n";

                        if (Integer.parseInt(lines[5])>0) { //if in stock
                            info = info + "Cantidad en stock : " + lines[5] + "\n";
                        } else {
                            info = info + "No hay unidades en stock \n";
                        }

                        info = info + "Descripcion : " + lines[6] + "\n";
                    }
                }
                productos.add(info);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hubo un problema con el archivo: no se encuentra.");
            e.printStackTrace();
        }
        return productos;
    }
}

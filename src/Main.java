import GroceryStoreInventory.ui.FrontEnd;

//clase Main donde se crea el Front end y se construye la interfaz de la aplicacion
public class Main {
    public static void main (String[] args){
        FrontEnd fe = new FrontEnd("Sistema de Inventario de Productos");
        fe.build();
    }
}

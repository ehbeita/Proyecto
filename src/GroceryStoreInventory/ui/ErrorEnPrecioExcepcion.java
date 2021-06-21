package GroceryStoreInventory.ui;

public class ErrorEnPrecioExcepcion extends Exception{
    public ErrorEnPrecioExcepcion(String precio){
        super("Precio incorrecto: "+ precio);
    }
}

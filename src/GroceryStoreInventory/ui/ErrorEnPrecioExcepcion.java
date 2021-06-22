package GroceryStoreInventory.ui;

//clase para poder indicar el mensaje de error al ingresar un dato incorrecto para el precio
public class ErrorEnPrecioExcepcion extends Exception{
    public ErrorEnPrecioExcepcion(String precio){
        super("Precio incorrecto: "+ precio);
    }
}

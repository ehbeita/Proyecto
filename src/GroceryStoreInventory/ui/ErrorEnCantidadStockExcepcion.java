package GroceryStoreInventory.ui;

//clase para poder indicar el mensaje de error al ingresar un dato incorrecto para la cantidad de stock
public class ErrorEnCantidadStockExcepcion extends Exception{
    public ErrorEnCantidadStockExcepcion(String cantidad){
        super("Cantidad en stock incorrecta: "+ cantidad);
    }
}

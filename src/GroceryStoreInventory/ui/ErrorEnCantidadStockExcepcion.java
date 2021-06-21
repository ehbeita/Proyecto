package GroceryStoreInventory.ui;

public class ErrorEnCantidadStockExcepcion extends Exception{
    public ErrorEnCantidadStockExcepcion(String cantidad){
        super("Cantidad en stock incorrecta: "+ cantidad);
    }
}

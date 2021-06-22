package GroceryStoreInventory.ui;

import GroceryStoreInventory.entities.Vegetal;
import GroceryStoreInventory.services.*;
import GroceryStoreInventory.repositories.InventoryRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//variables estaticas finales para manejar los tipos de productos
public class FrontEnd extends JFrame{

    private static final int FRUTA=1;
    private static final int VEG=2;
    private static final int CARB=3;
    private static final int CARN=4;
    private static final int LACT=5;

    //constructor para inicializar la clase de UI
    public FrontEnd (String titulo){
        super(titulo);
    }

    //acomoda los elementos e inicializa antes de mostrar
    public void build(){
        this.construccionPantalla();
        this.crearComponentes();
        super.setVisible(true);
    }

    //construye la ventana de forma correcta
    private void construccionPantalla(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500,200);
        super.setLayout(new GridLayout(6,2));//6/2
    }

    //agrega los componentes uno tras otro.
    private void agregarComponentes(Component componente){
        super.getContentPane().add(componente);
    }

    //crea los componentes, los textos, campos, botones y annade
    //los diferentes eventos al consultar el inventario o annadir un producto.
    private void crearComponentes(){

        JLabel lblProducto = new JLabel("Producto");
        JLabel lblCodigo = new JLabel("Codigo");
        JLabel lblNombre = new JLabel("Nombre");
        JLabel lblTipoUnidad = new JLabel("Tipo de Unidad");
        JLabel lblPrecioUnidad = new JLabel("Precio por Unidad");
        JLabel lblCantidadStock = new JLabel("Cantidad en Stock");
        JLabel lblDescripcion = new JLabel("Descripcion");
        JLabel lblPresentacion = new JLabel("Presentacion");

        JTextField txtCodigo = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtTipoUnidad = new JTextField();
        JTextField txtPrecioUnidad = new JTextField();
        JTextField txtCantidadStock = new JTextField();
        JTextField txtDescripcion = new JTextField();
        JTextField txtPresentacion = new JTextField();

        lblPresentacion.setVisible(false);
        txtPresentacion.setVisible(false);

        JRadioButton btnFruta = new JRadioButton("Fruta");


        JRadioButton btnVegetal = new JRadioButton("Vegetal");


        JRadioButton btnCarbo = new JRadioButton("Carbohidrato");


        JRadioButton btnCarne = new JRadioButton("Carne");


        JRadioButton btnLacteo = new JRadioButton("Lacteo");


        //lo que sucede cuando las opciones de productos son escogidas
        //para que solo una sea escogida siempre y se habiliten los campos
        //necesarios de cada uno.
        btnFruta.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVegetal.setSelected(false);
                btnCarbo.setSelected(false);
                btnCarne.setSelected(false);
                btnLacteo.setSelected(false);
                btnFruta.setSelected(true);
                lblPresentacion.setVisible(false);
                txtPresentacion.setVisible(false);
            }
        });

        btnVegetal.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFruta.setSelected(false);
                btnCarbo.setSelected(false);
                btnCarne.setSelected(false);
                btnLacteo.setSelected(false);
                btnVegetal.setSelected(true);
                lblPresentacion.setVisible(false);
                txtPresentacion.setVisible(false);
            }
        });

        btnCarbo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVegetal.setSelected(false);
                btnFruta.setSelected(false);
                btnCarne.setSelected(false);
                btnLacteo.setSelected(false);
                btnCarbo.setSelected(true);
                lblPresentacion.setVisible(true);
                txtPresentacion.setVisible(true);
            }
        });

        btnCarne.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnVegetal.setSelected(false);
                btnCarbo.setSelected(false);
                btnFruta.setSelected(false);
                btnLacteo.setSelected(false);
                btnCarne.setSelected(true);
                lblPresentacion.setVisible(false);
                txtPresentacion.setVisible(false);
            }
        });

        btnLacteo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFruta.setSelected(false);
                btnCarbo.setSelected(false);
                btnCarne.setSelected(false);
                btnVegetal.setSelected(false);
                btnLacteo.setSelected(true);
                lblPresentacion.setVisible(true);
                txtPresentacion.setVisible(true);
            }
        });

        //lo que sucede al darle click al boton de agregar
        //donde se agrega el producto y se valida si los datos estan bien.
        JButton salvar = new JButton("Guardar");
        salvar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryService service = new InventoryService(new InventoryRepository());
                try {
                    if(btnFruta.isSelected()) {
                        service.saveProducto(txtNombre.getText(), txtTipoUnidad.getText(), txtPrecioUnidad.getText(),
                                txtCantidadStock.getText(), txtDescripcion.getText(), txtCodigo.getText(),
                                txtPresentacion.getText(), FRUTA);
                    }
                    else{
                        if(btnVegetal.isSelected()) {
                            service.saveProducto(txtNombre.getText(), txtTipoUnidad.getText(), txtPrecioUnidad.getText(),
                                    txtCantidadStock.getText(), txtDescripcion.getText(), txtCodigo.getText(),
                                    txtPresentacion.getText(), VEG);
                        }
                        else{
                            if(btnCarbo.isSelected()) {
                                service.saveProducto(txtNombre.getText(), txtTipoUnidad.getText(), txtPrecioUnidad.getText(),
                                        txtCantidadStock.getText(), txtDescripcion.getText(), txtCodigo.getText(),
                                        txtPresentacion.getText(), CARB);
                            }
                            else{
                                if(btnCarne.isSelected()) {
                                    service.saveProducto(txtNombre.getText(), txtTipoUnidad.getText(), txtPrecioUnidad.getText(),
                                            txtCantidadStock.getText(), txtDescripcion.getText(), txtCodigo.getText(),
                                            txtPresentacion.getText(), CARN);
                                }
                                else{
                                    if(btnLacteo.isSelected()) {
                                        service.saveProducto(txtNombre.getText(), txtTipoUnidad.getText(), txtPrecioUnidad.getText(),
                                                txtCantidadStock.getText(), txtDescripcion.getText(), txtCodigo.getText(),
                                                txtPresentacion.getText(), LACT);
                                    }
                                }
                            }
                        }
                    }
                    txtNombre.setText("");
                    txtTipoUnidad.setText("");
                    txtPrecioUnidad.setText("");
                    txtCantidadStock.setText("");
                    txtDescripcion.setText("");
                    txtCodigo.setText("");
                    txtPresentacion.setText("");
                    btnFruta.setSelected(false);
                    btnVegetal.setSelected(false);
                    btnCarbo.setSelected(false);
                    btnCarne.setSelected(false);
                    btnLacteo.setSelected(false);
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), "Producto guardado exitosamente.");
                } catch (ErrorEnCantidadStockExcepcion error) {
                    //error.printStackTrace();
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), error.getMessage());
                } catch (ErrorEnPrecioExcepcion error) {
                    //error.printStackTrace();
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), error.getMessage());
                }
            }
        });

        //lo que sucede cuando se da click en el buton de ver inventario
        JButton leer = new JButton("Ver Inventario");
        leer.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryService service = new InventoryService(new InventoryRepository());
                if(service.get().isEmpty()){
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), "No hay productos agregados en este momento.");
                }
                else{
                    String reporte = String.join("\n", service.get());
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), reporte);
                }
            }
        });

        //agrega cada componente en orden

        this.agregarComponentes(lblProducto);
        this.agregarComponentes(btnFruta);
        this.agregarComponentes(btnVegetal);
        this.agregarComponentes(btnCarbo);
        this.agregarComponentes(btnCarne);
        this.agregarComponentes(btnLacteo);
        this.agregarComponentes(lblCodigo);
        this.agregarComponentes(txtCodigo);
        this.agregarComponentes(lblNombre);
        this.agregarComponentes(txtNombre);
        this.agregarComponentes(lblTipoUnidad);
        this.agregarComponentes(txtTipoUnidad);
        this.agregarComponentes(lblPrecioUnidad);
        this.agregarComponentes(txtPrecioUnidad);
        this.agregarComponentes(lblCantidadStock);
        this.agregarComponentes(txtCantidadStock);
        this.agregarComponentes(lblDescripcion);
        this.agregarComponentes(txtDescripcion);
        this.agregarComponentes(lblPresentacion);
        this.agregarComponentes(txtPresentacion);
        this.agregarComponentes(salvar);
        this.agregarComponentes(leer);

    }
}

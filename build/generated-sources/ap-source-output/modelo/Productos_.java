package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categoria;
import modelo.Combos;
import modelo.DetalleFactura;
import modelo.Promociones;
import modelo.Proveedores;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-20T19:11:58")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Integer> cantidadActual;
    public static volatile SingularAttribute<Productos, Categoria> idCategorias;
    public static volatile SingularAttribute<Productos, Integer> cantidadStock;
    public static volatile SingularAttribute<Productos, Integer> idProductos;
    public static volatile SingularAttribute<Productos, Double> valorVenta;
    public static volatile SingularAttribute<Productos, Proveedores> idProveedor;
    public static volatile SingularAttribute<Productos, Double> valorCompra;
    public static volatile ListAttribute<Productos, Promociones> promocionesList;
    public static volatile ListAttribute<Productos, Combos> combosList;
    public static volatile ListAttribute<Productos, DetalleFactura> detalleFacturaList;
    public static volatile SingularAttribute<Productos, String> nombreProducto;

}
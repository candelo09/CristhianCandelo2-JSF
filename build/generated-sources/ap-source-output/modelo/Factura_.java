package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productos;
import modelo.Ventas;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-04T08:37:59")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Integer> cantidadP;
    public static volatile SingularAttribute<Factura, Productos> idProductos;
    public static volatile SingularAttribute<Factura, Integer> idFactura;
    public static volatile SingularAttribute<Factura, Integer> valorTotalFactura;
    public static volatile SingularAttribute<Factura, Ventas> idVenta;

}
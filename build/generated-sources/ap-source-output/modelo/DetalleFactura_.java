package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.DetalleFacturaPK;
import modelo.Productos;
import modelo.Ventas;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-20T19:11:58")
@StaticMetamodel(DetalleFactura.class)
public class DetalleFactura_ { 

    public static volatile SingularAttribute<DetalleFactura, Ventas> ventas;
    public static volatile SingularAttribute<DetalleFactura, Double> valorPro;
    public static volatile SingularAttribute<DetalleFactura, Integer> cantidad;
    public static volatile SingularAttribute<DetalleFactura, DetalleFacturaPK> detalleFacturaPK;
    public static volatile SingularAttribute<DetalleFactura, Productos> productos;

}
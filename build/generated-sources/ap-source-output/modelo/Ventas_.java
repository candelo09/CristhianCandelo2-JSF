package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Colaborador;
import modelo.Factura;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-04T08:37:59")
@StaticMetamodel(Ventas.class)
public class Ventas_ { 

    public static volatile SingularAttribute<Ventas, String> descripcion;
    public static volatile SingularAttribute<Ventas, Date> fecha;
    public static volatile SingularAttribute<Ventas, Double> impuesto;
    public static volatile SingularAttribute<Ventas, Double> iva;
    public static volatile ListAttribute<Ventas, Factura> facturaList;
    public static volatile SingularAttribute<Ventas, Colaborador> idColaborador;
    public static volatile SingularAttribute<Ventas, Integer> idVentas;

}
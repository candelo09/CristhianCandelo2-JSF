package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-20T19:11:58")
@StaticMetamodel(Promociones.class)
public class Promociones_ { 

    public static volatile SingularAttribute<Promociones, String> estado;
    public static volatile SingularAttribute<Promociones, Productos> idProductos;
    public static volatile SingularAttribute<Promociones, Double> desto;
    public static volatile SingularAttribute<Promociones, Integer> idPromociones;

}
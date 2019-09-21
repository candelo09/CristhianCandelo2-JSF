package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-20T19:11:58")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> ciudad;
    public static volatile SingularAttribute<Proveedores, Integer> idProveedores;
    public static volatile SingularAttribute<Proveedores, String> direccion;
    public static volatile ListAttribute<Proveedores, Productos> productosList;
    public static volatile SingularAttribute<Proveedores, Integer> identificacion;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> nombre;
    public static volatile SingularAttribute<Proveedores, String> email;

}
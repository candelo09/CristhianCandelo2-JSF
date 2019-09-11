package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-04T08:37:59")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> tipoCategoria;
    public static volatile ListAttribute<Categoria, Productos> productosList;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;

}
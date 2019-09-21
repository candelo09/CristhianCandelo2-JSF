package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ventas;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-09-20T19:11:58")
@StaticMetamodel(Colaborador.class)
public class Colaborador_ { 

    public static volatile SingularAttribute<Colaborador, Integer> idUsuario;
    public static volatile SingularAttribute<Colaborador, String> claveUser;
    public static volatile SingularAttribute<Colaborador, String> apellido;
    public static volatile SingularAttribute<Colaborador, String> correo;
    public static volatile SingularAttribute<Colaborador, String> nombreuser;
    public static volatile SingularAttribute<Colaborador, String> direccion;
    public static volatile ListAttribute<Colaborador, Ventas> ventasList;
    public static volatile SingularAttribute<Colaborador, Long> identificacion;
    public static volatile SingularAttribute<Colaborador, String> telefono;
    public static volatile SingularAttribute<Colaborador, String> cargo;
    public static volatile SingularAttribute<Colaborador, String> nombre;

}
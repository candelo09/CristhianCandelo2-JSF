/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Colaborador;
import persistencia.ColaboradorFacadeLocal;

/**
 *
 * @author Laura
 */
@Stateless
public class ColaboradorLogica implements ColaboradorLogicaLocal {

    @EJB
    public ColaboradorFacadeLocal colaboradorDao;

    @Override
    public void registrarColaborador(Colaborador co) throws Exception {
        if (co == null) {
            throw new Exception("El colaborador no tiene datos.");
        }

        if (co.getIdentificacion() == 0) {
            throw new Exception("La identificación debe ser obligatoria.");
        }

        if (co.getNombre().equals("")) {
            throw new Exception("El nombre es obligatorio.");
        }

        if (co.getApellido().equals("")) {
            throw new Exception("El apellido es obligatorio.");
        }

        if (co.getNombreuser().equals("")) {
            throw new Exception("El nombre de usuario debe ser obligatorio.");
        }

        if (co.getClaveUser().equals("")) {
            throw new Exception("La contraseña debe ser obligatoria.");
        }

        if (co.getCorreo().equals("")) {
            throw new Exception("El correo debe ser obligatorio.");
        }

        if (co.getTelefono().equals("")) {
            throw new Exception("El telefono debe ser obligatorio.");
        }

        if (co.getCargo().equals("")) {
            throw new Exception("El cargo debe ser obligatorio.");
        }
        
        Colaborador objColaborador = colaboradorDao.findxIdentificacion(Long.parseLong(co.getIdentificacion().toString()));
        
        if(objColaborador != null){
            throw new Exception("El colaborador ya se encuentra registrado.");
        }
            

        colaboradorDao.create(co);

    }

    @Override
    public List<Colaborador> consultaColaboradores() {
        return colaboradorDao.findAll();
    }

    @Override
    public void modificarColaborador(Colaborador co) throws Exception {
        if (co == null) {
            throw new Exception("El colaborador no tiene datos.");
        }

        colaboradorDao.edit(co);

    }

    @Override
    public void eliminarColaborador(Colaborador co) throws Exception {
          if (co == null) {
            throw new Exception("El colaborador no tiene datos");
        }

        Colaborador objBorrar = colaboradorDao.find(co.getIdUsuario());

        if (objBorrar == null) {
            throw new Exception("El empleado no existe");
        }

        colaboradorDao.remove(objBorrar);
        
    }

    @Override
    public Colaborador ingresar(Colaborador colaborador) throws Exception {
         if(colaborador == null){
            throw new Exception("Usuario vacio");
        }
        if(colaborador.getNombreuser().equals("")){
            throw new Exception("Nombre del usuario obligatio");
        }
        if(colaborador.getClaveUser().equals("")){
            throw  new Exception("Clave del usuario obligatoria");
        }
        
        Colaborador objUsuario = colaboradorDao.findxNombUser(colaborador.getNombreuser());
        if(objUsuario == null){
            throw  new Exception("Usuario no registrado o incorrecto");
        }
        
        
        if(!colaborador.getClaveUser().equals(objUsuario.getClaveUser())){
            throw new Exception("Contraseña Incorrecta");
        }
        return objUsuario;
        
    }

    @Override
    public Colaborador consultaxIden(Integer idUsuario) {
        return colaboradorDao.findxIdColaborador(idUsuario);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Proveedores;
import persistencia.ProveedoresFacadeLocal;

/**
 *
 * @author CANDELO
 */
@Stateless
public class ProveedoresLogica implements ProveedoresLogicaLocal {
    
    @EJB
    public ProveedoresFacadeLocal proveedoresDao;

    @Override
    public void registrarProveedores(Proveedores pr) throws Exception {
        if(pr == null){
            throw new Exception("El proveedor no tiene datos.");
        }
        
        if(pr.getIdentificacion() == 0){
            throw  new Exception("La idendificación debe ser obligatoria");
        }
        
        if(pr.getNombre().equals("")){
            throw  new Exception("El nombre es obligatario");
        }
        
        if(pr.getTelefono().equals("")){
            throw  new Exception("El telefono debe ser obligatorio");
        }
        
        proveedoresDao.create(pr);
    }

    @Override
    public List<Proveedores> consultarProveedores() {
        return proveedoresDao.findAll();
    }

    @Override
    public void modificarProveedores(Proveedores pr) throws Exception {
        if(pr == null){
            throw new Exception("El proveedor no tiene datos.");
        }
        
       
        
        proveedoresDao.edit(pr);
    }

    @Override
    public void eliminarProveedores(Proveedores pr) throws Exception {
               if (pr == null) {
            throw new Exception("El Proveedor no tiene datos");
        }

        Proveedores objBorrar = proveedoresDao.find(pr.getIdProveedores());

        if (objBorrar == null) {
            throw new Exception("El proveedor no existe");
        }

        proveedoresDao.remove(objBorrar);
    }

    
}

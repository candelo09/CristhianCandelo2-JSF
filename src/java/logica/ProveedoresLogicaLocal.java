/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Proveedores;

/**
 *
 * @author CANDELO
 */
@Local
public interface ProveedoresLogicaLocal {
    public void registrarProveedores(Proveedores pr) throws Exception;

    public List<Proveedores> consultarProveedores();

    public void modificarProveedores(Proveedores pr) throws Exception;

    public void eliminarProveedores(Proveedores pr) throws Exception;
}

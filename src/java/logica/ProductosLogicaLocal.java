/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Productos;

/**
 *
 * @author Laura
 */
@Local
public interface ProductosLogicaLocal {

    public void registrarProducto(Productos p) throws Exception;

    public List<Productos> consultarProductos();

    public void modificarProducto(Productos p) throws Exception;

    public void eliminarProducto(Productos p) throws Exception;

}

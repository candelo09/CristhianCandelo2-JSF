/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Productos;
import persistencia.ProductosFacadeLocal;

/**
 *
 * @author Laura
 */
@Stateless
public class ProductosLogica implements ProductosLogicaLocal {

    @EJB
    public ProductosFacadeLocal productosDao;

    @Override
    public void registrarProducto(Productos p) throws Exception {
        if (p == null) {
            throw new Exception("No hay productos registrados");
        }
        if (p.getNombreProducto().equals("")) {
            throw new Exception("El nombre debe ser obligatorio");
        }

        if (p.getValorCompra() == 0) {
            throw new Exception("El valor de la compra del producto es obligatorio");
        }

        if (p.getValorVenta() == 0) {
            throw new Exception("El valor de la venta del producto es obligatorio");
        }

        productosDao.create(p);

    }

    @Override
    public List<Productos> consultarProductos() {
        return productosDao.findAll();
    }

    @Override
    public void modificarProducto(Productos p) throws Exception {
         if (p == null) {
            throw new Exception("No hay productos registrados");
        }
       

        productosDao.edit(p);
    }

    @Override
    public void eliminarProducto(Productos p) throws Exception {
            if (p == null) {
            throw new Exception("El producto no esta registrado.");
        }

        Productos objBorrar = productosDao.find(p.getIdProductos());

        if (objBorrar == null) {
            throw new Exception("El empleado no existe");
        }

        productosDao.remove(objBorrar);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.DetalleFactura;
import modelo.Productos;
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Local
public interface DetalleFacturaFacadeLocal {

    void create(DetalleFactura detalleFactura);

    void edit(DetalleFactura detalleFactura);

    void remove(DetalleFactura detalleFactura);

    DetalleFactura find(Object id);
    
    DetalleFactura traerValorTotal(Ventas idVendas, Productos idProductos);

    List<DetalleFactura> findAll();

    List<DetalleFactura> findRange(int[] range);

    int count();
    
}

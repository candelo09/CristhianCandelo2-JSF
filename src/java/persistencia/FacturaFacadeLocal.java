/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Factura;
import modelo.Productos;
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Local
public interface FacturaFacadeLocal {

    void create(Factura detalleFactura);

    void edit(Factura detalleFactura);

    void remove(Factura detalleFactura);

    Factura find(Object id);
    
    Factura traerValorTotal(Ventas idVendas);

    List<Factura> findAll();

    List<Factura> findRange(int[] range);

    int count();
    
}

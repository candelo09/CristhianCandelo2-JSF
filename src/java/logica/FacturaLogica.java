/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.DetalleFactura;
import modelo.Productos;
import modelo.Ventas;
import persistencia.DetalleFacturaFacadeLocal;
import persistencia.ProductosFacadeLocal;
import persistencia.VentasFacadeLocal;

/**
 *
 * @author CANDELO
 */
@Stateless
public class FacturaLogica implements FacturaLogicaLocal {

    @EJB
    public DetalleFacturaFacadeLocal facturaDao;
    
    @EJB
    public ProductosFacadeLocal productosDao;
    
    @EJB
    public VentasFacadeLocal ventasDao;

    @Override
    public void registrarItem(DetalleFactura fa) throws Exception {
        

      
        facturaDao.create(fa);
    }

    @Override
    public List<DetalleFactura> consultaFactura() {
        return facturaDao.findAll();
    }

    @Override
    public void modificarItem(DetalleFactura fa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Productos> consultaProductos() {
        return productosDao.findAll();
    }

    @Override
    public void registrarVenta(Ventas ve) throws Exception {
        ventasDao.create(ve);
    }

 


   
}

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
import modelo.Ventas;
import persistencia.DetalleFacturaFacadeLocal;
import persistencia.VentasFacadeLocal;

/**
 *
 * @author CANDELO
 */
@Stateless
public class VentasLogica implements VentasLogicaLocal {

    @EJB
    public VentasFacadeLocal ventasDao;

    @EJB
    public DetalleFacturaFacadeLocal facturaDao;

    @Override
    public void registrarVenta(Ventas ve) throws Exception {
        if (ve == null) {
            throw new Exception("La venta no existe");
        }

        ventasDao.create(ve);
    }

    @Override
    public List<Ventas> consultaVentas() {
        return ventasDao.findAll();
    }

    @Override
    public void modificarVenta(Ventas ve) throws Exception {

        Ventas objVentas = ventasDao.traerCodigo();
        
        if(objVentas.getValorTotal() != null){
            throw  new Exception("Debe crear una nueva venta.");
        }
      
      
        ventasDao.edit(ve);
    }

    @Override
    public void eliminarVenta(Ventas ve) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ventas traerVenta(Integer numVenta) {

        return ventasDao.findxCodigo(numVenta);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Ventas traerCodVenta() {

        Ventas objVentas = ventasDao.traerCodigo();
        

        return objVentas;
    }


}

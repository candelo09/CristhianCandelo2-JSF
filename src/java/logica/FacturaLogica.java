/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Factura;
import persistencia.FacturaFacadeLocal;

/**
 *
 * @author CANDELO
 */
@Stateless
public class FacturaLogica implements FacturaLogicaLocal {

    @EJB

    public FacturaFacadeLocal facturaDao;

    @Override
    public void registrarItem(Factura fa) throws Exception {
        if (fa == null) {
            throw new Exception("La factura no se encuentra.");
        }
        facturaDao.create(fa);
    }

    @Override
    public List<Factura> consultaFactura() {
        return facturaDao.findAll();
    }

    @Override
    public void modificarItem(Factura fa) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarItem(Factura fa) throws Exception {
        if (fa == null) {
            throw new Exception("No hay Facturas");
        }

        Factura objBorrar = facturaDao.find(fa.getIdFactura());

        if (objBorrar == null) {
            throw new Exception("La factura no existe");
        }

        facturaDao.remove(objBorrar);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

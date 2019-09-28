/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.DetalleFactura;
import modelo.Productos;
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Stateless
public class DetalleFacturaFacade extends AbstractFacade<DetalleFactura> implements DetalleFacturaFacadeLocal {

    @PersistenceContext(unitName = "facturacionWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleFacturaFacade() {
        super(DetalleFactura.class);
    }

    @Override
    public DetalleFactura traerValorTotal(Ventas idVendas) {
         String consulta = " SELECT f FROM DetalleFactura f WHERE  f.ventas.idVentas="+ idVendas.getIdVentas();
                 ;
        try {
            Query query = em.createQuery(consulta);
            return (DetalleFactura) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

  
    
}

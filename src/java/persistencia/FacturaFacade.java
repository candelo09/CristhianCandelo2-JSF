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
import modelo.Factura;
import modelo.Productos;
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> implements FacturaFacadeLocal {

    @PersistenceContext(unitName = "facturacionWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }

    @Override
    public Factura traerValorTotal(Ventas idVendas) {
         String consulta = " SELECT f FROM Factura f WHERE  f.ventas.idVentas="+ idVendas.getIdVentas();
                 ;
        try {
            Query query = em.createQuery(consulta);
            return (Factura) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

  
    
}

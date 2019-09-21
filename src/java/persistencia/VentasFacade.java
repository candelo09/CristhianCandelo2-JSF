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
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Stateless
public class VentasFacade extends AbstractFacade<Ventas> implements VentasFacadeLocal {

    @PersistenceContext(unitName = "facturacionWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasFacade() {
        super(Ventas.class);
    }

    @Override
    public Ventas findxCodigo(Integer codigo) {
        String consulta = " SELECT v FROM Ventas v WHERE  v.idVentas=" + codigo;

        try {
            Query query = em.createQuery(consulta);
            return (Ventas) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Ventas traerCodigo() {
        String consulta = " SELECT v FROM Ventas v ORDER BY v.idVentas  DESC";

        try {
            Query query = em.createQuery(consulta);
            query.setMaxResults(1);
            return (Ventas) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}

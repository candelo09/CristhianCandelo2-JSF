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
import modelo.Productos;

/**
 *
 * @author CANDELO
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> implements ProductosFacadeLocal {

    @PersistenceContext(unitName = "facturacionWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }

    @Override
    public Productos consultarId(Integer codigoProducto) {
        String consulta = " SELECT p FROM Productos p WHERE  p.idProductos="+codigoProducto;
        
        try{
        Query query = em.createQuery(consulta);   
        return (Productos) query.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }

    
}

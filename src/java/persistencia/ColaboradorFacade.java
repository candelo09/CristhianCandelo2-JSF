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
import modelo.Colaborador;

/**
 *
 * @author CANDELO
 */
@Stateless
public class ColaboradorFacade extends AbstractFacade<Colaborador> implements ColaboradorFacadeLocal {

    @PersistenceContext(unitName = "facturacionWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ColaboradorFacade() {
        super(Colaborador.class);
    }

    @Override
    public Colaborador findxIdentificacion(Long identificacion) {
        String consulta = " SELECT c FROM Colaborador c WHERE  c.identificacion=" + identificacion;

        try {
            Query query = em.createQuery(consulta);
            return (Colaborador) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Colaborador findxNombUser(String nombreUser) {
        String consulta = " SELECT c FROM Colaborador c WHERE  c.nombreuser='" + nombreUser + "'";

        try {
            Query query = em.createQuery(consulta);
            return (Colaborador) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public Colaborador findxIdColaborador(Integer id) {
        String consulta = " SELECT c FROM Colaborador c WHERE  c.idUsuario=" + id;

        try {
            Query query = em.createQuery(consulta);
            return (Colaborador) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}

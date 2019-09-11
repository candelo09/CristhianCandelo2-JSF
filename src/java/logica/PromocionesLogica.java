/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Promociones;
import persistencia.PromocionesFacadeLocal;

/**
 *
 * @author CANDELO
 */
@Stateless
public class PromocionesLogica implements PromocionesLogicaLocal {

    @EJB

    public PromocionesFacadeLocal promocionesDao;

    @Override
    public void registrarPromociones(Promociones promo) throws Exception {
//        
        if (promo == null) {
            throw new Exception("La promoción no existe");
        }

        promocionesDao.create(promo);
    }

    @Override
    public List<Promociones> consultarPromociones() {
        return promocionesDao.findAll();
    }

    @Override
    public void modificarPromociones(Promociones promo) throws Exception {
        if (promo == null) {
            throw new Exception("La promoción no existe");
        }
        
        promocionesDao.edit(promo);
    }

    @Override
    public void eliminarPromociones(Promociones promo) throws Exception {
               if (promo == null) {
            throw new Exception("La promoción no esta registrada.");
        }

        Promociones objBorrar = promocionesDao.find(promo.getIdPromociones());

        if (objBorrar == null) {
            throw new Exception("La promoción no existe");
        }

        promocionesDao.remove(objBorrar);
    }

}

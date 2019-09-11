/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Promociones;

/**
 *
 * @author CANDELO
 */
@Local
public interface PromocionesLogicaLocal {
    public void registrarPromociones(Promociones promo) throws Exception;

    public List<Promociones> consultarPromociones();

    public void modificarPromociones(Promociones promo) throws Exception;

    public void eliminarPromociones(Promociones promo) throws Exception;
}

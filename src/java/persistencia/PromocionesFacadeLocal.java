/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Promociones;

/**
 *
 * @author CANDELO
 */
@Local
public interface PromocionesFacadeLocal {

    void create(Promociones promociones);

    void edit(Promociones promociones);

    void remove(Promociones promociones);

    Promociones find(Object id);

    List<Promociones> findAll();

    List<Promociones> findRange(int[] range);

    int count();
    
}

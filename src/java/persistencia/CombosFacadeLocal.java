/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Combos;

/**
 *
 * @author CANDELO
 */
@Local
public interface CombosFacadeLocal {

    void create(Combos combos);

    void edit(Combos combos);

    void remove(Combos combos);

    Combos find(Object id);

    List<Combos> findAll();

    List<Combos> findRange(int[] range);

    int count();
    
}

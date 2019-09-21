/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Productos;

/**
 *
 * @author CANDELO
 */
@Local
public interface ProductosFacadeLocal {

    void create(Productos productos);

    void edit(Productos productos);

    void remove(Productos productos);

    Productos find(Object id);
    
    Productos consultarId(Integer codigoProducto);
    
    List<Productos> findAll();

    List<Productos> findRange(int[] range);

    int count();
    
}

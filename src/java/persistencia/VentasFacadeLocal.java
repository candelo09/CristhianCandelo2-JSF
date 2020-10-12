/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Local
public interface VentasFacadeLocal {

    void create(Ventas ventas);

    void edit(Ventas ventas);

    void remove(Ventas ventas);

    Ventas find(Object id);

    Ventas findxCodigo(Integer codigo);

    Ventas traerCodigo();
    
    Long totalRegistros();

    List<Ventas> findAll();

    List<Ventas> findRange(int[] range);

    int count();

}

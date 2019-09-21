/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Colaborador;

/**
 *
 * @author CANDELO
 */
@Local
public interface ColaboradorFacadeLocal {

    void create(Colaborador colaborador);

    void edit(Colaborador colaborador);

    void remove(Colaborador colaborador);

    Colaborador find(Object id);

    Colaborador findxIdentificacion(Long identificacion);

    Colaborador findxNombUser(String nombreUser);

    Colaborador findxIdColaborador(Integer id);

    List<Colaborador> findAll();

    List<Colaborador> findRange(int[] range);

    int count();

}

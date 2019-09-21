/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Colaborador;

/**
 *
 * @author Laura
 */
@Local
public interface ColaboradorLogicaLocal {
    public void registrarColaborador(Colaborador co) throws Exception;
    
    public List<Colaborador> consultaColaboradores();
    
    public void modificarColaborador(Colaborador co) throws Exception;
    
    public void eliminarColaborador(Colaborador co) throws Exception;
    
    public Colaborador ingresar(Colaborador colaborador) throws Exception;
    
    public Colaborador consultaxIden(Integer idUsuario);
}

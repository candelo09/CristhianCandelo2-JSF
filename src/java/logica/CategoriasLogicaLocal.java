/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Categoria;

/**
 *
 * @author Laura
 */
@Local
public interface CategoriasLogicaLocal {
    public void registrarCategorias(Categoria c) throws Exception;

    public List<Categoria> consultarCategorias();

    public void modificarCategorias(Categoria c) throws Exception;

    public void eliminarCategorias(Categoria c) throws Exception;
    
}

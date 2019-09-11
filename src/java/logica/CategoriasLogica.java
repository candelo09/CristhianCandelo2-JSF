/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Categoria;
import persistencia.CategoriaFacadeLocal;

/**
 *
 * @author Laura
 */
@Stateless
public class CategoriasLogica implements CategoriasLogicaLocal {
    
    @EJB
    public CategoriaFacadeLocal categoriaDao;

    @Override
    public void registrarCategorias(Categoria c) throws Exception {
        
        if(c.getTipoCategoria().equals("")){
            throw  new Exception("Debe ingresar un tipo de categoria");
        }
        categoriaDao.create(c);
    }

    @Override
    public List<Categoria> consultarCategorias() {
        return categoriaDao.findAll();
    }

    @Override
    public void modificarCategorias(Categoria c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarCategorias(Categoria c) throws Exception {
         if (c == null) {
            throw new Exception("No hay categorias");
        }

        Categoria objBorrar = categoriaDao.find(c.getIdCategoria());

        if (objBorrar == null) {
            throw new Exception("La categoria no existe");
        }

        categoriaDao.remove(objBorrar);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

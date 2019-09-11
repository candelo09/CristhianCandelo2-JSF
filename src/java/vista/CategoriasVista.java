/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.CategoriasLogicaLocal;
import modelo.Categoria;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Laura
 */
@Named(value = "categoriasVista")
@RequestScoped
public class CategoriasVista {
    
    @EJB
    private CategoriasLogicaLocal categoriasLogica;
    
    private List<Categoria> listaCategorias;
    private InputText txtTipoCategoria;
    private Categoria selectCategoria;

    public List<Categoria> getListaCategorias() {
        listaCategorias = categoriasLogica.consultarCategorias();
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public InputText getTxtTipoCategoria() {
        return txtTipoCategoria;
    }

    public void setTxtTipoCategoria(InputText txtTipoCategoria) {
        this.txtTipoCategoria = txtTipoCategoria;
    }
    
    

    /**
     * Creates a new instance of CategoriasVista
     */
    public CategoriasVista() {
    }
    
    
    public void registrarCategoria(){
        
        try {
            Categoria nuevaCategoria = new Categoria();
            
            nuevaCategoria.setTipoCategoria(txtTipoCategoria.getValue().toString());
            
            categoriasLogica.registrarCategorias(nuevaCategoria);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Categoria registrada correctamente.")); 
        } catch (Exception ex) {
             FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La categoria ya se encuenta registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
        
    }

    public Categoria getSelectCategoria() {
        return selectCategoria;
    }

    public void setSelectCategoria(Categoria selectCategoria) {
        this.selectCategoria = selectCategoria;
    }
    
    public void seleccionarCategoria(SelectEvent c) {
        selectCategoria = (Categoria) c.getObject();
        txtTipoCategoria.setValue(selectCategoria.getTipoCategoria());
        
    }
    
    public void eliminarCategoria(){
        try {
            categoriasLogica.eliminarCategorias(selectCategoria);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Categoria eliminado correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La categoria no se encuenta registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }
    
}

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
import logica.PromocionesLogicaLocal;
import modelo.Productos;
import modelo.Promociones;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author CANDELO
 */
@Named(value = "promocionesVista")
@RequestScoped
public class PromocionesVista {

    @EJB

    private PromocionesLogicaLocal promocionesLogica;

    private List<Promociones> listaPromociones;
    private InputText txtDescuento;
    private SelectOneMenu cmbEstado;
    private SelectOneMenu cmbProducto;
    private Promociones selectPromociones;
    private Productos selectProductos;

    public List<Promociones> getListaPromociones() {
        listaPromociones = promocionesLogica.consultarPromociones();
        return listaPromociones;
    }

    public void setListaPromociones(List<Promociones> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }

    public InputText getTxtDescuento() {
        return txtDescuento;
    }

    public void setTxtDescuento(InputText txtDescuento) {
        this.txtDescuento = txtDescuento;
    }

    public SelectOneMenu getCmbEstado() {
        return cmbEstado;
    }

    public void setCmbEstado(SelectOneMenu cmbEstado) {
        this.cmbEstado = cmbEstado;
    }

    public SelectOneMenu getCmbProducto() {
        return cmbProducto;
    }

    public void setCmbProducto(SelectOneMenu cmbProducto) {
        this.cmbProducto = cmbProducto;
    }

    public Productos getSelectProductos() {
        return selectProductos;
    }

    public void setSelectProductos(Productos selectProductos) {
        this.selectProductos = selectProductos;
    }

    public void seleccionarProducto(SelectEvent pr) {
        selectProductos = (Productos) pr.getObject();
        cmbProducto.setValue(selectProductos.getIdProductos());
    }

    public PromocionesVista() {
    }

    public void registrarPromociones() {

        try {
            Promociones nuevaPromocion = new Promociones();

            Productos producto = selectProductos;

            nuevaPromocion.setIdProductos(producto);

            nuevaPromocion.setDesto(Double.parseDouble(txtDescuento.getValue().toString()));

            nuevaPromocion.setEstado(cmbEstado.getValue().toString());

            promocionesLogica.registrarPromociones(nuevaPromocion);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.FACES_MESSAGES, "La promoción se registro correctamente." //Muestra mensaje de error al usuario.
                    ));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La promoción ya se encuentra registrada", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

    public Promociones getSelectPromociones() {
        return selectPromociones;
    }

    public void setSelectPromociones(Promociones selectPromociones) {
        this.selectPromociones = selectPromociones;
    }

    public void seleccionarPromociones(SelectEvent promo) {
        selectPromociones = (Promociones) promo.getObject();
//        cmbProducto.setValue(selectPromociones.getIdProductos());
        txtDescuento.setValue(selectPromociones.getDesto());
        cmbEstado.setValue(selectPromociones.getEstado());
    }

    public void modificarPromociones() {

        try {
            Promociones modificaPromociones = selectPromociones;

            Productos producto = selectProductos;

            modificaPromociones.setIdProductos(producto);

            modificaPromociones.setDesto(Double.parseDouble(txtDescuento.getValue().toString()));

            modificaPromociones.setEstado(cmbEstado.getValue().toString());

            promocionesLogica.modificarPromociones(modificaPromociones);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.FACES_MESSAGES, "La promoción se modifico correctamente." //Muestra mensaje de error al usuario.
                    ));

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La promoción ya se encuentra modificada.", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

    public void eliminarPromocion() {

        try {
            promocionesLogica.eliminarPromociones(selectPromociones);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Promoción eliminada correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La promoción no se encuenta registrado.", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

}

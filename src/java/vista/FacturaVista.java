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
import logica.FacturaLogicaLocal;
import modelo.Factura;
import modelo.Productos;
import modelo.Ventas;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author CANDELO
 */
@Named(value = "facturaVista")
@RequestScoped
public class FacturaVista {

    @EJB

    private FacturaLogicaLocal facturaLogica;

    private List<Factura> listaFactura;
    private int contadorFactura;
    private InputText txtCantidad;
    private SelectOneMenu cmbVenta;
    private SelectOneMenu cmbProducto;
    private Factura selectFactura;
    private Ventas selectVentas;
    private Productos selectProductos;

    public List<Factura> getListaFactura() {
        listaFactura = facturaLogica.consultaFactura();
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public Factura getSelectFactura() {
        return selectFactura;
    }

    public void setSelectFactura(Factura selectFactura) {
        this.selectFactura = selectFactura;
    }

    public InputText getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(InputText txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public SelectOneMenu getCmbVenta() {
        return cmbVenta;
    }

    public void setCmbVenta(SelectOneMenu cmbVenta) {
        this.cmbVenta = cmbVenta;
    }

    public SelectOneMenu getCmbProducto() {
        return cmbProducto;
    }

    public void setCmbProducto(SelectOneMenu cmbProducto) {
        this.cmbProducto = cmbProducto;
    }

    public Ventas getSelectVentas() {
        return selectVentas;
    }

    public void setSelectVentas(Ventas selectVentas) {
        this.selectVentas = selectVentas;
    }

    public Productos getSelectProductos() {
        return selectProductos;
    }

    public void setSelectProductos(Productos selectProductos) {
        this.selectProductos = selectProductos;
    }

    public void seleccionarProducto(SelectEvent pro) {
        selectProductos = (Productos) pro.getObject();
        cmbProducto.setValue(selectProductos.getIdProductos());
    }

    public void seleccionarVentas(SelectEvent vent) {
        selectVentas = (Ventas) vent.getObject();
        cmbVenta.setValue(selectVentas.getIdVentas());
    }

    public int getContadorFactura() {
        return contadorFactura;
    }

    public void setContadorFactura(int contadorFactura) {
        this.contadorFactura = contadorFactura;
    }
    
    

    /**
     * Creates a new instance of FacturaVista
     */
    public FacturaVista() {

    }
    

    
    public void registrarFactura() {

        try {
            Factura nuevaFactura = new Factura();
       
            Productos producto = selectProductos;

            Ventas ventas = selectVentas;
            
            nuevaFactura.setIdFactura(1);
            
            nuevaFactura.setIdProductos(producto);

            nuevaFactura.setIdVenta(ventas);

            nuevaFactura.setCantidadP(Integer.parseInt(txtCantidad.getValue().toString()));

            facturaLogica.registrarItem(nuevaFactura);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Producto Guardado.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El producto ya se encuenta registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }

    }
    public void seleccionarFactura(SelectEvent fac) {
        selectFactura = (Factura) fac.getObject();
        cmbProducto.setValue(selectProductos.getIdProductos());
        txtCantidad.setValue(selectFactura.getCantidadP());
        cmbVenta.setValue(selectVentas.getIdVentas());
    }
    
        public void eliminarFactura(){
        try {
            facturaLogica.eliminarItem(selectFactura);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Factura eliminada correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La factura no se encuentra registrada", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import logica.ColaboradorLogicaLocal;
import logica.FacturaLogicaLocal;
import logica.ProductosLogicaLocal;
import logica.VentasLogicaLocal;
import modelo.Colaborador;
import modelo.DetalleFactura;
import modelo.DetalleFacturaPK;
import modelo.Productos;
import modelo.Ventas;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author CANDELO
 */
@Named(value = "facturaVista")
@ViewScoped
@Default
@Any
public class FacturaVista implements Serializable {

    @EJB
    private FacturaLogicaLocal facturaLogica;
    @EJB
    private ProductosLogicaLocal productosLogica;
    @EJB
    private VentasLogicaLocal ventasLogica;
    @EJB
    private ColaboradorLogicaLocal colaboradorLogica;

    private List<DetalleFactura> listaFactura;
    private List<SelectItem> selectItemProducto;
    private List<SelectItem> selectItemColaborador;
    private int contadorFactura;
    private InputText txtCantidad;
    private InputText regisVenta;
    private InputText totalNeto;
    private SelectOneMenu cmbProducto;
    private SelectOneMenu cmbColaborador;
    private Calendar txtFechaVenta;
    private Double netoPagar = 0.0;
    private Double valorTotalProducto;
    private Integer cantidad = 0;
    private Double valorProducto = 0.0;
    private DetalleFactura selectFactura;
    private Ventas selectVentas;
    private Productos selectProductos;
    private Date fechaVentaActual;
    Ventas nuevaVenta = new Ventas();
    Date fechaActual = new Date();

    public List<DetalleFactura> getListaFactura() {
        listaFactura = facturaLogica.consultaFactura();
        return listaFactura;
    }

    public void setListaFactura(List<DetalleFactura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public List<SelectItem> getSelectItemProducto() {
        selectItemProducto = new ArrayList<SelectItem>();
        List<Productos> listaProducto = productosLogica.consultarProductos();

        for (int i = 0; i < listaProducto.size(); i++) {
            SelectItem empleadoItem = new SelectItem(listaProducto.get(i).getIdProductos(),
                    listaProducto.get(i).getNombreProducto());
            selectItemProducto.add(empleadoItem);
        }

        return selectItemProducto;
    }

    public List<SelectItem> getSelectItemColaborador() {
        selectItemColaborador = new ArrayList<SelectItem>();
        List<Colaborador> listaColaborador = colaboradorLogica.consultaColaboradores();

        for (int i = 0; i < listaColaborador.size(); i++) {
            SelectItem colaborador = new SelectItem(listaColaborador.get(i).getIdUsuario(),
                    listaColaborador.get(i).getNombre());
            selectItemColaborador.add(colaborador);
        }
        return selectItemColaborador;
    }

    public void setSelectItemColaborador(List<SelectItem> selectItemColaborador) {
        this.selectItemColaborador = selectItemColaborador;
    }

    public void setSelectItemProducto(List<SelectItem> selectItemProducto) {
        this.selectItemProducto = selectItemProducto;
    }

    public DetalleFactura getSelectFactura() {
        return selectFactura;
    }

    public void setSelectFactura(DetalleFactura selectFactura) {
        this.selectFactura = selectFactura;
    }

    public InputText getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(InputText txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public InputText getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(InputText totalNeto) {
        this.totalNeto = totalNeto;
    }

    public Double getNetoPagar() {
        return netoPagar;
    }

    public void setNetoPagar(Double netoPagar) {
        this.netoPagar = netoPagar;
    }

    public SelectOneMenu getCmbColaborador() {
        return cmbColaborador;
    }

    public void setCmbColaborador(SelectOneMenu cmbColaborador) {
        this.cmbColaborador = cmbColaborador;
    }

    public Calendar getTxtFechaVenta() {
        return txtFechaVenta;
    }

    public void setTxtFechaVenta(Calendar txtFechaVenta) {
        this.txtFechaVenta = txtFechaVenta;
    }

    public InputText getRegisVenta() {
        return regisVenta;
    }

    public void setRegisVenta(InputText regisVenta) {
        this.regisVenta = regisVenta;
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

    public int getContadorFactura() {
        return contadorFactura;
    }

    public void setContadorFactura(int contadorFactura) {
        this.contadorFactura = contadorFactura;
    }

    public void registrarFactura() {

        try {
            DetalleFactura nuevaFactura = new DetalleFactura();

            Productos objProducto = productosLogica.consultarxCod(Integer.parseInt(cmbProducto.getValue().toString()));

            Productos objValorVenta = productosLogica.valorProducto(objProducto);

            Ventas objIdVentas = ventasLogica.traerCodVenta();

            regisVenta.setValue(objIdVentas.getIdVentas());

            Ventas objVenta = ventasLogica.traerVenta(Integer.parseInt(regisVenta.getValue().toString()));

            nuevaFactura.setVentas(objVenta);

            nuevaFactura.setCantidad(Integer.parseInt(txtCantidad.getValue().toString()));

            cantidad = nuevaFactura.getCantidad();

            valorProducto = objValorVenta.getValorVenta();

            valorTotalProducto = cantidad * valorProducto;

            nuevaFactura.setValorPro(valorTotalProducto);

            netoPagar = netoPagar + nuevaFactura.getValorPro();
//            netoPagar += nuevaFactura.getValorPro();

            System.out.println(netoPagar);

            DetalleFacturaPK objPk = new DetalleFacturaPK();
            objPk.setCodProducto(objProducto.getIdProductos());
            objPk.setCodVenta(objVenta.getIdVentas());

            nuevaFactura.setDetalleFacturaPK(objPk);
            facturaLogica.registrarItem(nuevaFactura);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Producto Guardado.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La factura no ha sido creada", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }

    }

    public void registrarVenta() {

        try {

            Colaborador objColaborador = colaboradorLogica.consultaxIden(Integer.parseInt(cmbColaborador.getValue().toString()));
            nuevaVenta.setIdColaborador(objColaborador);

//            nuevaVenta.setFecha(fechaActual);
//            fechaVentaActual = nuevaVenta.getFecha();
            ventasLogica.registrarVenta(nuevaVenta);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Venta Registrada correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La venta ya se encuentra registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }

    }

    public void seleccionarFactura(SelectEvent fac) {
        selectFactura = (DetalleFactura) fac.getObject();
        cmbProducto.setValue(selectProductos.getIdProductos());
        txtCantidad.setValue(selectFactura.getCantidad());
        regisVenta.setValue(selectVentas.getIdVentas());
    }

    public void totalVenta() {

        try {
//            Ventas traerVenta = selectVentas;
            
            totalNeto.setValue(netoPagar);

            nuevaVenta.setFecha(fechaActual);
            Long netoPagar1 = (netoPagar).longValue();

            nuevaVenta.setValorTotal(netoPagar1);

            ventasLogica.modificarVenta(nuevaVenta);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El total de la venta.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurio un error.", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

    public FacturaVista() {
    }

}

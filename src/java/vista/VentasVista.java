/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import logica.VentasLogicaLocal;
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Named(value = "ventasVista")
@RequestScoped
public class VentasVista {
    
    @EJB
    
    private VentasLogicaLocal ventasLogica;
    
    private List<Ventas> listaVentas;

    public List<Ventas> getListaVentas() {
        listaVentas = ventasLogica.consultaVentas();
        return listaVentas;
    }

    public void setListaVentas(List<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    
    /**
     * Creates a new instance of VentasVista
     */
    public VentasVista() {
    }
    
}

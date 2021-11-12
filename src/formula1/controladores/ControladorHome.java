/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaHome;
import formula1.vistas.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author johns
 */
public class ControladorHome implements ActionListener {
    
    //atributos
    VistaHome vistaHome = new VistaHome();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();

    public ControladorHome(VistaHome vistaHome, Escuderia escuderia, Piloto piloto) {
        
        this.vistaHome = vistaHome;
        this.escuderia = escuderia;
        this.piloto = piloto;
        
        vistaHome.botonAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasEscuderia consultaEscuderia = new ConsultasEscuderia();
        String id = vistaHome.cajaIdEscuderia.getText();
        
        if (consultaEscuderia.buscarEscuderia(id) != null){
            
        }else{
            VistaIngreso vistaIngreso = new VistaIngreso();
            vistaHome.setVisible(false);
            vistaIngreso.setVisible(true);
            
            ControladorIngreso controladorIngreso = new ControladorIngreso(vistaIngreso, escuderia, piloto);
        }
    }
}

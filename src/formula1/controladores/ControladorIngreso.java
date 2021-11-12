/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.ConsultasPilotos;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author johns
 */
public class ControladorIngreso implements ActionListener {
    
    VistaIngreso vistaIngreso = new VistaIngreso();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();
    
    public ControladorIngreso(VistaIngreso vistaIngreso, Escuderia escuderia, Piloto piloto) {
        
        this.vistaIngreso = vistaIngreso;
        this.escuderia = escuderia;
        this.piloto = piloto;
        
        vistaIngreso.botonIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConsultasEscuderia consultaEscuderia = new ConsultasEscuderia();
        
        ConsultasPilotos consultasPilotos = new ConsultasPilotos();
        
        
        //resgistro de escuderia
        escuderia.setId(vistaIngreso.idEscuderia.getText());
        escuderia.setNombre(vistaIngreso.cajaNombre.getText());
        escuderia.setPresupuesto(Integer.parseInt(vistaIngreso.cajaPresupuesto.getText()));
        escuderia.setTipoMotor(vistaIngreso.cajaMotor.getText());
        
        
        //registro de pilotos
        piloto.setNombres(vistaIngreso.cajaNombre.getText());
        piloto.setApellidos(vistaIngreso.cajaApellido.getText());
        piloto.setSalario(Integer.parseInt(vistaIngreso.cajaSalario.getText()));
        
        
        //ingreso
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada = formato.format(entrada);
        
        piloto.setIdEscuderia(vistaIngreso.cajaEscuderia.getText());
        
        //llamar las consultas SQL para agregar una escuderia y un piloto
        if(consultaEscuderia.registrarEscuderia(escuderia) && consultasPilotos.registrarPiloto(piloto)){
            JOptionPane.showMessageDialog(null, "Exito agregando los datos");
        }else{
            
        }
    }
    
}

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
import formula1.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author johns
 */
public class ControladorSalida implements ActionListener {
    
    //atributos
    VistaSalida vistaSalida = new VistaSalida();
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();

    public ControladorSalida(VistaSalida vistaSalida, Escuderia escuderia, Piloto piloto) {
        
        this.vistaSalida = vistaSalida;
        this.escuderia = escuderia;
        this.piloto = piloto;
        
        vistaSalida.botonSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        ConsultasEscuderia consultaEscuderia = new ConsultasEscuderia();
        
        ConsultasPilotos consultaPilotos = new ConsultasPilotos();
        
        
        //consultar los datos del piloto a buscar  para poder editarlo
        consultaPilotos.buscarPiloto(Integer.parseInt(vistaSalida.jLabel1.getText()));
                
        
        //consultar la fecha entrada String
        String fechaEntrada = piloto.getFechaIn();
                
        
        //convertir la fecha String en date
        try{
            Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
            Date salida = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaSalida = formato.format(salida);
                    
            //rutina para calcular la resta de tiempo
            long tiempoDiferencia = salida.getTime() - entrada.getTime();
            TimeUnit unidadTiempo = TimeUnit.MINUTES;
            long tiempoEnEscuderia = unidadTiempo.convert(tiempoDiferencia, TimeUnit.MILLISECONDS);
            
            //llevemos el valor de la fecha salida Sting al objeto piloto
            piloto.setFechaOut(fechaSalida);
            
            
            //ejecutar la consulta para actulizar el piloto
            if(consultaPilotos.actualizarPiloto(piloto)){
                JOptionPane.showMessageDialog(null, "Exito retirando, su tiempo fue de: " + tiempoEnEscuderia + "min");
            }else{
                JOptionPane.showMessageDialog(null, "Fallamos retirando");
            }
                    
            
        }catch ( ParseException err){
            System.out.println("Upssss..." + err);
        }
            
    }
    
    
    
}

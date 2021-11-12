
package formula1;

import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaHome;
import formula1.controladores.ControladorHome;


public class Formula1 {

    
    public static void main(String[] args) {
        
        VistaHome vistaHome = new VistaHome();
        vistaHome.setVisible(true);
        Escuderia escuderia = new Escuderia();
        Piloto piloto = new Piloto();
        
     ControladorHome controladorHome = new ControladorHome(vistaHome, escuderia, piloto);
     
        
    }

    
}

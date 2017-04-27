
package jfacebook;

import facebook4j.FacebookException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Brais Núñez
 */
public class JFacebook {

    /**
     * Menú con las llamadas a los distintos métodos mediante la pulsación de un número.
     * <ul>
     * <li>1.Publicar un estado.
     * <li>2.Comentar una foto.
     * <li>3.Publicar una foto.
     * <li>4.Busca una publicación.
     * <li>5.Busca un feed.
     * <ul>
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, FacebookException {
               
        Autorizacion.conectar();
               
       int opcion;
    
       do {

  opcion = Integer.parseInt(JOptionPane.showInputDialog("1.Publicar Estado \n 2.Comentar foto \n 3.Postear Foto \n 4.Buscar Post \n 5.Buscar Noticias \n 0.Salir"));

    switch(opcion){

        case 1:Autorizacion.publicarEstado();

            break;

        case 2:Autorizacion.comentarFoto();

            break;

        case 3:Autorizacion.postearFoto();

            break;

        case 4:Autorizacion.buscarPost();

            break;
            
        case 5:Autorizacion.buscarNoticias();
        
            break;
        
        default:
            
            break;

    }

          }while(opcion!=0);
    }
}
    


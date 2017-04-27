
package jfacebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Brais Núñez
 */

/**
 * Contiene los métodos para manejar los permisos y para realizar distintas acciones.
 * 
 */

public class Autorizacion {
    
    static Facebook fb;

    /**

     * Se configuran permisos para poder utilizar funciones de facebook, en este caso enviar y 
     * recibir datos.

     */
    
    public static void conectar(){

    ConfigurationBuilder cb = new ConfigurationBuilder();

    cb.setDebugEnabled(true)

    .setOAuthAppId("Introducir token propio")

    .setOAuthAppSecret("Introducir token propio")

    .setOAuthAccessToken("Introducir token propio")

    .setOAuthPermissions("email,publish_stream,publish_actions,user_likes,manage_pages,read_stream");

    FacebookFactory ffact = new FacebookFactory(cb.build());

    fb = ffact.getInstance();
    
    }
    
    /**
     * Publica un enlace a una imagen mediante su URL
     * @throws MalformedURLException
     * @throws FacebookException 
     */
 
    public static void postearFoto() throws MalformedURLException, FacebookException {

            PostUpdate post = new PostUpdate(new URL("https://media-public.fcbarcelona.com/20157/0/document_thumbnail/20197/110/5/184/45614446/1.0-10/watermark/45614446.jpg"))
                    .picture(new URL("https://media-public.fcbarcelona.com/20157/0/document_thumbnail/20197/110/5/184/45614446/1.0-10/watermark/45614446.jpg"))
                    .name("Leo Messi silencia el Bernabeu")
                    .caption("fcbarcelona.es")
                    .description("Celebración de Leo Messi tras lograr el tercer gol contra el Real Madrid");
            fb.postFeed(post);
            
            JOptionPane.showMessageDialog(null, "Foto publicada");          
    }

    /**
     * Publica un estado pedido por teclado.
     * @throws FacebookException 
     */
    
    public static void publicarEstado() throws FacebookException {

        fb.postStatusMessage(JOptionPane.showInputDialog("Introducir estado a publicar"));
        JOptionPane.showMessageDialog(null, "Estado publicado");
    }

    /**
     * Busca un post con datos introducidos por teclado y lo muestra.
     * @throws FacebookException 
     */
    public static void buscarPost() throws FacebookException{

        String busqueda = JOptionPane.showInputDialog("Introduzca lo que desea buscar");
        
            ResponseList<Post> resultado = fb.getPosts(busqueda);
            System.out.println(resultado);            
    }
   
    /**
     * Publica un comentario en una foto introduciendo por teclado el ID de la foto y el comentario deseado.
     */
    
    public static void comentarFoto(){
    
        String IDfoto = JOptionPane.showInputDialog("Introducir identificador de la foto a comentar");
        String comentario = JOptionPane.showInputDialog("Introducir comentario");
        
        try {

            fb.commentPhoto(IDfoto, comentario);
            JOptionPane.showMessageDialog(null, "Comentario realizado");
        } catch (FacebookException ex) {

            Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Busca un feed introducido por teclado y lo muestra.
     * @throws FacebookException 
     */
    public static void buscarNoticias() throws FacebookException{
        ResponseList<Post> noticia = fb.getFeed(JOptionPane.showInputDialog("Introducir feed a buscar"));
            System.out.println(noticia);
        
        JOptionPane.showMessageDialog(null, "Búsqueda realizada");
    }
}

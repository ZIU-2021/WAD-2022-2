package servidor;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Servidor implements java.io.Serializable{
    
    static ArrayList<Producto> productos = new ArrayList();
    
    public static void llenararray() throws FileNotFoundException{
        int aux = 1;
        String datos;
        
        try {
            String directorio = System.getProperty("user.dir");
            InputStream ins = new FileInputStream(directorio + "\\src\\servidor\\Productos.txt");
            Scanner obj = new Scanner(ins);
                while (obj.hasNextLine()){
                    System.out.println("Aqui");
                    datos = obj.nextLine();
                    String[] split = datos.split(",");
                    BufferedImage bufferedImage = ImageIO.read(new File(directorio + "\\src\\servidor\\imgs\\" + String.valueOf(aux) + ".jpg"));
                    Image image = bufferedImage.getScaledInstance(50, 40, Image.SCALE_DEFAULT);
                    Producto producto = new Producto(Integer.parseInt(split[0]), split[1], new ImageIcon(image), split[2], Float.valueOf(split[3]), Integer.parseInt(split[4]));
                    productos.add(producto);
                    aux ++;
                }
        } catch (IOException | NumberFormatException e) {
            
        }        
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            DataInputStream bufferDeEntrada = null;
            String recibido = "";
            ObjectOutputStream salidaObjetos;
            ObjectInputStream entradaObjetos;
            InputStream entrada;
            OutputStream salida;
            
            ServerSocket ser = new ServerSocket(1234);
            
            llenararray();

            while(true){
                //Creamos variable semaforo
                boolean con = true;
                //Esperamos conexion
                System.out.println("Esperando por un cliente ...");
                try ( //Aceptamos conexion
                    Socket cl = ser.accept()) {
                    System.out.println("Conexión establecida desde" + cl.getInetAddress() + ":" + cl.getPort());
                    
                    entrada = cl.getInputStream();
                    salida = cl.getOutputStream();
                    
                    salidaObjetos = new ObjectOutputStream (salida);
                    salidaObjetos.writeObject(productos);
                    
                    while(con){
                        //Leemos la operacion
                        bufferDeEntrada = new DataInputStream(entrada);
                        recibido = (String) bufferDeEntrada.readUTF();
                        
                        if(recibido.equals("Finalizar")){
                            con = false;
                            cl.close();
                            System.out.println("Opcion finalizar");
                        }
                        else if(recibido.equals("Comprar")){
                            System.out.println("Opcion comprar");
                            //Cargamos el archivo
                            entradaObjetos = new ObjectInputStream(entrada);
                            productos = (ArrayList<Producto>) entradaObjetos.readObject();
                        }
                    }
                }
            }
        }catch(IOException e){

        }
    }
}
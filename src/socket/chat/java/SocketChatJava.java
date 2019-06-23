
package socket.chat.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class SocketChatJava {
    
    public static String hostname;
    public static InetAddress ip;
    
    public static void main(String[] args) {
        
        /*
        GetIPHostname();
        
        while(true){
            String in = JOptionPane.showInputDialog("Mensaje: [-exit- to abort]");
            if (in.equals("exit")){
                break;
            }else{
               String message = in+","+ip;
               SendMessage(message); 
            }
        }

        
        */
        //receiveMessage();
    }
    
    
    public static void receiveMessage(){
        try {
            
            Socket s;
            ServerSocket ss;
            
            InputStreamReader isr;
            BufferedReader bufferedReader;
            String message;
            
            ss = new ServerSocket(8888);

            while (true) {
                s = ss.accept();
                isr = new InputStreamReader(s.getInputStream());
                bufferedReader = new BufferedReader(isr);
                message = bufferedReader.readLine();

                //final String[] msg = message.split(",");
                
                System.out.println(message);

            }
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    
    public static void SendMessage(String message){

        try {
            String ip = "192.168.1.64";
            Socket s = new Socket(ip, 8888);
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            pw.write(message);
            pw.flush();
            s.close();
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,e);
            System.exit(0);
        }
    }
    
    public static void GetIPHostname(){
               
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            //System.out.println("Your current IP address : " + ip);
            //System.out.println("Your current Hostname : " + hostname);
 
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null,e);
            System.exit(0);
        }
    }
    
}

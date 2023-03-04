package roborace;

import COSC3P91.graphics.ImageManager;
import COSC3P91.xml.XMLReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import roborace.common.NetworkPort;
import roborace.common.GameDialogs;
import roborace.common.Port;
import roborace.server.GameMaster;

public class RoboRaceServer {
    
    private static final int PORT = 10997;
      
    public static void main(String[] args) {
    	JFrame.setDefaultLookAndFeelDecorated(true);
	JDialog.setDefaultLookAndFeelDecorated(true);
        ImageManager.getInstance().setImagePath("./Images/");
	XMLReader.setXMLPath("./");
	XMLReader.setXSDPath("./XSD/");
        
    	int nHuman = 0;
    	while (nHuman == 0 || nHuman > 4) {
            try {
                nHuman = Integer.parseInt(GameDialogs.showInputDialog("Number of players", "Please, input the number of players (1-4):",null));
            } catch (NumberFormatException e) {}
            
            
        }
        
         NetworkPort[] network = new NetworkPort[nHuman];
        String [] name = new String[nHuman];
        try { 
            ServerSocket Serversocket = new ServerSocket(PORT);
            
            for(int i=0; i < nHuman; i++) {

                network[i] = new NetworkPort(Serversocket.accept());
                name[i] = network[i].receive();
                System.out.println(i);
                network[i].send(String.valueOf(i));
            }
            
              (new GameMaster(name,network)).run();
              
        } catch (IOException ex) {
            
        }
        
       
        
    }	   
}
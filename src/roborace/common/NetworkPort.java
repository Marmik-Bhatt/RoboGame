package roborace.common;

import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class NetworkPort implements Port {
        
     private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;
    
    
    public NetworkPort(Socket socket) {
        this.socket = socket;
        try {
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter((socket.getOutputStream()));
        }
        catch (IOException e){
        }
    }

    @Override
    public synchronized void send(String message) { 
        writer.println(message);
        writer.println("\0");
        writer.flush();
    }

    @Override
    public synchronized String receive()  {
          String res = "";
        while (true){
            try {
                String input = reader.readLine();
                
                if (input.contains("\0")){
                    
                    break;
                }
                res += input;
            }
            catch (IOException e){

            }
        }
        return res;
    }

    @Override
    public void close() throws IOException {
         reader.close();
        writer.close();
        socket.close();
       
    }	
}
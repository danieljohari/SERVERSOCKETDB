import java.io.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;

public class ServerProjekt {

    static ServerSocket welcomeSocket;

    static {
        try {
            welcomeSocket = new ServerSocket(33333);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Socket connectionSocket;

    static {
        try {
            connectionSocket = welcomeSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public ServerProjekt() throws IOException {
    }

    public static String[] sendToKlient() throws IOException {
        String clientSentence = null;
        String[] clientResponse;
        String mailTilDb = null;
        String passTilDb = null;


            //if (welcomeSocket.isBound()){

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            clientSentence = inFromClient.readLine();

            clientResponse = clientSentence.split("&");

            String[] mail1;
            mail1 = clientResponse[0].split("=");

            mailTilDb = mail1[1];

            String[] pass1;
            pass1 = clientResponse[1].split("=");

            passTilDb = pass1[1];

            System.out.println("FRA KLIENT:" + clientSentence);
            //  System.out.println("FRA SERVER: " + serverSentence);




        //}
        String[] returnString = new String[]{mailTilDb, passTilDb};
        return returnString;
    }


            public static String sendFromServer(String outToServer) throws IOException {
        
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                outToServer = DBSearch.X;

              outToClient.writeBytes(outToServer);

                return outToServer;
            }

        }



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OnlineGame {
    private static ServerSocket host;
    private static Socket hostsConnection;
    private static ObjectOutputStream hostsOutput;
    private static ObjectInputStream hostsInput;

    private static ObjectOutputStream joinOuput;
    private static ObjectInputStream joinInput;
    private static String hostIP;
    private static Socket joinConnection;

    private Scanner reader = new Scanner(System.in);

    public static void hostGameOnline(){
        try{
            host = new ServerSocket(4444, 100);

            while(true){
                waitForOpponent();
                getOpponentsStream();

            }

        }
        catch(IOException serverStreamProblem){
            System.out.println("Connection broke: "+serverStreamProblem);
        }
    }
    public static void joinGameOnline(){

    }

    /////stuff for hosting///////
    public static void waitForOpponent() throws IOException{
        System.out.println("Host: 'waiting for opponent' ");
        hostsConnection = host.accept();
        System.out.println("Host: 'Opponent Found!'. Opponent: "+ hostsConnection.getInetAddress().getHostName());
    }
    public static void getOpponentsStream() throws IOException{
        hostsOutput = new ObjectOutputStream(hostsConnection.getOutputStream());
        hostsOutput.flush();

        hostsInput = new ObjectInputStream(hostsConnection.getInputStream());
        System.out.println("Streams crossed");
    }
    public void processConnection() throws IOException{

    }
    /////////////////////////////
}

import java.util.Scanner;

public class Driver {
    public static void main (String args[]){
        Scanner reader = new Scanner(System.in);
        int onlineCheck;
        System.out.println("1- online, 2- Local");
        onlineCheck = Integer.parseInt(reader.nextLine());

        if(onlineCheck ==1){
            System.out.println("1- host game, 2- join game");
            int hostCheck = Integer.parseInt(reader.nextLine());
            if(hostCheck ==1){
                OnlineGame.hostGameOnline();
            }
            else if (hostCheck ==2){
                OnlineGame.joinGameOnline("127.0.0.1");
            }
        }
        else if(onlineCheck ==2){
            RunGame.runLocally();
        }


    }
}

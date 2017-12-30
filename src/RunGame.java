import java.util.Random;
import java.util.Scanner;

public class RunGame {
    public static void main (String args[]){
        Random diceRoll = new Random();
        Scanner reader = new Scanner(System.in);
        GameBoard testBoard = new GameBoard();


        Player player1 = new Player(1);
        Player player2 = new Player(2);

        //testBoard.printBoard();


        int turnCount =1;
        //int roll = diceRoll.nextInt(3);
        int roll = Integer.parseInt(reader.nextLine());


        while(true){
            System.out.println("Roll: "+roll);
            System.out.println("pick stone to move");

            int stoneToMove = Integer.parseInt(reader.nextLine());

            if(player1.checkValidMove(stoneToMove,roll)){
                player1.stoneToMove(stoneToMove,roll);
                testBoard.updateBoard();
                turnCount++;
                //roll = diceRoll.nextInt(3);
                roll = Integer.parseInt(reader.nextLine());

            }
            else{
                System.out.println("Invalid move pick different stone");
            }
        }
    }
}

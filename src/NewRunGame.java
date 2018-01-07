import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class NewRunGame {
    private Player player1;
    private Player player2;
    private Player localPlayer;
    private Player connectedPlayer;
    private GameBoard gameBoard;
    private int turnCount;
    private Scanner reader = new Scanner (System.in);
    private Random diceRoll = new Random();

    public NewRunGame(int player1or2){
        this.gameBoard = new GameBoard();
        player1 = new Player(1);
        player2 = new Player(2);

        if(player1or2 ==1) {
            localPlayer = player1;
            connectedPlayer = player2;
        }
        else{
            localPlayer = player2;
            connectedPlayer = player1;
        }
        turnCount = 1;
    }
    public NewRunGame(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    public void selfNextMove(){
        int roll = diceRoll.nextInt(3);
        System.out.println("roll: "+roll);
        System.out.println("pick stone to move");
        int stoneToMove = Integer.parseInt(reader.nextLine());

        if (localPlayer.checkValidMove(stoneToMove, roll)) {
            localPlayer.stoneToMove(stoneToMove, roll, connectedPlayer);
            gameBoard.updateBoard();
            turnCount++;
            String moveInfo = diceRoll+""+stoneToMove;
            try {
                OnlineGame.sendData(roll, stoneToMove);
            } catch (IOException error){
                System.out.println("Error sending move from host "+error);
            }

        } else {
            System.out.println("Invalid move pick different stone");
        }
    }

    public void otherPlayerMove(int enemyRoll, int enemyStoneMove){
        int roll = enemyRoll;
        System.out.println("roll: "+roll);
        System.out.println("pick stone to move");
        int stoneToMove = enemyStoneMove;

        if (connectedPlayer.checkValidMove(stoneToMove, roll)) {
            connectedPlayer.stoneToMove(stoneToMove, roll, localPlayer);
            gameBoard.updateBoard();
            turnCount++;
            try {
                OnlineGame.sendData(roll,stoneToMove);
            } catch (IOException error){
                System.out.println("Error sending move from host "+error);
            }

        } else {
            System.out.println("Invalid move pick different stone");
        }
    }

}

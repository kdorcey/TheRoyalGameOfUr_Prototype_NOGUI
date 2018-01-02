/***
 * THE GameBoard CLASS MUST BE INSTANTIATED BEFORE THIS CLASS
 */
public class Player {
    private int playerNumber; //1 or 2
    private int remainingStones;
    private Stones[] playerStones;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
        playerStones = new Stones[7];

        for (int i = 0; i < 7; i++) {
            playerStones[i] = new Stones(this);
            playerStones[i].defineMoveSet();
        }
    }


    public void stoneToMove(int stoneNumber, int roll, Player lastPlayer) {

        playerStones[stoneNumber - 1].moveStone(roll);


    }

    public boolean checkValidMove(int stoneNumber, int roll) {
        boolean validMove = false;

        if (!playerStones[stoneNumber - 1].isStoneFinished()) {
            if (playerStones[stoneNumber - 1].moveStoneCheck(roll)) {
                validMove = true;
            }
        }

        return validMove;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Stones[] getPlayerStones() {
        return playerStones;
    }

    public String toString(){
        return "Player "+playerNumber;
    }
}


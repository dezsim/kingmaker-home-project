package hu.flowacademy.kingmakerbackend.model.game;

import hu.flowacademy.kingmakerbackend.model.Player;

public class GameModel {

    private boolean hasWinner;
    private Player playerRed;
    private Player playerBlue;
    private int currentTurn;

    GameModel(){
    }

    public GameModel(Player playerRed, Player playerBlue) {
        this.playerRed = playerRed;
        this.playerBlue = playerBlue;
        this.currentTurn = 0;
    }

    public boolean isHasWinner() {
        return hasWinner;
    }

    public void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }

    public Player getPlayerRed() {
        return playerRed;
    }

    public void setPlayerRed(Player playerRed) {
        this.playerRed = playerRed;
    }

    public Player getPlayerBlue() {
        return playerBlue;
    }

    public void setPlayerBlue(Player playerBlue) {
        this.playerBlue = playerBlue;
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }
}

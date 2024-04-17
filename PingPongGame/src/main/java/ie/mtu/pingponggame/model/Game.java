package ie.mtu.pingponggame.model;

import javafx.application.Platform;
import javafx.print.PageLayout;

public class Game implements Resizable{
    private int Target;
    private Player Player1;
    private Player Player2;
    private Racket Racket1;
    private Racket Racket2;
    private Ball GameBall;
    private double DimensionX;
    private double DimensionY;


    public Game(Player Player1, Player Player2, Racket Racket1, Racket Racket2, Ball GameBall, int Target, double DimensionX, double DimensionY){
        this.Player1=Player1;
        this.Player2=Player2;
        this.Racket1=Racket1;
        this.Racket2=Racket2;
        this.GameBall=GameBall;
        this.Target=Target;
        this.DimensionX=DimensionX;
        this.DimensionY=DimensionY;
    }

    public Game() {

    }

    public int getTarget() {
        return Target;
    }

    public void setTarget(int target) {
        Target = target;
    }

    public Player getPlayer1() {
        return Player1;
    }

    public void setPlayer1(Player player1) {
        Player1 = player1;
    }

    public Player getPlayer2() {
        return Player2;
    }

    public void setPlayer2(Player player2) {
        Player2 = player2;
    }

    public Racket getRacket1() {
        return Racket1;
    }

    public void setRacket1(Racket racket1) {
        Racket1 = racket1;
    }

    public Racket getRacket2() {
        return Racket2;
    }

    public void setRacket2(Racket racket2) {
        Racket2 = racket2;
    }

    public Ball getGameBall() {
        return GameBall;
    }

    public void setGameBall(Ball gameBall) {
        GameBall = gameBall;
    }

    public double getDimensionX() {
        return DimensionX;
    }

    public void setDimensionX(double dimensionX) {
        DimensionX = dimensionX;
    }

    public double getDimensionY() {
        return DimensionY;
    }

    public void setDimensionY(double dimensionY) {
        DimensionY = dimensionY;
    }

    public void setWin() {
        if (getPlayer1().getScore() == getTarget()) {
            System.out.println("Winner: " + getPlayer1().getName());
            getGameBall().setDy(0);
            getGameBall().setDx(0);
            Platform.exit();
        }
        else if (getPlayer2().getScore() == getTarget()) {
            System.out.println("Winner: " + getPlayer2().getName());
            getGameBall().setDy(0);
            getGameBall().setDx(0);
            Platform.exit();
        }
    }

    /**
     * Allows for window resizing of all game objects as canvas changes.
     * @param factor
     */
    @Override
    public void resizeX(double factor) {
        Racket1.setPosX(Racket1.getPosX()*factor);
        Racket2.setPosX(Racket2.getPosX()*factor);
        GameBall.setPosX(GameBall.getPosX()*factor);
    }

    @Override
    public void resizeY(double factor) {
        Racket1.setPosY(Racket1.getPosY()*factor);
        Racket2.setPosY(Racket2.getPosY()*factor);
        GameBall.setPosY(GameBall.getPosY()*factor);
    }
}

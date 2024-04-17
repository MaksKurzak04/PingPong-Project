package ie.mtu.pingponggame.controller;

import ie.mtu.pingponggame.model.Ball;
import ie.mtu.pingponggame.model.Game;
import ie.mtu.pingponggame.model.Player;
import ie.mtu.pingponggame.model.Racket;
import javafx.application.Platform;

/**
 * This class declares and makes all objects appear on canvas.
 * <p>
 *     More specifically gives game its objects.
 * </p>
 */
public class MainController {
    private Game game;

    public MainController(){
        Player Player1 = new Player("Player 1");
        Player PLayer2 = new Player("Player 2");

        Ball GameBall = new Ball(200,180,30);

        Racket Racket1 = new Racket(30,90,150,25);
        Racket Racket2 = new Racket(535,150,150,25);

        Racket1.setTopY(500);
        Racket1.setBottomY(100);

        double DimensionX = 600;
        double DimensionY = 400;

        int Target = 3;

        this.game = new Game(Player1,PLayer2, Racket1, Racket2, GameBall, Target, DimensionX, DimensionY);
    }

    public Game getGame(){return this.game;}

    public void setGame(Game game){this.game = game;}
}

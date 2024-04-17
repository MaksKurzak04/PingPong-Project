package ie.mtu.pingponggame.view;


import ie.mtu.pingponggame.model.Ball;
import ie.mtu.pingponggame.model.Game;
import ie.mtu.pingponggame.model.Player;
import ie.mtu.pingponggame.model.Racket;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This class gives us the view og the game.
 */
public class GameCanvas extends javafx.scene.canvas.Canvas{
    public GameCanvas(double width, double height){
        super(width, height);
    }

    public void drawGame(Game game) {
        this.resetSize(game);
        GraphicsContext gc = this.getGraphicsContext2D();
        this.drawBackground(gc);
        this.drawBall(gc, game.getGameBall());
        this.drawRackets(gc, game.getRacket1(), game.getRacket2());
        game.getPlayer1().setNameX(10);
        game.getPlayer1().setNameY(40);
        game.getPlayer2().setNameX(game.getDimensionX() - 90);
        game.getPlayer2().setNameY(40);
        this.drawTitle(gc, game.getPlayer1());
        this.drawTitle(gc, game.getPlayer2());
        this.drawScore(gc, game.getPlayer1(), game.getPlayer2());
    }


    /**
     *
     * @param gc
     * @param GameBall
     */
    private void drawBall(GraphicsContext gc, Ball GameBall){
        gc.setFill(Color.TOMATO);
        gc.fillOval(GameBall.getPosX(), GameBall.getPosY(), GameBall.getRadius(), GameBall.getRadius());
    }

    /**
     *
     * @param gc
     * @param Racket1
     * @param Racket2
     */
    private void drawRackets(GraphicsContext gc, Racket Racket1, Racket Racket2){
        gc.setFill(Color.ROYALBLUE);
        gc.fillRect(Racket1.getPosX(), Racket1.getPosY(), Racket1.getThickness(), Racket1.getSize());
        gc.fillRect(Racket2.getPosX(), Racket2.getPosY(), Racket2.getThickness(), Racket2.getSize());
    }

    /**
     *Method to draw player scores
     * @param gc
     * @param Player1
     * @param Player2
     */
    private void drawScore(GraphicsContext gc, Player Player1, Player Player2){
        gc.setFill(Color.BLACK);
        gc.fillText(Player1.getName() + ": " + Player1.getScore(), Player1.getNameX(), Player1.getNameY());
        gc.fillText(Player2.getName() + ": " + Player2.getScore(), Player2.getNameX(), Player2.getNameY());
    }

    /**
     *
     * @param gc
     */
    private void drawBackground(GraphicsContext gc){
        gc.setFill(Color.WHITESMOKE);
        gc.clearRect(0.0, 0.0, this.getWidth(), this.getHeight());
        gc.fillRect(0.0, 0.0, this.getWidth(), this.getHeight());
    }

    /**
     *
     * @param game
     */
    private void resetSize(Game game){
        this.setWidth(game.getDimensionX());
        this.setHeight(game.getDimensionY());
    }

    /**
     *
     * @param gc
     * @param player
     */
    private void drawTitle(GraphicsContext gc, Player player){
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Ariel"));
    }


}


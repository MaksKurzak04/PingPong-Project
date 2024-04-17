package ie.mtu.pingponggame.controller;

import ie.mtu.pingponggame.model.Game;
import ie.mtu.pingponggame.view.GameCanvas;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * This class listens to keyboard inputs which move player rackets.
 */
public class KeyboardListener implements EventHandler<KeyEvent> {
    private Game game;
    private GameCanvas canvas;
    private boolean Paused = false;

    private double oldSpeedDy;
    private double oldSpeedDx;

    void GamePause(){
        Paused = !Paused;

        if (Paused){
            oldSpeedDy = game.getGameBall().getDy();
            oldSpeedDx = game.getGameBall().getDx();

            game.getGameBall().setDy(0);
            game.getGameBall().setDx(0);
        }
        if (!Paused){
            game.getGameBall().setDy(oldSpeedDy);
            game.getGameBall().setDx(oldSpeedDx);
        }
    }

    void SaveGame(){
        Alert save = new Alert(Alert.AlertType.CONFIRMATION);
        save.setTitle("Save Game");
        save.showAndWait().ifPresent((btnType -> {}));
    }


    void Movement(KeyCode key){
        if (KeyCode.UP.equals(key))
        {
            game.getRacket2().moveDown();
        }
        if (KeyCode.DOWN.equals(key))
        {
            game.getRacket2().moveUp();
        }
        if (KeyCode.A.equals(key))
        {
            game.getRacket1().moveDown();
        }
        if (KeyCode.Z.equals(key))
        {
            game.getRacket1().moveUp();
        }
    }

    /**
     *
     * @param game2
     * @param canvas
     */
    public KeyboardListener(Game game2, GameCanvas canvas) {
        this.game =game2;
        this.canvas =canvas;
    }
    @Override
    public void handle(KeyEvent keyEvent) {
        System.out.println(keyEvent);
        KeyCode key=keyEvent.getCode();

        if (KeyCode.ESCAPE.equals(key)){
            GamePause();
        }
        else if (!Paused) {
            Movement(key);
        }

        if (KeyCode.S.equals(key)){
            SaveGame();

            String score1 = String.format("%d",game.getPlayer1().getScore());
            String score2 = String.format("%d",game.getPlayer2().getScore());

            Path path = Paths.get("C:\\Users\\kurza\\IdeaProjects\\PingPongGame\\src\\main\\java\\ie\\mtu" +
                    "\\pingponggame\\Scores");

            String str = "Player 1 score:"+score1+"\nPlayer 2 score:"+score2;

            try {
                Files.writeString(path,str);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        canvas.drawGame(game);
    }
}

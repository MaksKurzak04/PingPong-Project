package ie.mtu.pingponggame.controller;

import ie.mtu.pingponggame.GameApplication;
import ie.mtu.pingponggame.model.Game;
import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextInputDialog;

/**
 * This class allows user to navigate/interact with menu features.
 */
public class MenuListener {
    private Game game;

    public MenuListener(Game game){this.game = game;}

    public void restartGame(){
        game.getPlayer1().setScore(0);
        game.getPlayer2().setScore(0);
        game.getGameBall().setPosX(200);
        game.getGameBall().setPosY(100);
        game.getGameBall().setDx(1);
        game.getGameBall().setDy(1);
        game.getRacket1().setPosY(200);
        game.getRacket2().setPosY(200);
    }


    public void setExit(){
        System.out.println("Exit");
        Platform.exit();

    }

    public void setAbout(){
        System.out.println("About");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ping Pong Info");
        alert.setHeaderText("Made in Cork");
        alert.setContentText("All rights reserved");
        alert.showAndWait().ifPresent((btnType -> {}));
    }

    public void setGameLimit(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Title");
    }
}

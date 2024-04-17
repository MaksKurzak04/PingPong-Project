package ie.mtu.pingponggame;

import ie.mtu.pingponggame.controller.BallManager;
import ie.mtu.pingponggame.controller.KeyboardListener;
import ie.mtu.pingponggame.controller.MainController;
import ie.mtu.pingponggame.controller.MenuListener;
import ie.mtu.pingponggame.view.GameCanvas;
import ie.mtu.pingponggame.view.GameMenu;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Maksymilian
 * @version 1.0
 */

public class GameApplication extends javafx.application.Application {
    private MainController mainController = new MainController();
    private MenuListener menuListener;
    private GameMenu myMenu;

    public GameApplication(){
        this.menuListener = new MenuListener(this.mainController.getGame());
        this.myMenu = new GameMenu(this.menuListener);
    }

    /**
     *Main class
     * @param args
     */
    public static void main(String[] args){launch(args);}

    public void start(Stage primaryStage){
        primaryStage.setTitle("Ping Pong");
        BorderPane root = new BorderPane();
        root.setTop(this.myMenu.getMenuBar());
        primaryStage.setScene(new Scene(root, 600, 400));
        GameCanvas canvas = new GameCanvas(600,400);
        root.setCenter(canvas);
        canvas.drawGame(this.mainController.getGame());

        primaryStage.widthProperty().addListener((observable) -> {
            double factor = primaryStage.getWidth() / this.mainController.getGame().getDimensionX();
            System.out.println("Width Changed " + primaryStage.getWidth()+" "+factor);
            this.mainController.getGame().setDimensionX(primaryStage.getWidth());
            this.mainController.getGame().resizeX(factor);
            canvas.drawGame(this.mainController.getGame());
        });

        primaryStage.heightProperty().addListener((observable) -> {
            double factor = primaryStage.getHeight() / this.mainController.getGame().getDimensionY();
            System.out.println("Height Changed " + primaryStage.getHeight()+" "+factor);
            this.mainController.getGame().setDimensionY(primaryStage.getHeight());
            this.mainController.getGame().resizeY(factor);
            canvas.drawGame(this.mainController.getGame());
        });

        KeyboardListener keyboardListener = new KeyboardListener( mainController.getGame(), canvas);
        canvas.setOnKeyPressed(keyboardListener );
        canvas.setOnKeyTyped(keyboardListener );
        canvas.setFocusTraversable(true);

        BallManager ballManager= new BallManager(mainController.getGame(), canvas);
        Thread thread = new Thread(ballManager);
        thread.start();
        Thread.yield();

        primaryStage.show();
    }
}

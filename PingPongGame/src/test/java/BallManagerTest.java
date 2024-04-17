
import static org.junit.Assert.*;

import ie.mtu.pingponggame.controller.BallManager;
import ie.mtu.pingponggame.model.Game;
import ie.mtu.pingponggame.view.GameCanvas;
import org.junit.Before;
import org.junit.Test;
public class BallManagerTest {
    Game game = new Game();
    GameCanvas canvas = new GameCanvas(600, 600);
    BallManager manager = new BallManager(game, canvas);

    @Before
    public void initialise()
    {
        game.setDimensionX(600);
        game.setDimensionY(600);
        game.setTarget(10);
    }
    @Test
    public void testEndoFGame() {
        game.getPlayer1().setScore(7);
        game.getPlayer1().setScore(11);
// score is 11-7 up to 10
        assertTrue(manager.checkEndOfGame(game));
// score is 7-7 up to 10
        game.getPlayer1().setScore(7);
        assertFalse(manager.checkEndOfGame(game));
    }
    @Test
    public void testGoalPlayer2()
    {
        game.getGameBall().setPosX(1);
        assertTrue(manager.player2Scores(game));
        game.getGameBall().setPosX(100);
        assertFalse(manager.player2Scores(game));
    }
}

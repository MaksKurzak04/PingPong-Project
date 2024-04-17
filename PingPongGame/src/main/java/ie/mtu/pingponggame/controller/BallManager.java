package ie.mtu.pingponggame.controller;


import ie.mtu.pingponggame.model.Ball;
import ie.mtu.pingponggame.model.Game;
import ie.mtu.pingponggame.model.Racket;
import ie.mtu.pingponggame.view.GameCanvas;

/**
 * This class controls the behaviour of the ball.
 * <p>
 *     Performs bounce, reset and checks collsion of ball object.
 * </p>
 */

public class BallManager implements Runnable{
    private Game game;
    private GameCanvas canvas;
    public BallManager(Game c, GameCanvas canvas) {
        this.game=c;
        this.canvas=canvas;
    }

    /**
     * Runs the code to make ball move on screen.
     */
    @Override
    public void run() {
        Ball ball = game.getGameBall();
        int counter=0;
        while(true)
        {
            counter++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ball.move();
            ball.checkCollision(game.getDimensionX(),game.getDimensionY());
            checkRacketBounce(ball);
            speedupBall();

            if (ball.getPosX() < 10) {
                game.getPlayer2().setScore(game.getPlayer2().getScore() + 1); // Player 2 scores
                resetBall();
                game.setWin();
            }
            if (ball.getPosX() > game.getDimensionX() - ball.getRadius()) {
                game.getPlayer1().setScore(game.getPlayer1().getScore() + 1);
                resetBall();
                game.setWin();
            }
            canvas.drawGame(game);
        }
    }

    /**
     * Changes direction of ball upon hit with racket 1 or 2.
     * @param ball
     */
    public void checkRacketBounce(Ball ball) {
        Racket racket1 = game.getRacket1();
        Racket racket2 = game.getRacket2();

        // Check collision with Racket 1
        if (ball.getPosX() - ball.getRadius() <= racket1.getPosX() + racket1.getThickness() - 30 &&
                ball.getPosX() - ball.getRadius() >= racket1.getPosX() - 30 &&
                ball.getPosY() >= racket1.getPosY() &&
                ball.getPosY() <= racket1.getPosY() + racket1.getSize()) {
            ball.setDx(-ball.getDx());
        }

        // Check collision with Racket 2
        if (ball.getPosX() + ball.getRadius() >= racket2.getPosX() &&
                ball.getPosX() + ball.getRadius() <= racket2.getPosX() + racket2.getThickness() &&
                ball.getPosY() >= racket2.getPosY() &&
                ball.getPosY() <= racket2.getPosY() + racket2.getSize()) {
            ball.setDx(-ball.getDx());
        }
    }

    /**
     * when a score occurs the ball is reset to centre of field.
     */
    private void resetBall() {
        Ball ball = game.getGameBall();
        ball.setPosX(game.getDimensionX() / 2); // Reset ball position to center X
        ball.setPosY(game.getDimensionY() / 2); // Reset ball position to center Y
        ball.setDx(1); // Reset ball's x velocity
        ball.setDy(1); // Reset ball's y velocity
    }

    /**
     * After every bounce the ball speeds up its velocity.
     */
    private void speedupBall() {
        Ball ball = game.getGameBall();
        double speedIncrease = 0.01;

        if (ball.getPosY() <= 50 || ball.getPosY() >= game.getDimensionY() - 50) {
            System.out.println("Previous speed: dx=" + ball.getDx() + ", dy=" + ball.getDy());

            if (ball.getDx() >= 0)
                ball.setDx(ball.getDx() + speedIncrease);
            else
                ball.setDx(ball.getDx() - speedIncrease);

            if (ball.getDy() >= 0)
                ball.setDy(ball.getDy() + speedIncrease);
            else
                ball.setDy(ball.getDy() - speedIncrease);

            System.out.println("New speed: dx=" + ball.getDx() + ", dy=" + ball.getDy());
        }
    }


    /**
     *
     * @param game
     * @return ball
     */
    public boolean player2Scores(Game game) {
        return game.getGameBall().getPosX()<10;
    }

    /**
     *
     * @param game
     * @return max score
     */
    public boolean checkEndOfGame(Game game)
    {
        int maxScore= Math.max(game.getPlayer1().getScore(), game.getPlayer2().getScore());
        return game.getTarget()<=maxScore;
    }


}


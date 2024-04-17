package ie.mtu.pingponggame.model;

public class Ball implements Resizable {
    private double PosX;
    private double PosY;
    private double radius;
    private double dx;
    private double dy;

    public Ball(double PosX, double PosY, double radius) {
        this.PosX = PosX;
        this.PosY = PosY;
        this.radius = radius;
        this.dx = 1; // initial speed in x direction
        this.dy = 1; // initial speed in y direction
    }

    public double getPosX() {
        return PosX;
    }

    public void setPosX(double posX) {
        PosX = posX;
    }

    public double getPosY() {
        return PosY;
    }

    public void setPosY(double posY) {
        PosY = posY;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void move() {
        PosX += dx;
        PosY += dy;
    }

    /**
     * Allows for window resizing of ball as canvas changes.
     * @param factor
     */
    @Override
    public void resizeX(double factor) {
        this.PosX *= factor;
    }

    @Override
    public void resizeY(double factor) {
        this.PosY *= factor;
    }

    /**
     *Checks if ball is located at border of canvas.
     * <p>
     *     if true then the velocity will be reversed for x and y.
     * </p>
     * @param screenWidth
     * @param screenHeight
     */
    public void checkCollision(double screenWidth, double screenHeight) {
        if (PosX <= 0 || PosX >= screenWidth - radius) {
            dx = -dx; // reverse x velocity
        }
        if (PosY <= 0 || PosY >= screenHeight - radius) {
            dy = -dy; // reverse y velocity
        }
    }
}


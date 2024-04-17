package ie.mtu.pingponggame.model;

import javafx.geometry.Pos;



public class Racket implements Resizable {
    private double PosX;
    private double PosY;
    private double topY;
    private double bottomY;
    private double Size;
    private double Thickness;



    public Racket(double PosX, double PosY, double Size, double Thickness){
        this.PosX=PosX;
        this.PosY=PosY;
        this.Size=Size;
        this.Thickness=Thickness;
    }

    public double getTopY() {
        return topY;
    }

    public void setTopY(double topY) {
        this.topY = topY;
    }

    public double getBottomY() {
        return bottomY;
    }

    public void setBottomY(double bottomY) {
        this.bottomY = bottomY;
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

    public double getSize() {
        return Size;
    }

    public void setSize(double size) {
        Size = size;
    }

    public double getThickness() {
        return Thickness;
    }

    public void setThickness(double thickness) {
        Thickness = thickness;
    }


    /**
     * Allows for window resizing of racket as canvas changes.
     * @param factor
     */
    @Override
    public void resizeX(double factor){
        this.PosX *= factor;
    }

    @Override
    public void resizeY(double factor){
        this.PosY *= factor;
    }

    public void moveUp() {
        PosY += 3;
    }

    public void moveDown(){
        PosY -= 3;
    }
}

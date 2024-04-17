package ie.mtu.pingponggame.model;

public class Player {
    private String Name;
    private int Score;
    private double DimensionX;
    private double DimensionY;
    private double NameX;
    private double NameY;
    private Racket racket;

    public Player() {
    }

    public Player(String Name){
        this.Name=Name;
        this.Score=0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
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

    public double getNameX() {
        return NameX;
    }

    public void setNameX(double nameX) {
        NameX = nameX;
    }

    public double getNameY() {
        return NameY;
    }

    public void setNameY(double nameY) {
        NameY = nameY;
    }

    public Racket getRacket(){return racket;}

    public void setRacket(Racket racket){this.racket = racket;}
}

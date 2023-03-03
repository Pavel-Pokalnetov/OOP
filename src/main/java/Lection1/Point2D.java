package Lection1;

public class Point2D {
    private int x;
    private int y;

    public Point2D() {
        x=0;
        y=0;
    }

    @Override
    public String toString() {
        return String.format("(%d;%d)",this.x,this.y);
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double distance(int x,int y){
        return Math.sqrt(Math.pow(x-this.x,2)+Math.pow(y-this.y,2));
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


public class Vector2D {

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if(x < 0) {
            throw new IllegalArgumentException("Can't set negative value");
        }

        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if(y < 0) {
            throw new IllegalArgumentException("Can't set negative value");
        }

        this.y = y;
    }

    public double length() {
        return Math.sqrt(x*x + y*y);
    }
}

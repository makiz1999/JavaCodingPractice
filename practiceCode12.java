public class Point {
    private int x;
    private int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
    public double distance(){
        int newX = 0;
        int newY = 0;
        return Math.sqrt((newX - x)*(newX - x)+(newY - y)*(newY - y));
    }
    public double distance(int newX, int newY){
        return Math.sqrt((newX - x)*(newX - x)+(newY - y)*(newY - y));
    }
    public double distance( Point point ){
        return Math.sqrt((point.x - x)*(point.x - x)+(point.y - y)*(point.y - y));
    }
}

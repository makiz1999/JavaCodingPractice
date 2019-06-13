public class Rectangle {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        if (width < 0){
            this.width = 0;
        } else {
            this.width = width;
        }
        if (length < 0){
            this.length = 0;
        } else {
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
    public double getArea() {
        return width*length;
    }
}

public class Cuboid extends Rectangle {
    private double height;

    public Cuboid(double width, double length, double height) {
        super(width, length);
        if (height < 0){
            this.height = 0;
        } else {
            this.height = height;
        }
    }

    public double getHeight() {
        return height;
    }
    public double getVolume() {
        return super.getArea() * height;
    }
}

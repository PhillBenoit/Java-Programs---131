
public class Rectangle {
    public double width, height;
    
    public Rectangle() {
        height = 1;
        width = 1;
    }
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getArea() {
        return width*height;
    }
    
    public double getPerimeter() {
        return (2*width)+(2*height);
    }

}

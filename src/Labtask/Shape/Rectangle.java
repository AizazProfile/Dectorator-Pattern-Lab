package Labtask.Shape;
public class Rectangle implements Shape {
    private double cost;

    public Rectangle(double cost) {
        this.cost = cost;
    }

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }

    @Override
    public double getCost() {
        return cost;
    }
}




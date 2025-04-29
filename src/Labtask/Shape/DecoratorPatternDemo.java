package Labtask.Shape;


    public class DecoratorPatternDemo {
        public static void main(String[] args) {
            Shape circle = new Circle(5.0);
            Shape rectangle = new Rectangle(10.0);

            Shape redCircle = new RedShapeDecorator(new Circle(5.0), 2.0);
            Shape redRectangle = new RedShapeDecorator(new Rectangle(10.0), 3.0);

            System.out.println("Circle with normal border");
            circle.draw();
            System.out.println("Cost: " + circle.getCost());

            System.out.println("\nCircle with red border");
            redCircle.draw();

            System.out.println("\nRectangle with red border");
            redRectangle.draw();
        }
    }


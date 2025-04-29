package Labtask.Shape;


    public class Circle implements Shape {
        private double cost;

        public Circle(double cost) {
            this.cost = cost;
        }

        @Override
        public void draw() {
            System.out.println("Shape: Circle");
        }

        @Override
        public double getCost() {
            return cost;
        }
    }


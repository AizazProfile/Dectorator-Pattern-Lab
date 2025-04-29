package Labtask.Shape;


    public class RedShapeDecorator extends ShapeDecorator {
        private double decorationCost;

        public RedShapeDecorator(Shape decoratedShape, double decorationCost) {
            super(decoratedShape);
            this.decorationCost = decorationCost;
        }

        @Override
        public void draw() {
            decoratedShape.draw();
            setRedBorder();
            System.out.println("Total Cost: " + getCost());
        }

        private void setRedBorder(){
            System.out.println("Border Color: Red");
        }

        @Override
        public double getCost() {
            return super.getCost() + decorationCost;
        }
    }


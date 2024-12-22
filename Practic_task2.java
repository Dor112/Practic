package org.example;
public class Main {
    public static void main(String[] args) {
        try {
            Rectangle rect = new Rectangle(4, 8);
            System.out.println("Rectangle Area: " + rect.area());
            System.out.println("Rectangle Perimeter: " + rect.perimeter());

            Circle cir = new Circle(10);
            System.out.println("Circle Area: " + cir.area());
            System.out.println("Circle Perimeter: " + cir.perimeter());

            Triangle tr = new Triangle(7, 8, 9);
            System.out.println("Triangle Area: " + tr.area());
            System.out.println("Triangle Perimeter: " + tr.perimeter());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class Circle {
        private double r;

        public Circle(double r) {
            if (r <= 0) {
                throw new RuntimeException("There is no figure with such parameters.");
            }
            this.r = r;
        }

        public double area() {
            return Math.PI * r * r;
        }

        public double perimeter() {
            return 2 * Math.PI * r;
        }
    }

    public static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            if (width <= 0 || height <= 0) {
                throw new RuntimeException("There is no figure with these parameters.");
            }
            this.width = width;
            this.height = height;
        }

        public double area() {
            return width * height;
        }

        public double perimeter() {
            return 2 * (width + height);
        }
    }

    public static class Triangle {
        private double a;
        private double b;
        private double c;

        public Triangle(double a, double b, double c) {
            if (a <= 0 || b <= 0 || c <= 0 ||
                    a + b <= c || a + c <= b || b + c <= a) {
                throw new RuntimeException("There is no figure with these parameters.");
            }
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double area() {
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        public double perimeter() {
            return a + b + c;
        }
    }
}

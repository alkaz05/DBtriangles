package com.example.dbtriangles;

import javafx.beans.property.SimpleDoubleProperty;

public class OTriangle {
            SimpleDoubleProperty a,b,c;
            SimpleDoubleProperty area;
            SimpleDoubleProperty perim;

        public OTriangle(double a, double b, double c) throws Exception {

            if (a <= 0 || b <= 0 || c <= 0)
                throw new Exception("Ненатуральная длина");
            if (a+b < c || b+c < a || a+c < b)
                throw new Exception("Невозможный треугольник");

            this.a = new SimpleDoubleProperty(a);
            this.b = new SimpleDoubleProperty(b);
            this.c = new SimpleDoubleProperty(c);

            this.perim = new SimpleDoubleProperty();
            this.area = new SimpleDoubleProperty();

            update();

            this.a.addListener(x-> update());
            this.b.addListener(x-> update());
            this.c.addListener(x-> update());
        }

        private void update(){
            perim.set(calcPerim());
            area.set(calcArea());
        }

       public double calcPerim() {
            return a.get() + b.get() + c.get();
        }
       public double calcArea() {
            double p = 0.5*calcPerim(); //S= √ p ⋅ (p− a) ⋅ (p− b) ⋅ (p− c).
            double triangleSquare = Math.sqrt((p*(p- a.get())*(p- b.get())*(p- b.get())));
            return triangleSquare;
        }

        @Override
        public String toString() {
            return "myfx.newtrianglefx.OTriangle{" +
                    "a=" + a.get() +
                    ", b=" + b.get() +
                    ", c=" + c.get() +
                    '}';
        }

    public double getA() {
        return a.get();
    }

    public void setA(double a) {
        this.a.set(a);
    }

    public void setB(double b) {
        this.b.set(b);
    }

    public void setC(double c) {
        this.c.set(c);
    }

    public SimpleDoubleProperty aProperty() {
        return a;
    }

    public double getB() {
        return b.get();
    }

    public SimpleDoubleProperty bProperty() {
        return b;
    }

    public double getC() {
        return c.get();
    }

    public SimpleDoubleProperty cProperty() {
        return c;
    }

    public double getArea() {
        return area.get();
    }

    public SimpleDoubleProperty areaProperty() {
        return area;
    }

    public double getPerim() {
        return perim.get();
    }

    public SimpleDoubleProperty perimProperty() {
        return perim;
    }
}

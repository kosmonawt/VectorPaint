package VectorPaint.Controller;

import VectorPaint.shapes.Line;
import VectorPaint.shapes.Rectangle;
import VectorPaint.shapes.Shape;
import VectorPaint.shapes.Triangle;

public class ShapeFactory {
    public Shape get(String s) {
        String[] data = s.split(";");
        String shapeName = data[0].toLowerCase();

        switch (shapeName) {
            case "line":
                return getLine(data);
            case "rectangle":
                return getRectangle(data);
            case "triangle":
                return getTriangle(data);

        }

        return null;
    }

    private Shape getTriangle(String[] data) {
        double point1X = Double.parseDouble(data[1]);
        double point1Y = Double.parseDouble(data[2]);
        double point2X = Double.parseDouble(data[3]);
        double point2Y = Double.parseDouble(data[4]);
        double point3X = Double.parseDouble(data[5]);
        double point3Y = Double.parseDouble(data[6]);
        String fillColor = data[7];
        String strokeColor = data[8];

        Triangle.Builder builder = new Triangle.Builder()
                .setPoint1(point1X, point1Y)
                .setPoint2(point2X, point2Y)
                .setPoint3(point3X, point3Y)
                .setFillColor(fillColor)
                .setStrokeColor(strokeColor);
        return builder.buiid();
    }


    private Shape getRectangle(String[] data) {
        double x = Double.parseDouble(data[1]);
        double y = Double.parseDouble(data[2]);
        double w = Double.parseDouble(data[3]);
        double h = Double.parseDouble(data[4]);
        String fillColor = data[5];
        String strokeColor = data[6];
        Rectangle.Builder builderRect = new Rectangle.Builder()
                .setX(x)
                .setY(y)
                .setW(w)
                .setH(h)
                .setFillColor(fillColor)
                .setStrokeColor(strokeColor);
        return builderRect.buiid();
    }

    private Shape getLine(String[] data) {
        //Line;211.50330107117216;180.9879372396072;556.2558365768028;194.05873038737724;0x00ffffff;0x000000ff;
        double x1 = Double.parseDouble(data[1]);
        double y1 = Double.parseDouble(data[2]);
        double x2 = Double.parseDouble(data[3]);
        double y2 = Double.parseDouble(data[4]);
        String fillColor = data[5];
        String strokeColor = data[6];

        Line.Builder line = new Line.Builder()
                .setX1(x1)
                .setY1(y1)
                .setX2(x2)
                .setY2(y2)
                .setFillColor(fillColor)
                .setStrokeColor(strokeColor);
        return line.buiid();


    }
}

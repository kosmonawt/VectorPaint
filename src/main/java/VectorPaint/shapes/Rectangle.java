package VectorPaint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private double x;
    private double y;
    private double w;
    private double h;


    public Rectangle(double x1, double y1, double x2, double y2) {
        this.x = Math.min(x1, x2);
        this.y = Math.min(y1, y2);
        this.w = Math.abs(x1 - x2);
        this.h = Math.abs(y1 - y2);
    }

    private Rectangle(Builder builder) {

        this.x = builder.x;
        this.y = builder.y;
        this.w = builder.w;
        this.h = builder.h;
        setFillColor(builder.fillColor);
        setStrokeColor(builder.strokeColor);
    }

    @Override
    public String getData() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rectangle;");
        builder.append(x).append(";");
        builder.append(y).append(";");
        builder.append(w).append(";");
        builder.append(h).append(";");
        builder.append(getFillColor()).append(";");
        builder.append(getStrokeColor()).append(";");
        return builder.toString();
    }

    public void draw(GraphicsContext context) {
        context.setStroke(getStrokeColor());
        context.setFill(getFillColor());
        context.strokeRect(x, y, w, h);
        context.fillRect(x, y, w, h);

        /*context.beginPath();
        context.moveTo(x, y);
        context.lineTo(x + 20, y + 20);
        context.lineTo(x, y + 20);
        context.lineTo(x + 20, y);
        context.lineTo(x, y);

        context.stroke();
        context.fill();
        context.closePath();*/
    }

    public static class Builder {
        public Rectangle buiid() {
            return new Rectangle(this);
        }

        double x;
        double y;
        double w;
        double h;
        Color fillColor = Color.RED;
        Color strokeColor = Color.AQUA;

        public Builder setX(double x) {
            this.x = x;
            return this;
        }

        public Builder setY(double y) {
            this.y = y;
            return this;
        }

        public Builder setW(double w) {
            this.w = w;
            return this;
        }

        public Rectangle.Builder setH(double h) {
            this.h = h;
            return this;
        }

        public Builder setFillColor(String fillColor) {
            this.fillColor = Color.valueOf(fillColor);
            return this;
        }

        public Builder setStrokeColor(String strokeColor) {
            this.strokeColor = Color.valueOf(strokeColor);
            return this;
        }
    }
}

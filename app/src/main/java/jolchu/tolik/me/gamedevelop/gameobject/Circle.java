package jolchu.tolik.me.gamedevelop.gameobject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import jolchu.tolik.me.gamedevelop.GameDisplay;

public abstract class Circle extends GameObject {
    protected double radius;
    protected Paint paint;

    public Circle(Context context, int color, double positionX, double positionY, double radius) {
        super(positionX, positionY);
        this.radius = radius;

        paint = new Paint();
        paint.setColor(color);
    }

    public static boolean isColliding(Circle obj1, Circle obj2) {
        double distance = getDistanceBetweenObjects(obj1, obj2);
        double distanceToCollision = obj1.getRadius() + obj2.getRadius();
        if (distance < distanceToCollision)
            return true;
        else
            return false;
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        canvas.drawCircle(
                (float) gameDisplay.gameToDisplayCoordinatesX(positionX),
                (float) gameDisplay.gameToDisplayCoordinatesY(positionY),
                (float) radius,
                paint
        );
    }

    public double getRadius() {
        return radius;
    }

}
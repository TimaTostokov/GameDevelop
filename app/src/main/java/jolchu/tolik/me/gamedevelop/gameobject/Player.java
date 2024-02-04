package jolchu.tolik.me.gamedevelop.gameobject;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import jolchu.tolik.me.gamedevelop.GameDisplay;
import jolchu.tolik.me.gamedevelop.GameLoop;
import jolchu.tolik.me.gamedevelop.R;
import jolchu.tolik.me.gamedevelop.Utils;
import jolchu.tolik.me.gamedevelop.gamepanel.HealthBar;
import jolchu.tolik.me.gamedevelop.gamepanel.Joystick;

public class Player extends Circle {
    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    public static final int MAX_HEALTH_POINTS = 5;
    private final Joystick joystick;
    private final HealthBar healthBar;
    private int healthPoints = MAX_HEALTH_POINTS;
    private final Animator animator;
    private final PlayerState playerState;

    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius, Animator animator) {
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;
        this.healthBar = new HealthBar(context, this);
        this.animator = animator;
        this.playerState = new PlayerState(this);
    }

    public void update() {
        velocityX = joystick.getActuatorX() * MAX_SPEED;
        velocityY = joystick.getActuatorY() * MAX_SPEED;

        positionX += velocityX;
        positionY += velocityY;

        if (velocityX != 0 || velocityY != 0) {
            double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
            directionX = velocityX / distance;
            directionY = velocityY / distance;
        }
        playerState.update();
    }

    public void draw(Canvas canvas, GameDisplay gameDisplay) {
        animator.end();
        healthBar.draw(canvas, gameDisplay);
    }

    public int getHealthPoint() {
        return healthPoints;
    }

    public void setHealthPoint(int healthPoints) {
        if (healthPoints >= 0)
            this.healthPoints = healthPoints;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

}
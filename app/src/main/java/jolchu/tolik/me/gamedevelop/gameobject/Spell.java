package jolchu.tolik.me.gamedevelop.gameobject;

import android.content.Context;

import androidx.core.content.ContextCompat;

import jolchu.tolik.me.gamedevelop.GameLoop;
import jolchu.tolik.me.gamedevelop.R;

public class Spell extends Circle {
    public static final double SPEED_PIXELS_PER_SECOND = 800.0;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    public Spell(Context context, Player spellCaster) {
        super(
                context,
                ContextCompat.getColor(context, R.color.spell),
                spellCaster.getPositionX(),
                spellCaster.getPositionY(),
                25
        );
        velocityX = spellCaster.getDirectionX() * MAX_SPEED;
        velocityY = spellCaster.getDirectionY() * MAX_SPEED;
    }

    @Override
    public void update() {
        positionX = positionX + velocityX;
        positionY = positionY + velocityY;
    }

}
package jolchu.tolik.me.gamedevelop.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import jolchu.tolik.me.gamedevelop.graphics.Sprite;
import jolchu.tolik.me.gamedevelop.graphics.SpriteSheet;

class LavaTile extends Tile {
    private final Sprite sprite;

    public LavaTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getLavaSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }

}
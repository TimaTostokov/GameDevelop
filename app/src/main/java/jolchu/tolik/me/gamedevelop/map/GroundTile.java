package jolchu.tolik.me.gamedevelop.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import jolchu.tolik.me.gamedevelop.graphics.Sprite;
import jolchu.tolik.me.gamedevelop.graphics.SpriteSheet;

class GroundTile extends Tile {
    private final Sprite sprite;

    public GroundTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getGroundSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }

}
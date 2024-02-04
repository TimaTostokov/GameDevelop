package jolchu.tolik.me.gamedevelop.map;

import android.graphics.Canvas;
import android.graphics.Rect;

import jolchu.tolik.me.gamedevelop.graphics.Sprite;
import jolchu.tolik.me.gamedevelop.graphics.SpriteSheet;

class WaterTile extends Tile {
    private final Sprite sprite;

    public WaterTile(SpriteSheet spriteSheet, Rect mapLocationRect) {
        super(mapLocationRect);
        sprite = spriteSheet.getWaterSprite();
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, mapLocationRect.left, mapLocationRect.top);
    }

}
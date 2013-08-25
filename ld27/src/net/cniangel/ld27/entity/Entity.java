package net.cniangel.ld27.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface Entity {

	Vector2 position = new Vector2(), nextPosition = new Vector2();
	Rectangle bounds = new Rectangle();
	float width = 0, height = 0;
	Sprite sprt = new Sprite();
	
	public void setX(float newX);
	public void setY(float newY);
	public void setWidth(float newWidth);
	public void setHeight(float newHeight);
	public void setSprite();
	public void setBounds(float x, float y, float width, float height);
	public void setPosition(float x, float y);
	public Vector2 getPosition();
	public float getX();
	public float getY();
	public float getWidth();
	public float getHeight();
	public Rectangle getBounds();
}

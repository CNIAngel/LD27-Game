package net.cniangel.ld27.entity;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Waypoint implements Entity {

	Vector2 position = new Vector2();
	Animation active,waiting;
	Rectangle bounds;
	float statetime, aniSpeed;
	
	
	public Waypoint(float x, float y) {
		
	}
	
	@Override
	public void setX(float newX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(float newY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWidth(float newWidth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(float newHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSprite() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBounds(float x, float y, float width, float height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector2 getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}

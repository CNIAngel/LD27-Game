package net.cniangel.ld27.entity;

import net.cniangel.ld27.Art;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Tile {

	Vector2 position = new Vector2();
	int width = 32, height = 32;
	
	public Tile(float x, float y) {
		this.position.x = x; this.position.y = y;
		
	}
	
	public void render(SpriteBatch b) {
		
	}
	
}

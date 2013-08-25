package net.cniangel.ld27.entity;


import net.cniangel.ld27.Input;
import net.cniangel.ld27.LDGame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

	// Declare Player constants
	Vector2 position, currentPosition;
	float speed, gravity;
	Rectangle bounds;
	boolean isJumping, isDead, isFalling;
	Animation idle, run, jump, fall;
	float x, y, width, height;
	float statetime, aniSpeed;
	LDGame game;
	TiledMapTileLayer collisionLayer;
	
	
	// Just using a Sprite for the moment
	Sprite sprt;
	
	public Player(LDGame game, float startX, float startY, TiledMapTileLayer layer) {
		this.game = game;
		this.x = startX;
		this.y = startY;
		this.collisionLayer = layer;
		
		// Initalize everything or you'll encounter NullPointerException errors
		position = new Vector2(); currentPosition = new Vector2();
		bounds = new Rectangle();
		isDead = false;
		sprt = new Sprite();
		speed = 60 * 2; gravity = 20f;
		
		// Set up player needs
		position.set(x, y); currentPosition.set(position);
		setBounds(x, y, width, height);
	}
	
	public void render(SpriteBatch b) {
		sprt.draw(b);
	}
	
	public void update(float delta) {
		// Booleans to check for button presses
		boolean leftPressed = game.input.buttons[Input.LEFT];
		boolean rightPressed = game.input.buttons[Input.RIGHT];
		boolean upPressed = game.input.buttons[Input.UP];
		boolean collisionX = false, collisionY = false;
		float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
		isJumping = false;isFalling = false; 
		/**
		 * Collision code modified from Dermatfan's TiledMap tutorial 
		 * @link https://bitbucket.org/dermetfan/tiledmapgame/src/f0b9dd832ac984685f4b83e74b2aace3aa87009d/src/net/dermetfan/tiledMapGame/entities/Player.java?at=default
		 */
		if (!isDead) {
			// Movement code - Left and Right
			currentPosition.sub(0, gravity * delta);
			currentPosition.sub(0, gravity * delta);
			
			if (leftPressed == true && rightPressed != true) {
				currentPosition.sub(speed * delta * 3, 0);
				
				if (currentPosition.x < 0)
						collisionX = true;
				
				if (!collisionX)
					collisionX = isCellBlocked(collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + bounds.getHeight()) / tileHeight)));
				if (!collisionX)
					collisionX = isCellBlocked(collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + bounds.getHeight() / 2) / tileHeight)));
				
				if (!collisionX)
					collisionX = isCellBlocked(collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / tileHeight)));
				
				
			} else if (rightPressed == true && leftPressed != true) {
				currentPosition.add(speed * delta * 3, 0);
				
				if (!collisionX)
					collisionX = isCellBlocked(collisionLayer.getCell((int) ((getX() + bounds.getWidth()) / tileWidth), (int) ((getY() + bounds.getHeight()) / tileHeight)));
				if (!collisionX)
					collisionX = isCellBlocked(collisionLayer.getCell((int) ((getX() + bounds.getWidth()) / tileWidth), (int) ((getY() + bounds.getHeight() / 2) / tileHeight)));
				
				if (!collisionX)
					collisionX = isCellBlocked(collisionLayer.getCell((int) ((getX() + bounds.getWidth()) / tileWidth), (int) (getY() / tileHeight)));
			}
			
			// Movement code - Jump
			if (upPressed == true && isJumping == false && isFalling == false) {
				currentPosition.add(0, speed  * delta * 3);
				
				if (currentPosition.y > game.h)
					collisionY = true;
				
				isJumping = true;
				isFalling = true;
				
				if (!collisionY)
					collisionY = isCellBlocked(collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + bounds.getHeight()) / tileHeight)));
				if (!collisionY)
					collisionY = isCellBlocked(collisionLayer.getCell((int) ((getX() + bounds.getWidth() / 2) / tileWidth), (int) ((getY() + bounds.getHeight()) / tileHeight)));
				if (!collisionY)
					collisionY = isCellBlocked(collisionLayer.getCell((int) ((getX() + bounds.getWidth()) / tileWidth), (int) ((getY() + bounds.getHeight()) / tileHeight)));
			} else {
				
				if (currentPosition.y > game.h)
					collisionY = true;
				
				if (!collisionY)
					collisionY = isCellBlocked(collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / tileHeight)));
				if (!collisionY)
					collisionY = isCellBlocked(collisionLayer.getCell((int) ((getX() + bounds.getWidth() / 2) / tileWidth), (int) (getY() / tileHeight)));
				if (!collisionY)
					collisionY = isCellBlocked(collisionLayer.getCell((int) ((getX() + bounds.getWidth()) / tileWidth), (int) (getY() / tileHeight)));
			}
			
			
			// Collision code
			
			if (collisionX != true && collisionY != true) {
				position.set(currentPosition); bounds.setX(currentPosition.x); bounds.setY(currentPosition.y);
			} else {
				currentPosition.set(position);
			}
			
			
			sprt.setX(position.x);sprt.setY(position.y);
		}
	}
	
	/** Getters & Setters **/
	public void setX(float x) {position.set(x, 0);}
	public void setY(float y) {position.set(0, y);}
	public void setWidth(float newWidth) {width = newWidth;}
	public void setHeight(float newHeight) {height = newHeight;}
	public void setPosition(float x, float y) { position.set(x, y); }
	public void setBounds(float x, float y, float width, float height) { bounds.set(x, y, width, height); }
	public void setDead(boolean state) { if (state != false) isDead = true; else { isDead = false; }}
	public float getX() { return this.position.x; }
	public float getY() { return this.position.y; }
	public Rectangle getBounds() { return new Rectangle(currentPosition.x, currentPosition.y, width, height); }
	public boolean isDead() { return isDead; }
	private boolean isCellBlocked(Cell cell) {
        return cell.getTile() != null && cell.getTile().getProperties().containsKey("blocked");
}
}

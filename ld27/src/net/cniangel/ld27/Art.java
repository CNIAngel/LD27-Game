package net.cniangel.ld27;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Art {
	
	
	public static TextureRegion[][] alphabet, tile, player, spike, way;
	public static String alpha = "ABCDEFGH"+"IJKLMNOP"+"QRSTUVWX"+"YZ.: 123"+"4567890-";
	public static Texture sky;
	
	public static void loadAll() {

		// Load textures
		sky = loadTexture("sky.png");
		
		// Load texture regions
		alphabet = loadTexture("alpha.png", 16, 16);
		tile = loadTexture("tile.png", 16, 16);
		player = loadTexture("player.png", 16, 16);
		spike = loadTexture("spike.png", 16, 16);
		way = loadTexture("waypoint.png", 16, 16);
	}
	
	/**
	 * Method loadTexture
	 * Loads a full texture like a background screen or a single sprite by
	 * providing a path in the art folder.
	 * Example: testTex = loadTexture("test.png");
	 * @param path
	 * @return texS
	 */
	public static Texture loadTexture(String path){
		return new Texture(Gdx.files.internal("data/art/"+path));
	}
	
	/**
	 * Method loadTexture
	 * Loads a full spritesheet for use of tile map rendering and animation.
	 * Prove a path in the art folder, the width of the singular tile, and the 
	 * height of the singular tile.
	 * Example: testTex[][] = loadTexture("test.png", 32, 32);
	 * @param path
	 * @param w
	 * @param h
	 * @return
	 */
	public static TextureRegion[][] loadTexture(String path, int w, int h) {
		Texture tex = new Texture(Gdx.files.internal("data/art/"+path));
		
		int xSlice = tex.getWidth() / w;
		int ySlice = tex.getHeight() / h;
		
		TextureRegion[][] result = new TextureRegion[xSlice][ySlice];
		
		for (int x = 0; x < xSlice; x++) {
			for (int y = 0; y <ySlice; y++) {
				result[x][y] = new TextureRegion(tex, x*w, y*h, w, h);
				result[x][y].flip(false, false);
			}
		}
		return result;
	}
	
	public static void drawFont(String msg, SpriteBatch b, float x, float y) {
		msg=msg.toUpperCase();	
		for(int i=0;i<msg.length();i++){
		int letter=alpha.indexOf(msg.charAt(i));
		int xx=letter%8;
		int yy=letter/8;
		b.draw(alphabet[xx][yy], x+i*16, y);
		}
	}
	
	public static Animation loadAnimation(TextureRegion[][] sheet, int columns, int rows, float animationSpeed, boolean flip, int startRow) {
		
		Animation newAni;
		float tmpSpeed;
		int col = columns, row = rows;
		TextureRegion[] tmp = new TextureRegion[col * row];
		int index = 0;
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				tmp[index++] = sheet[i][j + startRow];
			}
		}
		
		for (int k = 0; k < tmp.length; k++) tmp[k].flip(flip, false);
		
		tmpSpeed = animationSpeed;
		
		newAni = new Animation(tmpSpeed, tmp);
		
		return newAni;
	}
	
}

package net.cniangel.ld27.game;

import java.util.ArrayList;

import net.cniangel.ld27.Art;
import net.cniangel.ld27.Input;
import net.cniangel.ld27.LDGame;
import net.cniangel.ld27.entity.Player;
import net.cniangel.ld27.entity.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class PlayScreen implements Screen {

	// Constants for the screen, carried over from the game.
	LDGame game;
	SpriteBatch batch;
	OrthographicCamera cam;
	Input input;
	int timerCounter, timerValue = 10;
	float saveX, saveY;
	
	ArrayList<Tile> tiles = new ArrayList<Tile>();
	TiledMap map;
	public TiledMapTileLayer layer;
	OrthogonalTiledMapRenderer renderer;
	float unitScale = 1/32f;
	
	Player p;
	
	public PlayScreen(LDGame game) {
		this.game = game;
		this.batch = game.batch;
		this.input = game.input;
		this.cam = game.cam;
		
		loadMap(0);
		
		//p = new Player(game, 128, 128, layer);
		saveX = 128; saveY = 92;
		
		
		
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// Timer shit
		timerCounter++;
		if (timerCounter >= 60) {
			if (timerValue != 0) {
				timerValue--;
				timerCounter = 0;
			}
		}
		
		// Render
		renderer.setView(cam);
		renderer.render();
		batch.begin();
		//p.render(batch);
		Art.drawFont(Integer.toString(timerValue), batch, game.w / 2 - 16, game.h - 32);
		//Art.drawFont("X:"+Float.toString(p.getX()), batch, 0, game.h - 32);
		//Art.drawFont("Y:"+Float.toString(p.getY()), batch, 0, game.h - 64);
		batch.end();
		cam.update();
		
		// Logic
		//p.update(delta);
		
		
		
		if (timerValue == 0) {
			p.setDead(true);
			if (Gdx.input.isKeyPressed(Keys.R)) {
				timerValue = 10;
				p = new Player(game, saveX, saveY, layer);
			}
		}
		
		
		
	}
	
	private void loadMap(int mapNumber) {
		tiles.clear();
		map = new TmxMapLoader().load("data/levels/level"+mapNumber+".tmx");
		layer = (TiledMapTileLayer)map.getLayers().get("Tile Layer 1");
		
		int rows = 10;
		int columns = 60;
		int rectCounter =0;
		
		 for (int y = 0; y < rows; y++) {
				for (int x = 0; x < columns; x++) {
					Cell cell = layer.getCell(x, y);
					if(cell != null && cell.getTile().getProperties().containsKey("isBlocked")) {
						tiles.add(new Tile(x * 32, y * 32));
						rectCounter++;
					}
				}
			}
		
		 System.out.println("Number of collision rectangles: "+rectCounter);
		renderer = new OrthogonalTiledMapRenderer(map, unitScale);
		cam.setToOrtho(false, 15, 10);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void setSavepoint(float x, float y) {
		saveX = x;
		saveY = y;
	}

}

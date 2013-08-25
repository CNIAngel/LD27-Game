package net.cniangel.ld27;

import net.cniangel.ld27.game.PlayScreen;
import net.cniangel.ld27.game.WorldScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LDGame extends Game {

	public OrthographicCamera cam;
	public SpriteBatch batch;
	public FPSLogger log;
	public Input input;
	public float w;
	public float h;
	public String VERSION = "v0.1";
	
	
	// Screens
	public PlayScreen play;
	public WorldScreen worldTest;
	
	@Override
	public void create() {	
		Texture.setEnforcePotImages(false);
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		log = new FPSLogger();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, w/2, h/2);
		batch = new SpriteBatch();
		
		System.out.println("Current Version: "+VERSION);
		
		// Load art, set up inputProcessor, and set screen
		Art.loadAll();
		input = new Input();
		Gdx.input.setInputProcessor(input);
		if (play == null) play = new PlayScreen(this);
		setScreen(play);
		
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
		log.log();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}

package net.cniangel.ld27;

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
	public float w;
	public float h;
	
	@Override
	public void create() {	
		Texture.setEnforcePotImages(false);
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		cam = new OrthographicCamera();
		batch = new SpriteBatch();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
		//log.log();
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

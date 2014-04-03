package com.dbgt.dontletyourballdrop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class DontLetYourBallDrop implements ApplicationListener {
	
	private SpriteBatch spriteBatch;
	private BitmapFont font;
	private OrthographicCamera camera;
	private TextureRegion textureRegion;
	
	private Vector2 position, touchPosition, acceleration, vi, vf;
	private float moveSpeed, delta;
	
	//Pos = 0.5 * a * (delta^2)
	//Vel = a * delta
	//F = ma
	//accavg = avgvel / delta
	//avgvel = lastpos / delta
	
	//a = 9.8;
	
	@Override
	public void create() {		
		
		spriteBatch = new SpriteBatch();
		font = new BitmapFont(true);
		camera = new OrthographicCamera();

		textureRegion = new TextureRegion(new Texture(Gdx.files.internal("data/soccerball.png")));
		textureRegion.flip(false, true);
	
		position = new Vector2(0,0);
		touchPosition = new Vector2(0, 0);
		moveSpeed = 1000.0f;
		acceleration = new Vector2(0.0f, 9.8f);
		vi = new Vector2(0.0f, 0.0f);
		vf = new Vector2(0.0f, 0.0f);
		
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void dispose() {
		
		spriteBatch.dispose();
		font.dispose();
		textureRegion.getTexture().dispose();
	}

	@Override
	public void render() {		
		
		delta = Gdx.graphics.getDeltaTime();
		
//		if(touchPosition.x > position.x) {
//			position.x += moveSpeed * delta;
//		} else if(touchPosition.x < position.x) {
//			position.x -= moveSpeed * delta;
//		}
//		
//		if(touchPosition.y > position.y) {
//			position.y += moveSpeed * delta;
//		} else if(touchPosition.y < position.y) {
//			position.y -= moveSpeed * delta;
//		}
		
		if(Gdx.input.justTouched()) {
			touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
			position.y -= moveSpeed * 2 * delta;
		}
		
		//Double buffering to clear screen (Stop Flicking)
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//(0,0) is now top left
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
		
		vf.x = vi.x + acceleration.x * delta;
		vf.y = vi.y + acceleration.y * delta;
		
		position.y += (vi.y + vf.y) / 2 * delta;
		position.x += (vi.x + vf.x) / 2 * delta;
		
		vi = vf;
		
		//Start the drawing
		spriteBatch.begin();
		spriteBatch.draw(textureRegion, position.x, position.y);
		//font.draw(spriteBatch, "Coding!", 20.0f, 20.0f);
		//spriteBatch.draw(textureRegion, 0, 0);
		//font.draw(spriteBatch, String.valueOf(position.dst(position2)), 0, 0);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(true, width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}

package com.dbgt.dontletyourballdrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractScreen implements Screen {
	
	 protected final DontLetYourBallDrop game;
	 protected final BitmapFont font;
	 protected final SpriteBatch batch;
	 protected final OrthographicCamera camera;
	 
	 public AbstractScreen(DontLetYourBallDrop game) {
		 this.game = game;
		 this.font = new BitmapFont(true);
		 this.batch = new SpriteBatch();
		 this.camera = new OrthographicCamera();
		 
		 camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	 }
	 
	 @Override
	 public void show()
	 {
	 }

	 @Override
	 public void resize(int width,int height)
	 {
	 }
	 
	 public void render(float delta)
	 {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
	     // the following code clears the screen with the given RGB color (black)
	     Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	 }
	 
	 @Override
	 public void hide()
	 {
	 }

	 @Override
	 public void pause()
	 {
	 }

	 @Override
	 public void resume()
	 {
	 }

	 @Override
	 public void dispose()
	 {
		 font.dispose();
	     batch.dispose();
	 }

}

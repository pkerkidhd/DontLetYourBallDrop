package com.dbgt.dontletyourballdrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class ReadyScreen extends AbstractScreen {

	private DontLetYourBallDrop myGame;

	public ReadyScreen(DontLetYourBallDrop game) {
		super(game);
		myGame = game;
	}
	
	@Override
	public void show()
	{
		super.show();
	}
	 
	@Override
	public void render(float delta) {
		super.render(delta);
		batch.begin();
		font.draw(batch, "ReadyScreen!", 20.0f, 20.0f);
		batch.end();
		
		if(Gdx.input.justTouched()) {
			myGame.setScreen(new GameScreen(myGame));
		}
	}
	 
	@Override
	public void dispose()
	{
		super.dispose();
	}


}

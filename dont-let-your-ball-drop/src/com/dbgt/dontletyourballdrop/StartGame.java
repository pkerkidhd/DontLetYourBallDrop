package com.dbgt.dontletyourballdrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class StartGame extends AbstractScreen {

	private DontLetYourBallDrop myGame;

	public StartGame(DontLetYourBallDrop game) {
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
		font.draw(batch, "StartGameScreen!", 20.0f, 20.0f);
		batch.end();
		
		if(Gdx.input.justTouched()) {
			myGame.setScreen(new ReadyScreen(myGame));
		}
	}
	 
	@Override
	public void dispose()
	{
		super.dispose();
	}

}

package com.dbgt.dontletyourballdrop;

import com.badlogic.gdx.Gdx;

public class MainMenuScreen extends AbstractScreen {
	
	private DontLetYourBallDrop myGame;

	public MainMenuScreen(DontLetYourBallDrop game) {
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
		font.draw(batch, "MainMenu!", 20.0f, 20.0f);
		batch.end();
		
		if(Gdx.input.justTouched()) {
			myGame.setScreen(new StartGame(myGame));
		}
	}
	 
	@Override
	public void dispose()
	{
		super.dispose();
	}

}

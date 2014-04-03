package com.dbgt.dontletyourballdrop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

public class DontLetYourBallDrop extends Game {
	
	private FPSLogger fpsLogger;
	
	public SplashScreen getSplashScreen() {
		return new SplashScreen(this);
	}
	
	@Override
	public void create() {
        Gdx.app.log("Creating game", "test" );
        fpsLogger = new FPSLogger();
        setScreen(getSplashScreen());
	}
	
	@Override
	public void render()
	{
		super.render();
	 
	    // output the current FPS
	    fpsLogger.log();
	}
}

package com.dbgt.dontletyourballdrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Ball {

	public Vector2 position, gravity, vi, vf, netForce;
	public float mass;
	public TextureRegion ballRegion;
	
	public Ball(float _x, float _y) {
		position = new Vector2(_x, _y);
		ballRegion = new TextureRegion(new Texture(Gdx.files.internal("data/soccerball.png")));
		ballRegion.flip(false, true);
		
		position = new Vector2(0,0);
		gravity = new Vector2(0.0f, 9.8f);
		netForce = new Vector2(0.0f, 0.0f);
		vi = new Vector2(0.0f, 0.0f);
		vf = new Vector2(0.0f, 0.0f);
		
		mass = 100.0f;
	}
	
}

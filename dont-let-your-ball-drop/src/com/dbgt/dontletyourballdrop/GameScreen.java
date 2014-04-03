package com.dbgt.dontletyourballdrop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends AbstractScreen {

	private float moveSpeed;
	private Vector2 touchPosition;
	private Ball ball;
	
	public GameScreen(DontLetYourBallDrop game) {
		super(game);
		ball = new Ball(50.0f, 50.f);
		moveSpeed = 2.0f;
		touchPosition = new Vector2(0.0f,0.0f);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		if(Gdx.input.justTouched()) {
			touchPosition.set(Gdx.input.getX(), Gdx.input.getY());
			//Negate gravity and add an acceleration upwards
			if(ball.netForce.y > 0)
				ball.netForce.y -= (ball.netForce.y * moveSpeed);
		}
		
		ball.netForce.y += ball.mass * ball.gravity.y;
		ball.position.x += ball.vi.x * delta + (0.5) * ball.netForce.x * delta * delta;
		ball.position.y += ball.vi.y * delta + (0.5) * ball.netForce.y * delta * delta;
		ball.vi = ball.vf;
		
		System.out.println(ball.position.x +","+ ball.position.y);
		
		batch.begin();
		font.draw(batch, "GameScreen!", 20.0f, 20.0f);
		batch.draw(ball.ballRegion, ball.position.x, ball.position.y);
		batch.end();
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

}

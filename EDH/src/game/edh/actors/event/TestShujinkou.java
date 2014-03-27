package game.edh.actors.event;

import game.edh.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class TestShujinkou extends Actor {
	public static final int RIGHT = 0;
	public static final int LEFT = 1;

	public static final int ARUKU = 0;
	public static final int MIOROSU = 1;

	int direction;
	int sprite = -1;
	boolean move = false;

	boolean flip;

	Sprite main;

	Sprite aruku;
	Sprite miorosu;

	float scale;
	final float DEFAULT_SCALE = 0.65f;

	float stateTime = 0;
	final float animTime = 1.7f;

	public TestShujinkou(float scale, int sprite, int direction) {
		// TODO 自動生成されたコンストラクター・スタブ
		aruku = Assets.event.getSprite("s_aruku");
		miorosu = Assets.event.getSprite("s_miorosu");

		this.scale = scale * DEFAULT_SCALE;

		setBounds(0, 0, 1.6f, 2.2f);
		setOrigin(getWidth() / 2, getHeight() / 2);
		Gdx.app.log("Shujinkou", getOriginX() + "," + getOriginY());

		this.direction = direction;
		checkFlip();

		changeSprite(sprite);
	}

	public void changeSprite(int sprite) {
		switch (sprite) {
		case ARUKU:
			main = aruku;
			this.sprite = ARUKU;
			setSize(main.getRegionWidth() * scale, main.getRegionHeight()
					* scale);
			Gdx.app.log("Shujinkou", "" + getWidth() + " * " + getHeight()
					+ scale);

			break;

		case MIOROSU:
			main = miorosu;
			this.sprite = MIOROSU;
			setSize(main.getRegionWidth() * scale, main.getRegionHeight()
					* scale);
			break;
		}
	}

	private void checkFlip() {
		if (direction == LEFT)
			flip = true;

		else
			flip = false;
	}

	private void moveLeft() {
		checkFlip();
		addAction(sequence(fadeOut(0.7f), moveBy(-4.0f, 0, 0.2f), fadeIn(0.7f)));
	}

	private void moveRight() {
		checkFlip();
		addAction(sequence(fadeOut(0.7f), moveBy(4.0f, 0, 0.2f), fadeIn(0.7f)));
	}

	private void move() {
		if (direction == LEFT)
			moveLeft();
		if (direction == RIGHT)
			moveRight();
	}

	public void startMove(int direction) {
		this.direction = direction;
		this.move = true;
	}

	public void stopMove() {
		this.move = false;
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		stateTime += delta;
		if (stateTime >= animTime) {
			if (move)
				move();
			stateTime = 0;
		}
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		if (main.isFlipX() != flip)
			main.flip(true, false);
		// main.setScale(getScaleX(), getScaleY());
		main.setBounds(getX(), getY(), getWidth(), getHeight());
		main.setOrigin(getOriginX(), getOriginY());
		main.setColor(getColor());
		main.draw(batch);
		super.draw(batch, parentAlpha);
	}
}

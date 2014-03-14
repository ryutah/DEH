package game.edh.frame;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import game.edh.Assets;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Yuujin extends Actor {
	public static final int RIGHT = 0;
	public static final int LEFT = 1;

	int direction;

	public static final int YOKOMUKI = 0;

	int sprite = -1;
	boolean flip;
	boolean move = false;

	Sprite main;
	Sprite yokomuki;

	float stateTime = 0;
	final float animTime = 1.7f;

	float scale = (10.8f / 432) * 0.83f;

	public Yuujin(int sprite, int direction) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.direction = direction;
		yokomuki = Assets.event.getSprite("y_yokomuki");

		setBounds(0, 0, 1.2f, 2.2f);
		setOrigin(getWidth() / 2, getHeight() / 2);

		this.direction = direction;
		checkFlip();

		changeSprite(sprite);
	}

	public void changeSprite(int sprite) {
		switch (sprite) {
		case YOKOMUKI:
			main = yokomuki;
			setSize(main.getRegionWidth() * scale, main.getRegionHeight()
					* scale);
			this.sprite = YOKOMUKI;
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
		// main.setScale(this.scale);
		main.setBounds(getX(), getY(), getWidth(), getHeight());
		main.setOrigin(getOriginX(), getOriginY());
		main.setColor(getColor());
		main.draw(batch);
		super.draw(batch, parentAlpha);
	}
}

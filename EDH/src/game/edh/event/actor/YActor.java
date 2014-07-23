package game.edh.event.actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import game.edh.Assets;
import game.edh.event.model.CharaY;
import game.edh.event.model.Character;
import game.edh.event.model.EventWorld;
import game.edh.event.model.Character.CharaDirection;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class YActor extends Actor {
	Character y;
	Sprite sprite;
	Sprite yBuf;

	boolean flipX;
	int state;
	float bufX;
	float scale = .023f;

	public YActor(EventWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		try {
			this.y = world.getChara("Y");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		state = y.getState();
		sprite = changeState(state);
		yBuf = sprite;
		setBounds(0, 1.2f, 1.2f, 2.2f);
		setPosition(y.getX(), 1.2f);
		bufX = y.getX();
		if (!y.getShow())
			getColor().a = 0;
	}

	void checkMovingg() {
		if (bufX != y.getX()) {
			bufX = y.getX();
			addAction(sequence(fadeOut(.7f), moveTo(bufX, 1.2f), fadeIn(.7f)));
			Gdx.app.log("Actor", "" + getX());
		}
	}

	void changeState() {
		if (state != y.getState()) {
			state = y.getState();
			yBuf = changeState(state);

			addAction(sequence(fadeOut(.7f), run(new Runnable() {

				@Override
				public void run() {
					// TODO 自動生成されたメソッド・スタブ
					sprite.setFlip(false, false);
					sprite = yBuf;
				}
			}), fadeIn(.7f)));
		}
	}

	Sprite changeState(int state) {
		Sprite s = null;

		switch (state) {
		case CharaY.ARUKU:
			s = Assets.event.getSprite("y_aruku");
			break;
		case CharaY.MIAGERU:
			s = Assets.event.getSprite("y_miageru");
			break;
		case CharaY.MIOROSU:
			s = Assets.event.getSprite("y_miorosu");
			break;
		case CharaY.ODOROKU:
			s = Assets.event.getSprite("y_odoroku");
			break;
		case CharaY.YOKOMUKI:
			s = Assets.event.getSprite("y_yokomuki");
			break;
		}

		return s;
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		checkMovingg();

		if (y.getDirection() == CharaDirection.LEFT)
			flipX = true;
		else
			flipX = false;

		changeState();

		if (getColor().a == 1 && !y.getShow()) {
			getColor().a = 0;
		} else if (getColor().a == 0 && y.getShow()) {
			addAction(fadeIn(.3f));
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		if (sprite.isFlipX() != flipX)
			sprite.flip(flipX, false);
		sprite.setPosition(getX(), getY());
		sprite.setBounds(getX(), getY(), sprite.getRegionWidth() * scale,
				sprite.getRegionHeight() * scale);
		float alpha = parentAlpha < getColor().a ? parentAlpha : getColor().a;
		// Gdx.app.log("Coloa", alpha + ", " + getColor().a);
		sprite.setColor(1, 1, 1, alpha);
		sprite.draw(batch);
		super.draw(batch, parentAlpha);
	}
}

package game.edh.event.actor;

import game.edh.Assets;
import game.edh.event.model.CharaS;
import game.edh.event.model.Character;
import game.edh.event.model.EventWorld;
import game.edh.event.model.Character.CharaDirection;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SActor extends Actor {
	Character S;
	Sprite s;
	Sprite sBuf;

	boolean flipX;
	int state;
	float bufX;
	float scale;

	public SActor(EventWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		try {
			this.S = world.getChara("S");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		scale = .018f;
		state = S.getState();
		s = changeState(state);
		sBuf = s;
		setBounds(0, 1.2f, 1.6f, 2.2f);
		setPosition(S.getX(), 1.2f);
		bufX = S.getX();
	}
	
	void checkMovingg() {
		if (bufX != S.getX()) {
			bufX = S.getX();
			addAction(sequence(fadeOut(.7f), moveTo(bufX, 1.2f), fadeIn(.7f)));
			Gdx.app.log("Actor", "" + getX());
		}
	}

	void changeState() {
		if (state != S.getState()) {
			state = S.getState();
			sBuf = changeState(state);

			addAction(sequence(fadeOut(.7f), run(new Runnable() {

				@Override
				public void run() {
					// TODO 自動生成されたメソッド・スタブ
					s.setFlip(false, false);
					s = sBuf;
					if(state == CharaS.OTONA)
						scale = .026f;
					else
						scale = .018f;
				}
			}), fadeIn(.7f)));
		}
	}

	Sprite changeState(int state) {
		Sprite s = null;

		switch (state) {
		case CharaS.ARUKU:
			s = Assets.event.getSprite("s_aruku");
			break;
		case CharaS.MIOROSU:
			s = Assets.event.getSprite("s_miorosu");
			break;
		case CharaS.FURIMUKU:
			s = Assets.event.getSprite("s_furimuku");
			break;
		case CharaS.HASHIRU:
			s = Assets.event.getSprite("s_hashiru");
			break;
		case CharaS.KAGAMU:
			s = Assets.event.getSprite("s_kagamu");
			break;
		case CharaS.MIAGERU:
			s = Assets.event.getSprite("s_miageru");
			break;
		case CharaS.SHOUMEN:
			s = Assets.event.getSprite("s_shoumen");
			break;
		case CharaS.YOKOMUKI:
			s = Assets.event.getSprite("s_yokomuki");
			break;
		case CharaS.OTONA:
			s = Assets.event.getSprite("s_otona");
			scale = .026f;
			break;
		}

		return s;
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		checkMovingg();

		if (S.getDirection() == CharaDirection.LEFT)
			flipX = true;
		else
			flipX = false;

		changeState();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		if (s.isFlipX() != flipX) 
			s.flip(flipX, false);
		s.setPosition(getX(), getY());
		s.setBounds(getX(), getY(), s.getRegionWidth() * scale,
				s.getRegionHeight() * scale);
		float alpha = parentAlpha < getColor().a ? parentAlpha : getColor().a;
		s.setColor(1, 1, 1, alpha);
		s.draw(batch);
		super.draw(batch, parentAlpha);
	}
}

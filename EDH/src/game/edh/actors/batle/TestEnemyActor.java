package game.edh.actors.batle;

import game.edh.Assets;
import game.edh.actors.batle.TestEnemyEvent.AtackEvent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Pools;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class TestEnemyActor extends Actor {
	public final float HP = 100f;

	float nowHP;
	public final float Atack = 5;

	Sprite enemy;

	float stateTime = 0f;
	final float AtackTime = 1.0f * MathUtils.random(0.8f, 1.2f);
	float AtackDeley = 0.8f;

	float scale;
	private boolean nowAtack = false;

	public TestEnemyActor() {
		// TODO 自動生成されたコンストラクター・スタブ
		enemy = Assets.batle.getSprite("pumpkin");

		addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				if(AtackDeley < 0.2f) {
					nowHP -= TestPlayer.ATACK * 20.0f;
					TestBatleGroup.addCombo();
				}
				else {
					nowHP -= TestPlayer.ATACK;
					TestBatleGroup.combo = 0;
				}
				if (nowHP <= 0) {
					remove();
				}
				Gdx.app.log("touchDown", x + ", " + y);
				return false;
			}
		});
		Gdx.app.log("Region",enemy.getU2() + ", " +  enemy.getRegionWidth() +"");
	}

	public TestEnemyActor init(float scale) {
		this.scale = scale;

		setBounds(MathUtils.random() * 10.8f,
				(MathUtils.random() * 10f) + 7.8f, enemy.getRegionWidth()
						* this.scale, enemy.getRegionHeight() * this.scale);

		// setBounds(5, 8, 1.5f, 1.5f);
		// setOrigin(6, 9);

		this.nowHP = HP;

		return this;
	}

	public void Move() {
		if (getActions().size == 0)
			addAction(moveTo(MathUtils.random() * 10.8f,
					MathUtils.random() * 11f + 7.2f, 2.0f));
	}

	public void Atack() {
		//nowAtack = true;
		AtackDeley -= Gdx.graphics.getDeltaTime();
		setColor(1f * (0.8f * AtackDeley), 1f * (0.8f * AtackDeley),
				1f * (0.8f * AtackDeley), 1f);
		if(AtackDeley <= 0) {
			TestEnemyActor.this.fire(Pools.obtain(AtackEvent.class));
			setColor(Color.RED);
			//nowAtack = false;
			AtackDeley = 0.8f;
			stateTime = 0;
		}
	}

	public void getDown() {

	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		Move();
		stateTime += delta;
		if (stateTime >= AtackTime) {
			//if (MathUtils.random() > 0.3f)
				Atack();
			//stateTime = 0;
		}
		setOrigin(getX() + getWidth() / 2, getY() + getHeight() / 2);
		//Gdx.app.log("Origin", getOriginX() + ", " + getOriginY());
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		enemy.setBounds(getX(), getY(), getWidth(), getHeight());
		enemy.setOrigin(getOriginX(), getOriginY());
		enemy.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		enemy.draw(batch);
		super.draw(batch, parentAlpha);
	}
}

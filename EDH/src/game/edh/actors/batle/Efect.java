package game.edh.actors.batle;

import game.edh.Assets;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Pool;

public class Efect extends Image {
	public static final int HIT = 0;
	public static final int JUST = 1;

	private int efectType;
	private float stateTime;
	private Animation efect;
	private float scale;
	Pool<Efect> efectPool;

	Enemy enemy;

	public Efect(Pool<Efect> efectPool) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.efectPool = efectPool;
	}

	public Efect init(Enemy enemy, int type) {
		this.enemy = enemy;
		this.efectType = type;
		this.scale = (10.8f / 432f) * 1.5f;
		move();

		switch (efectType) {
		case HIT:
			// 通常ヒット時のエフェクト
			efect = Assets.batle.get("hit", Animation.class);
			break;

		case JUST:
			// ジャストヒット時のエフェクト
			efect = Assets.batle.get("just", Animation.class);
			break;
		}

		stateTime = 0;
		return this;
	}

	private void move() {
		setOrigin(enemy.getOriginX(), enemy.getOriginY());
		setPosition(enemy.getOriginX() - getWidth() / 2, enemy.getOriginY()
				- getHeight() / 2);
		//Gdx.app.log("Efect", getOriginX() + "");
		
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		stateTime += delta;

		if (stateTime >= 0.3f) {
			remove();
			efectPool.free(this);
		}
		move();

		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		TextureRegion keyframe = efect.getKeyFrame(stateTime);
		batch.draw(keyframe, getOriginX() - (keyframe.getRegionWidth() / 2) * scale,
				getOriginY() - (keyframe.getRegionHeight() / 2) * scale,
				keyframe.getRegionWidth() * scale, keyframe.getRegionHeight() * scale);
		super.draw(batch, parentAlpha);
	}
}

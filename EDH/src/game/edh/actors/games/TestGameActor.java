package game.edh.actors.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TestGameActor extends Actor {
	Animation hidari;
	Animation migi;
	Animation ue;
	Animation sita;

	Animation player;
	TextureRegion keyframe;

	float stateTime;

	public TestGameActor() {
		// TODO 自動生成されたコンストラクター・スタブ
		TextureAtlas atlas = new TextureAtlas(
				Gdx.files.internal("data/games.atlas"));
		hidari = new Animation(0.2f, atlas.findRegions("hidari"));
		hidari.setPlayMode(Animation.LOOP);
		migi = new Animation(0.2f, atlas.findRegions("migi"));
		migi.setPlayMode(Animation.LOOP);
		ue = new Animation(0.2f, atlas.findRegions("ue"));
		ue.setPlayMode(Animation.LOOP);
		sita = new Animation(0.2f, atlas.findRegions("sita"));
		sita.setPlayMode(Animation.LOOP);
		player = migi;

		stateTime = 0;
		keyframe = migi.getKeyFrames()[4];

		setBounds(35f, 21.5f, hidari.getKeyFrames()[4].getRegionWidth() * 1f / 16f,
				hidari.getKeyFrames()[4].getRegionHeight() * 1f / 16f);

		setOrigin(getX() + getWidth() / 2, getY() + getHeight() / 2);
		Gdx.app.log("Origin", getOriginX() + ", " + getOriginY());
	}

	public void move(float x, float y, float delta) {
		setPosition(getX() + (x * delta * 5), getY() + (y * delta * 5));
		setOrigin(getX() + getWidth() / 2, getY() + getHeight() / 2);
		stateTime += delta;

		if (x > 0) {
			if (Math.abs(x) < Math.abs(y)) {
				if (y >= 0)
					player = ue;
				else
					player = sita;
			} else
				player = migi;
		}

		if (x < 0) {
			if (Math.abs(x) < Math.abs(y)) {
				if (y >= 0)
					player = ue;
				else
					player = sita;
			} else {
				player = hidari;
			}
		}

		if (x == 0 && y == 0) {
			keyframe = player.getKeyFrames()[4];
		} else
			keyframe = player.getKeyFrame(stateTime);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		batch.setColor(1, 1, 1, parentAlpha);
//		batch.draw(keyframe, getX(), getY(), getWidth(), getHeight());
		batch.draw(keyframe, getOriginX() - keyframe.getRegionWidth() * 1f
				/ 32f, getOriginY() - keyframe.getRegionHeight() * 1f / 32f,
				keyframe.getRegionWidth() * 1f / 16f,
				keyframe.getRegionHeight() * 1f / 16f);
		super.draw(batch, parentAlpha);
	}
}

package game.edh.game.actor;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelGameChara;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPlayer extends Actor {
	ModelGameChara player;
	Animation anim;
	TextureRegion keyframe;
	GameCharaDir dir;

	float stateTime;
	float scale = 1f / 16f;

	public ActorPlayer(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		player = world.getPlayer();
		dir = player.getDirection();
		checkAnim();
		keyframe = anim.getKeyFrames()[4];

		setPositions();
		stateTime = 0;
	}

	void checkAnim() {
		switch (dir) {
		case Left:
			anim = Assets.games.get("hidari", Animation.class);
			break;
		case Right:
			anim = Assets.games.get("migi", Animation.class);
			break;
		case Up:
			anim = Assets.games.get("ue", Animation.class);
			break;
		case Down:
			anim = Assets.games.get("shita", Animation.class);
			break;
		}
	}

	void setPositions() {
		float x = player.getPosition().x;
		float y = player.getPosition().y;
		float width = keyframe.getRegionWidth() * scale;
		float height = keyframe.getRegionHeight() * scale;

		setOrigin(x, y);
		setBounds(x - width / 2, (y - height / 2) + .5f, width, height);
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		stateTime += delta;

		if (dir != player.getDirection()) {
			dir = player.getDirection();
			checkAnim();
		}

		if (player.getState() == ModelGameChara.STAND)
			keyframe = anim.getKeyFrames()[4];
		else
			keyframe = anim.getKeyFrame(stateTime);

		setPositions();

		if (stateTime >= 1.2f)
			stateTime = 0;

		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		batch.setColor(1, 1, 1, parentAlpha);
		batch.draw(keyframe, getX(), getY(), getWidth(), getHeight());
		super.draw(batch, parentAlpha);
	}
}

package game.edh.game.actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelInu;
import game.edh.game.model.frame.ModelInu.InuDir;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorInu extends Actor {
	GameWorld world;
	ModelInu inu;
	InuDir dir;

	TextureRegion region;
	boolean draw;

	public ActorInu() {
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(0, 0, 1, 1);

	}

	public void setModel(ModelInu inu) {
		this.inu = inu;
		dir = inu.getDir();
		setPosition(inu.getBounds().x, inu.getBounds().y);

		checkDir();
		draw = inu.draw;
		if(draw)
			setColor(1, 1, 1, 1);
	}

	void checkDir() {
		switch (dir) {
		case Up:
			region = Assets.games.getRegion("inu_ue");
			break;
		case Down:
			region = Assets.games.getRegion("inu_shita");
			break;
		case Left:
			region = Assets.games.getRegion("inu_hidari");
			break;
		case Rignt:
			region = Assets.games.getRegion("inu_migi");
			break;
		}
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		if (dir != inu.getDir()) {
			dir = inu.getDir();
			checkDir();
		}

		if (draw && !inu.draw) {
			addAction(sequence(fadeOut(.3f), run(new Runnable() {

				@Override
				public void run() {
					// TODO 自動生成されたメソッド・スタブ
					draw = false;
				}
			})));
		} else if (!draw && inu.draw) {
			draw = true;
			addAction(fadeIn(.3f));
		}

		if (inu.remove)
			remove();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		if (draw) {
			float alpha = parentAlpha < getColor().a ? parentAlpha
					: getColor().a;
			batch.setColor(1, 1, 1, alpha);
			batch.draw(region, getX() - .1f, getY() - .1f, getWidth() + .1f,
					getHeight() + .1f);
		}
		super.draw(batch, parentAlpha);
	}
}

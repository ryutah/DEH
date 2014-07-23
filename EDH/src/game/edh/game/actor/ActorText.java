package game.edh.game.actor;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class ActorText extends Table {
	GameWorld world;

	public ActorText(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		GameTextActor text = new GameTextActor(world);
		world.getText().setListener(this);

		setBounds(0, 15, 432, 255);
		setBackground(Assets.title.getDrawable("waku"));
		add(text).width(getWidth() - 50).height(getHeight() - 50).fill();
		getColor().a = 0;
		setTouchable(Touchable.disabled);
	}

	public void startText() {
		if (getActions().size == 0)
			addAction(sequence(fadeIn(.3f)));
		else {
			clearActions();
			setColor(1, 1, 1, 1);
		}

		Gdx.app.log("Text", "");
	}

	public void endText() {
		addAction(sequence(fadeOut(.3f), run(new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				ActorText.this.remove();
			}
		})));
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
	}
}

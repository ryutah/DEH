package game.edh.game.actor;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelText;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class GameTextActor extends Label {
	ModelText text;
	CharSequence label;

	public GameTextActor(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		super("", Assets.title, "mikachan");

		text = world.getText();
		label = text.getText();
		setText(label);

		setWrap(true);
		setAlignment(Align.center);
		setColor(Color.BLACK);
	}

	void checkText() {
		if (!label.equals(text.getText())) {
			label = text.getText();
			addAction(sequence(fadeOut(.3f), run(new Runnable() {

				@Override
				public void run() {
					// TODO 自動生成されたメソッド・スタブ
					setText(label);
				}
			}), fadeIn(.3f)));
		}
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタ
		checkText();
		super.act(delta);
	}
}

package game.edh.event.actor;

import game.edh.event.model.Character;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class CharaActor extends Image {
	Character chara;

	public CharaActor(Character chara) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.chara = chara;
		setDrawable(chara.getDrawable());
		setBounds(chara.getX(), 1.2f, chara.getWidth(), chara.getHeight());
		if (!chara.getShow())
			getColor().a = 0;
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		if (getColor().a == 0 && chara.getShow()) {
			addAction(Actions.fadeIn(.3f));
		} else if (getColor().a != 0 && !chara.getShow())
			addAction(Actions.fadeOut(.3f));
	}
}

package game.edh.game.model.frame.event;

import game.edh.Assets;
import game.edh.game.model.frame.event.ModelEvent.ObjType;

public class ButtonModoru extends ModelEventObj {
	public ButtonModoru(ModelEvent parent, ObjType type) {
		super(parent, type);
		// TODO 自動生成されたコンストラクター・スタブ
		setButtonStyle(Assets.games, "b_modoru");
		setCenterX(true);
		setY(1);
		setSize(3);
	}
	
	public ButtonModoru(ModelEvent parent) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(parent, ObjType.Button);
		setButtonStyle(Assets.games, "b_modoru");
		setCenterX(true);
		setY(1);
		setSize(3);
	}
	
	@Override
	protected void action(float x, float y) {
		// TODO 自動生成されたメソッド・スタブ
		world.removeEventObj();
	}

}

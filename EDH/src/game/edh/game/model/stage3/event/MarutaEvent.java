package game.edh.game.model.stage3.event;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.event.ButtonModoru;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.frame.event.ModelEventObj;
import game.edh.game.model.items.ItemsHandler;

public class MarutaEvent extends ModelEvent {
	class Maruta extends ModelEventObj {

		public Maruta(ModelEvent parent, ObjType type) {
			super(parent, type);
			// TODO 自動生成されたコンストラクター・スタブ
			setDrawable(Assets.games, "maruta");
			setCenter(true);
			setSize(6);
		}

		@Override
		protected boolean longTapAction() {
			// TODO 自動生成されたメソッド・スタブ
			if (!world.getFlag(Stage3Flag.KINOKO_GET)) {
				world.textEvent("よく見ると丸太の中に何か生えている", "きのこを手に入れた");
				world.addItem(ItemsHandler.KINOKO);
				world.changeFlag(Stage3Flag.KINOKO_GET, true);
			} else
				world.textEvent("もう何もない");
			return true;
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			world.textEvent("雪にまみれた丸太がある");
		}
	}

	public MarutaEvent(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		ModelEventObj maruta = new Maruta(this, ObjType.Image);
		ModelEventObj modoru = new ButtonModoru(this);
		addObjs(maruta);
		addObjs(modoru);
	}

}

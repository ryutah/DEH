package game.edh.game.model.stage3.event;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.event.ButtonModoru;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.frame.event.ModelEventObj;
import game.edh.game.model.items.ItemsHandler;

public class KakashiEvent extends ModelEvent {

	class Kakashi extends ModelEventObj {

		public Kakashi(ModelEvent parent) {
			// TODO 自動生成されたコンストラクター・スタブ
			super(parent, ObjType.Image);
			setCenter(true);
			setSize(3f);
			setDrawable(Assets.games, "kakashi");
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			super.action(x, y);
			world.textEvent("かかしがある");
		}
		
		@Override
		protected boolean flingAction(float velocityX, float velocityY) {
			// TODO 自動生成されたメソッド・スタブ
			if (velocityY >= 300) {
				if (world.getFlag(Stage3Flag.KAKASHI_KAGI_GET)) {
					world.textEvent("もう何も無いかな");
				} else {
					world.textEvent("帽子を持ち上げてみた", "鍵を見つけた");
					world.addItem(ItemsHandler.KAGI);
					world.changeFlag(Stage3Flag.KAKASHI_KAGI_GET, true);
				}
				return true;
			}
			return false;
		}

	}

	public KakashiEvent(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		ModelEventObj kakashi = new Kakashi(this);
		addObjs(kakashi);
		ModelEventObj modoru = new ButtonModoru(this);
		addObjs(modoru);
	}

}

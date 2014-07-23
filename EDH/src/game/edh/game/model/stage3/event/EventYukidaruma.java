package game.edh.game.model.stage3.event;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.event.ButtonModoru;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.frame.event.ModelEventObj;
import game.edh.game.model.items.ItemsHandler;

public class EventYukidaruma extends ModelEvent {

	class Yukidaruma extends ModelEventObj {

		public Yukidaruma(ModelEvent parent) {
			super(parent, ObjType.Image);
			// TODO 自動生成されたコンストラクター・スタブ
			setCenter(true);
			setSize(2);
			setDrawable(Assets.games, "yukidaruma");
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			world.textEvent("こんなところに雪だるまがある", "誰が作ったんだろう");
		}

		@Override
		protected boolean longTapAction() {
			// TODO 自動生成されたメソッド・スタブ
			if(!world.getItems().findItem(ItemsHandler.TSURIZAO)) {
				world.addItem(ItemsHandler.TSURIZAO);
				world.textEvent("よく見ると腕はただの木の棒じゃないみたい…", "釣り竿を手に入れた");
			} else 
				world.textEvent("もう気になるところはないかな");
			return true;
		}
	}

	public EventYukidaruma(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		addObjs(new Yukidaruma(this));
		ModelEventObj modoru = new ButtonModoru(this);
		addObjs(modoru);
	}

}

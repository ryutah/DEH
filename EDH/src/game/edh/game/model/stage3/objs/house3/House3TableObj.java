package game.edh.game.model.stage3.objs.house3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.items.ItemsHandler;

public class House3TableObj extends MapObject {

	public House3TableObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(1, 4, 2, 4);

	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getFlag(Stage3Flag.PUT_INU))
			world.textEvent("テーブルには３つの人形が乗っている");
		else {
			if (world.getSelectItem() == ItemsHandler.INU) {
				world.textEvent("テーブルに犬の人形を置いた", "…なんだかとっても悲しい気持ちになった");
				world.removeItem(ItemsHandler.INU);
				world.changeFlag(Stage3Flag.PUT_INU, true);
			} else
				world.textEvent("人形が２つ置いてある", "もう少しで何か思い出せそうなんだけど…");
		}
	}

}

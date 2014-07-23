package game.edh.game.model.stage3.objs.map34;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map34IkeObj extends MapObject {

	public Map34IkeObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(6, 8, 1, 2);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage3Flag.SAKANA_GET)) {
			if (world.getSelectItem() == ItemsHandler.TSURIZAO) {
				world.textEvent("釣りをしてみた", "さかなが釣れた");
				world.addItem(ItemsHandler.SAKANA);
				world.changeFlag(Stage3Flag.SAKANA_GET, true);
			} else
				world.textEvent("池がある", "釣り竿があれば何かつれるかも");
		} else
			world.textEvent("もう釣りはいいかな…");
	}
}

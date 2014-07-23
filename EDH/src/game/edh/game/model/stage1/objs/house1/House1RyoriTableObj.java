package game.edh.game.model.stage1.objs.house1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.items.ItemsHandler;

public class House1RyoriTableObj extends MapObject {

	public House1RyoriTableObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(16, 5, 2, 2.5f);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getFlag(Stage1Flag.RYOURI))
			world.textEvent("テーブルの上にさっき作った料理が乗っている");

		else {
			int item = world.getSelectItem();
			if (item == ItemsHandler.RYOURI_SEIKO
					|| item == ItemsHandler.RYOURI_SHIPPAI) {
				String text = "テーブルの上にさっき作った料理を置いた";

				if (item == ItemsHandler.RYOURI_SEIKO) {
					world.removeItem(ItemsHandler.RYOURI_SEIKO);
					world.textEvent(text, "何かが落ちる音がした…");
					world.changeFlag(Stage1Flag.RYOURI, true);
				} else {
					world.textEvent(text, "…特に何もおこらない");
					world.removeItem(ItemsHandler.RYOURI_SHIPPAI);
				}

				world.clearSelectItem();
			} else
				world.textEvent("テーブルがある", "ここで食事をしているのかな");
		}
	}

}

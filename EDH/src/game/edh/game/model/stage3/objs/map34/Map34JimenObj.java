package game.edh.game.model.stage3.objs.map34;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map34JimenObj extends MapObject {

	public Map34JimenObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(16.5f, 12.5f, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage3Flag.GET_INU)) {
			if (world.getSelectItem() == ItemsHandler.SHABERU) {
				world.textEvent("地面を掘り返してみた", "何か埋まっている…", "犬のぬいぐるみを手に入れた");
				world.addItem(ItemsHandler.INU);
				world.changeFlag(Stage3Flag.GET_INU, true);
			}
		}
	}
}

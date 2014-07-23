package game.edh.game.model.stage3.objs.map32;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map32JimenObj extends MapObject {

	public Map32JimenObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8, 21, 2, 2);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if(!world.getFlag(Stage3Flag.MEMO_GET)) {
			if(world.getSelectItem() == ItemsHandler.SHABERU) {
				world.textEvent("地面を掘ってみた", "メモを見つけた");
				world.addItem(ItemsHandler.MEMO);
				world.changeFlag(Stage3Flag.MEMO_GET, true);
			}
		} 
	}
}

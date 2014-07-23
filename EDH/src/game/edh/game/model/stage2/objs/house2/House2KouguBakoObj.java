package game.edh.game.model.stage2.objs.house2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.items.ItemsHandler;

public class House2KouguBakoObj extends MapObject {

	public House2KouguBakoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(5, 11, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage2Flag.HAMMER_GET)) {
			if (world.getSelectItem() == ItemsHandler.KAGI) {
				world.removeItem(ItemsHandler.KAGI);
				world.addItem(ItemsHandler.KANAZUTI);
				world.changeFlag(Stage2Flag.HAMMER_GET, true);
				world.textEvent("鍵をあけた", "金槌を手に入れた");
			} else
				world.textEvent("鍵がかかっている");
		} else
			world.textEvent("何も入っていない");
	}
}

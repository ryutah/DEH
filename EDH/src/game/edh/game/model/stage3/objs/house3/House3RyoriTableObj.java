package game.edh.game.model.stage3.objs.house3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.items.ItemsHandler;

public class House3RyoriTableObj extends MapObject {

	public House3RyoriTableObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(16.45f, 6, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if(world.getFlag(Stage3Flag.PUT_RYORI))
			world.textEvent("テーブルには料理が乗っている");
		else {
			int item = world.getSelectItem();
			if(item == ItemsHandler.RYOURI_SEIKO) {
				world.removeItem(item);
				world.changeFlag(Stage3Flag.PUT_RYORI, true);
				world.textEvent("料理をテーブルに置いた");
			} else if (item == ItemsHandler.RYOURI_SHIPPAI) {
				world.removeItem(item);
				world.textEvent("料理をテーブルに置いた", "…何か違う気がする");
			} else
				world.textEvent("テーブルがある");
		}
	}

}

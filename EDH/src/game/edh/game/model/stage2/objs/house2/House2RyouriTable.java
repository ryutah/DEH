package game.edh.game.model.stage2.objs.house2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.items.ItemsHandler;

public class House2RyouriTable extends MapObject {

	public House2RyouriTable(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(16, 5, 2, 2.5f);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		boolean a = world.getFlag(Stage2Flag.PUT_RYOURI1);
		boolean b = world.getFlag(Stage2Flag.PUT_RYOURI2);

		String text = "料理をテーブルに置いた";
		String text2 = "何か違うみたい…";
		String text3 = "テーブルの上に料理が乗っている";

		int item = world.getSelectItem();

		if (a && b) {
			world.textEvent("テーブルの上には、２つの料理が置かれている");
		} else if (a && !b) {
			if (item == ItemsHandler.RYOURI_SEIKO2) {
				world.changeFlag(Stage2Flag.PUT_RYOURI2, true);
				world.removeItem(item);
				world.textEvent(text);
			} else if (item == ItemsHandler.RYOURI_SHIPPAI
					|| item == ItemsHandler.RYOURI_SEIKO) {
				world.removeItem(item);
				world.textEvent(text, text2);
			} else
				world.textEvent(text3);
		} else if (!a && b) {
			if (item == ItemsHandler.RYOURI_SEIKO) {
				world.changeFlag(Stage2Flag.PUT_RYOURI1, true);
				world.removeItem(item);
				world.textEvent(text);
			} else if (item == ItemsHandler.RYOURI_SEIKO2
					|| item == ItemsHandler.RYOURI_SHIPPAI) {
				world.removeItem(item);
				world.textEvent(text, text2);
			} else
				world.textEvent(text3);
		} else {
			if (item == ItemsHandler.RYOURI_SEIKO) {
				world.changeFlag(Stage2Flag.PUT_RYOURI1, true);
				world.removeItem(item);
				world.textEvent(text);
			} else if (item == ItemsHandler.RYOURI_SEIKO2) {
				world.changeFlag(Stage2Flag.PUT_RYOURI2, true);
				world.removeItem(item);
				world.textEvent(text);
			} else if (item == ItemsHandler.RYOURI_SHIPPAI) {
				world.removeItem(item);
				world.textEvent(text, text2);
			} else
				world.textEvent("テーブルがある");
		}
	}
}

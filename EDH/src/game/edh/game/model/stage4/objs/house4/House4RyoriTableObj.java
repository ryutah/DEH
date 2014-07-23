package game.edh.game.model.stage4.objs.house4;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.items.ItemsHandler;
import game.edh.game.model.stage4.event.MapEventRyouri;

public class House4RyoriTableObj extends MapObject {

	public House4RyoriTableObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(16, 5, 2, 2.5f);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタ
		if (world.getSelectItem() == ItemsHandler.RYOURI_SEIKO) {
			world.removeItem(ItemsHandler.RYOURI_SEIKO);
			world.changeFlag(Stage4Flag.PUT_RYORI, true);
			world.addMapEvent(new MapEventRyouri(world, world.getMap()));
		} else if (world.getSelectItem() == ItemsHandler.RYOURI_SHIPPAI) {
			world.removeItem(ItemsHandler.RYOURI_SHIPPAI);
			world.textEvent("料理を置いた", "…何か違うみたい");
		} else
			world.textEvent("テーブルがある");
	}
}

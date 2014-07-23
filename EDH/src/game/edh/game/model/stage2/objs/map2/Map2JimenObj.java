package game.edh.game.model.stage2.objs.map2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map2JimenObj extends MapObject {

	public Map2JimenObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(22.5f, 16.5f, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage2Flag.NINGYO_GET)) {
			world.addItem(ItemsHandler.NINGYOAO);
			world.changeFlag(Stage2Flag.NINGYO_GET, true);
			world.textEvent("ここだけ妙に地面が柔らかい", "地面を掘ってみた", "人形を手に入れた");
		}
	}
}

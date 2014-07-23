package game.edh.game.model.stage2.objs.map23;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map23WaraObj extends MapObject {

	public Map23WaraObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(18, 4, 3, 3);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if(!world.getFlag(Stage2Flag.BOU_GET)) {
			world.addItem(ItemsHandler.BOU);
			world.changeFlag(Stage2Flag.BOU_GET, true);
			world.textEvent("藁の中を調べた", "木の棒を手に入れた");
		} else
			world.textEvent("もう何もなさそう");
	}

}

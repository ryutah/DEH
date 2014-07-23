package game.edh.game.model.stage4.objs.map44;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map44HanaObj extends MapObject {

	public Map44HanaObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(13, 7, 2, 2);
		
		if(world.getFlag(Stage4Flag.HANA_GET))
			setCheck(false);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if(!world.getFlag(Stage4Flag.HANA_GET)) {
			world.addItem(ItemsHandler.HANA);
			world.changeFlag(Stage4Flag.HANA_GET, true);
			world.textEvent("こんなところに花が咲いてる…", "花を手にれた");
			setCheck(false);
		}
	}
}

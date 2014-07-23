package game.edh.game.model.stage1.objs.map1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map1KagiObj extends MapObject {

	public Map1KagiObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(21.5f, 10, 1, 1);
		setName("kagi");
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("何か落ちている", "鍵を見つけた");
		world.addItem(ItemsHandler.KAGI);
		world.changeFlag(Stage1Flag.KAGI_GET, true);
		world.getMap().removeObjs(this);
	}

}

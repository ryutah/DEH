package game.edh.game.model.stage2.objs.house2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.items.ItemsHandler;

public class House2HouchoObj extends MapObject {

	public House2HouchoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(18, 11, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if(!world.getItems().findItem(ItemsHandler.HOUCHO)) {
			world.textEvent("包丁がある…", "とりあえず持って行こうかな", "包丁を手に入れた");
			world.addItem(ItemsHandler.HOUCHO);
		}
	}
}

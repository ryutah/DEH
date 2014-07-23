package game.edh.game.model.stage3.objs.house3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.items.ItemsHandler;

public class House3BedObj extends MapObject {

	public House3BedObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(2, 11, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		super.checkObj();
		if (world.getFlag(Stage3Flag.SHABERU_GET))
			world.textEvent("ベッドがある");
		else {
			if (world.getSelectItem() == ItemsHandler.TSURIZAO) {
				world.textEvent("釣り竿を使ってベッドの下をかき回した", "シャベルを手に入れた");
				world.addItem(ItemsHandler.SHABERU);
				world.changeFlag(Stage3Flag.SHABERU_GET, true);
			} else {
				world.textEvent("ベッドがある", "ベッドの下で何か光っているが、手が届きそうにない");
			}
		}
	}

}

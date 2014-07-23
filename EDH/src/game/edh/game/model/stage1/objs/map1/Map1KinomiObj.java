package game.edh.game.model.stage1.objs.map1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map1KinomiObj extends MapObject {

	public Map1KinomiObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(5, 17, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタ
		if (!world.getFlag(Stage1Flag.KINOMI_GET)) {
			if (world.getSelectItem() == ItemsHandler.BOU) {
				world.textEvent("棒を使ってきのみを落とした");
				world.addItem(ItemsHandler.KINOMI_1);
				world.changeFlag(Stage1Flag.KINOMI_GET, true);
			} else
				world.textEvent("木には実がなっているが手が届きそうにない");
		} else
			world.textEvent("もう取らなくてもいいかな");
	}

}

package game.edh.game.model.stage2.objs.house2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.items.ItemsHandler;

public class House2SaihoubakoObj extends MapObject {

	public House2SaihoubakoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8, 11, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage2Flag.SAO_GET)) {
			if (world.getSelectItem() == ItemsHandler.BOU) {
				world.textEvent("木の棒に糸と針をくっつけてみた", "釣り竿をてにいれた");
				world.removeItem(ItemsHandler.BOU);
				world.addItem(ItemsHandler.TSURIZAO);
				world.changeFlag(Stage2Flag.SAO_GET, true);
			} else
				world.textEvent("棚の上には糸や針が入っている裁縫箱が乗っている");
		} else
			world.textEvent("もう必要なものは無いかな");
	}
}

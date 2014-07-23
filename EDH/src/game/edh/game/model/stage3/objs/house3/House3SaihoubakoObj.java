package game.edh.game.model.stage3.objs.house3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.items.ItemsHandler;

public class House3SaihoubakoObj extends MapObject {

	public House3SaihoubakoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8, 11, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage3Flag.TEBUKURO_GET)) {
			if (world.getSelectItem() == ItemsHandler.KAGI) {
				world.textEvent("裁縫箱の鍵を開けた", "手袋を手に入れた");
				world.clearSelectItem();
				world.removeItem(ItemsHandler.KAGI);
				world.addItem(ItemsHandler.TEBUKURO);
				world.changeFlag(Stage3Flag.TEBUKURO_GET, true);
			} else {
				world.textEvent("棚の上に裁縫箱が乗っている", "中を見ようとしたが、鍵がかかっていて開かない");

			}
		} else
			world.textEvent("もう気になるものはなさそう");
	}

}

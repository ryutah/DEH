package game.edh.game.model.stage4.objs.house4;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class House4SaihoubakoObj extends MapObject {

	public House4SaihoubakoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8, 11, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("裁縫箱が乗った棚だ\n気になるものはない");
	}
}

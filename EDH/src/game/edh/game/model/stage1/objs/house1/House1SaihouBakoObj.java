package game.edh.game.model.stage1.objs.house1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class House1SaihouBakoObj extends MapObject {

	public House1SaihouBakoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8, 11, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("棚の上には裁縫箱が乗っている", "…特に気になるものはなさそう");
	}

}

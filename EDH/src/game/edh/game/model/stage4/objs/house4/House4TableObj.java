package game.edh.game.model.stage4.objs.house4;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class House4TableObj extends MapObject {

	public House4TableObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(1, 4, 2, 4.5f);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("テーブルの上には３つの人形が乗っている");
	}
}

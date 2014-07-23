package game.edh.game.model.stage3.objs.house3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class House3TsuboObj extends MapObject {

	public House3TsuboObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(9, 2, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		super.checkObj();
		world.textEvent("ツボがある", "中には何も入っていない");
	}

}

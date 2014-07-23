package game.edh.game.model.stage4.objs.house4;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class House4TsuboObj extends MapObject {

	public House4TsuboObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(9, 2, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("何も入っていない");
	}
}

package game.edh.game.model.stage4.objs.house4;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class House4KouguBakoObj extends MapObject {

	public House4KouguBakoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(5, 11, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("何も入っていない");
	}
}

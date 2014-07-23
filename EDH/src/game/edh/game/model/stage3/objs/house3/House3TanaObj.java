package game.edh.game.model.stage3.objs.house3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class House3TanaObj extends MapObject {

	public House3TanaObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(12, 4.5f, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("ここには気になるものは無い");
	}

}

package game.edh.game.model.stage4.objs.house4;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.stage4.event.EventMemo4;

public class House4TanaObj extends MapObject {

	public House4TanaObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(12, 6, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addEventObj(new EventMemo4(world));
	}
}

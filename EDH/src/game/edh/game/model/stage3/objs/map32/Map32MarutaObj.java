package game.edh.game.model.stage3.objs.map32;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.stage3.event.MarutaEvent;

public class Map32MarutaObj extends MapObject {

	public Map32MarutaObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(24, 13, 3, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addEventObj(new MarutaEvent(world));
		super.checkObj();
	}
}

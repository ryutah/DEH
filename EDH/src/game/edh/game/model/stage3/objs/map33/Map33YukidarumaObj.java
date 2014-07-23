package game.edh.game.model.stage3.objs.map33;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.stage3.event.EventYukidaruma;

public class Map33YukidarumaObj extends MapObject {

	public Map33YukidarumaObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(9, 8, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addEventObj(new EventYukidaruma(world));
	}
}

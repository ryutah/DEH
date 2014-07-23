package game.edh.game.model.stage3.objs.map32;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.stage3.event.KakashiEvent;

public class Map32KakashiObj extends MapObject {

	public Map32KakashiObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(11, 27, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addEventObj(new KakashiEvent(world));
	}
}

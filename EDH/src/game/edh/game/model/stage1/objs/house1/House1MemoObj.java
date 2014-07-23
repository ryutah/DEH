package game.edh.game.model.stage1.objs.house1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.stage1.event.EventMemo;

public class House1MemoObj extends MapObject {

	public House1MemoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(12, 4.5f, 2, 1);
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addEventObj(new EventMemo(world));
	}
	
}

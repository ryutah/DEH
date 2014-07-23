package game.edh.game.model.stage4.objs.map4;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class Map4KanbanObj extends MapObject {

	public Map4KanbanObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(11, 9, 2, 2);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("『　　　　　』", "…何も書かれていない");
	}
}

package game.edh.game.model.stage1.objs.map1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class Map1Kanban1Obj extends MapObject {

	public Map1Kanban1Obj(float x, float y, float width, float height, String name,
			GameWorld world) {
		super(x, y, width, height, name, world);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("”危険！ ”\n先日の大雨で、道の一部が崩れています");
	}
}

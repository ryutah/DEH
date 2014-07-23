package game.edh.game.model.stage3.objs.map3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class Map3KanbajObj extends MapObject {

	public Map3KanbajObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(16, 16, 1, 1);
		setName("kanban");
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("冬の森はとっても危険");
		super.checkObj();
	}

}

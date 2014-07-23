package game.edh.game.model.stage1.objs.house1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.stage1.event.EventRyouri1;

public class House1NabeObj extends MapObject {

	public House1NabeObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(12, 11, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage1Flag.RYOURI))
			world.addEventObj(new EventRyouri1(world));
		else
			world.textEvent("もう料理を作らなくてもよさそう");
	}

}

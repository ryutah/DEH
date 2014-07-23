package game.edh.game.model.stage2.objs.house2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.stage2.event.EventRyouri2;

public class House2NabeObj extends MapObject {

	public House2NabeObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(12, 11, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getFlag(Stage2Flag.PUT_RYOURI1)
				&& world.getFlag(Stage2Flag.PUT_RYOURI2))
			world.textEvent("もう料理はいいかな");
		else
			world.addEventObj(new EventRyouri2(world));
	}
}

package game.edh.game.model.stage1.objs.map1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelInu;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.stage1.event.MapEventHelp;

public class Map1Inu extends ModelInu {
	boolean first;

	public Map1Inu(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setPosition(28, 24);
		setDir(InuDir.Down);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		super.checkObj();
		if (!world.getFlag(Stage1Flag.PUT_NINGYO)) {
			if (!first) {
				world.textEvent("とても汚れた犬がいる…", "『…久し振り、\nまたこの森にきたんだね…』");
				first = true;
			} else
				world.addMapEvent(new MapEventHelp(world, world.getMap()));
		} else
			world.textEvent("『先に進むときっと彼女に会えるよ』");
	}
}

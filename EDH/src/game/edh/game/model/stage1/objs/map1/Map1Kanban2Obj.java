package game.edh.game.model.stage1.objs.map1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;

public class Map1Kanban2Obj extends MapObject {
	String[] text = { "○月×日 橋の建設中", "建設後は、回り道をせずに街へ行き来できるようになります。",
			"看板の下に小さく文字が刻まれている", "「私のパパが作ってるの！」" };
	String[] text2 = { "○月×日完成\n\n橋の名前募集中！" };

	public Map1Kanban2Obj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(21, 8, 2, .5f);
		setName("kanban2");
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage1Flag.NIKKI))
			world.textEvent(text);
		else
			world.textEvent(text2);
	}

}

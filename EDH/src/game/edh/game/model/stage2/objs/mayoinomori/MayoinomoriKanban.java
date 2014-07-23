package game.edh.game.model.stage2.objs.mayoinomori;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class MayoinomoriKanban extends MapObject {

	public MayoinomoriKanban(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(9, 8, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("道に迷ったら、すぐに引き返して下さい");
	}
}

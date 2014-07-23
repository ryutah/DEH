package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class MapEventRemTana2 extends ModelMapEvent {

	public MapEventRemTana2(GameWorld world) {
		super(world, world.getMap());
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("この棚にある裁縫箱は、２人のペットを作った魔法の箱",
				"できたペットはとても不格好だったけど、私の一番の宝物だった", "なのに、今ではもう……");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeFlag(Stage4Flag.RIM_TANA2, true);
		endMapEvent();
	}

}

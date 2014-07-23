package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class MapEventRemTsukue1 extends ModelMapEvent {

	public MapEventRemTsukue1(GameWorld world) {
		super(world, world.getMap());
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("あの子が毎日つけてた日記", "頼んでも読ませてくれなかったけど、何回かこっそり読んだことがある",
				"私と遊んだことばっかり書いてあって", "なんだかとっても嬉しくなった");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeFlag(Stage4Flag.RIM_TSUKUE1, true);
		endMapEvent();
	}

}

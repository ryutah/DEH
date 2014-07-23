package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class MapEventRemHako extends ModelMapEvent {

	public MapEventRemHako(GameWorld world) {
		super(world, world.getMap());
		// TODO 自動生成されたコンストラクター・スタブ

	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("あの子のパパの工具箱は、子供の私にはとても刺激的なおもちゃ箱",
				"勝手に使って怒られて、しょんぼりしたけど懲りずにまた勝手に使って…");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeFlag(Stage4Flag.RIM_HAKO, true);
		endMapEvent();
	}

}

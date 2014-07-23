package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class MapEventRemTana1 extends ModelMapEvent {

	public MapEventRemTana1(GameWorld world) {
		super(world, world.getMap());
		// TODO 自動生成されたコンストラクター・スタブ

	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("ここには確かあの子のメモがあったはず", "作ってもらった料理のメモもここにはあって、",
				"こっそり持って帰って自分の家でつくってみたりしてた", "いっかいもちゃんとできなくて",
				"そのたびに、やっぱりあの子はすごいなあなんて思ってた");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeFlag(Stage4Flag.RIM_TANA1, true);
		endMapEvent();
	}

}

package game.edh.screen;

import game.edh.EdhGame;
import game.edh.actors.batle.Batle1Group;
import game.edh.actors.batle.StatusGroup;
import game.edh.frame.BatleScreen;

public class Batle1Screen extends BatleScreen{

	public Batle1Screen(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void initGame() {
		// TODO 自動生成されたメソッド・スタブ
		group = new Batle1Group().init();
		status = new StatusGroup(group, this);
	}
}

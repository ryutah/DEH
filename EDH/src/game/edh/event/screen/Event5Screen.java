package game.edh.event.screen;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.event.model.Event5;
import game.edh.frame.BaseScreen;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class Event5Screen extends EventScreen {

	public Event5Screen(EdhGame game, boolean backTitle) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(game, backTitle);
		setMusic(Assets.AKAIFUUSEN);
	}

	@Override
	void genEventWorld() {
		// TODO 自動生成されたメソッド・スタブ
		world = new Event5(this);
	}

	@Override
	public BaseScreen nextScreen() {
		// TODO 自動生成されたメソッド・スタブ
		return new LoadScreen(edh, NextScreen.STAGE3);
	}

}

package game.edh.event.screen;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.event.model.Event6;
import game.edh.frame.BaseScreen;
import game.edh.screen.LoadScreen;
import game.edh.screen.TitleScreen.TableType;

public class Event6Screen extends EventScreen {

	public Event6Screen(EdhGame game, boolean backTitle) {
		super(game, backTitle);
		// TODO 自動生成されたコンストラクター・スタブ
		setMusic(Assets.MORUDAU);
	}

	@Override
	void genEventWorld() {
		// TODO 自動生成されたメソッド・スタブ
		world = new Event6(this);
	}

	@Override
	public BaseScreen nextScreen() {
		// TODO 自動生成されたメソッド・スタブ
		return new LoadScreen(edh, TableType.STAGETITLE4);
	}

}

package game.edh.event.screen;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.event.model.Event2;
import game.edh.frame.BaseScreen;
import game.edh.screen.LoadScreen;
import game.edh.screen.TitleScreen.TableType;

public class Event2Screen extends EventScreen {

	public Event2Screen(EdhGame game, boolean backTitle) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(game, backTitle);
		setMusic(Assets.MORUDAU);
	}

	@Override
	void genEventWorld() {
		// TODO 自動生成されたメソッド・スタブ
		world = new Event2(this);
	}

	@Override
	public BaseScreen nextScreen() {
		// TODO 自動生成されたメソッド・スタブ
		return new LoadScreen(edh, TableType.STAGETITLE2);
	}

}

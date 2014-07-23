package game.edh.game.screen;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.game.model.frame.GameData;
import game.edh.game.model.stage3.Stage3World;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class ScreenStage3 extends GameBaseScreen {

	public ScreenStage3(EdhGame game) {
		super(game);
		// TODO 自動生成されたコンストラクター・スタブ
		setMusic(Assets.CHIISANA);
	}

	public ScreenStage3(EdhGame game, GameData data) {
		super(game, data);
		setMusic(Assets.CHIISANA);
	}

	@Override
	void genWorldClass() {
		// TODO 自動生成されたメソッド・スタブ
		setWorldClass(new Stage3World(this));
	}

	@Override
	public void stageEnd() {
		// TODO 自動生成されたメソッド・スタブ
		super.stageEnd();
		changeScreen(new LoadScreen(edh, NextScreen.EVENT6));
	}

	@Override
	void genWorldClass(GameData data) {
		// TODO 自動生成されたメソッド・スタブ
		setWorldClass(new Stage3World(this, data).load());
	}

}

package game.edh.game.screen;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.game.model.frame.GameData;
import game.edh.game.model.stage2.Stage2World;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class ScreenStage2 extends GameBaseScreen {

	public ScreenStage2(EdhGame game) {
		super(game);
		// TODO 自動生成されたコンストラクター・スタブ
		setMusic(Assets.HINOKAGERI);
	}

	public ScreenStage2(EdhGame game, GameData data) {
		super(game, data);
		setMusic(Assets.HINOKAGERI);
	}

	@Override
	void genWorldClass() {
		// TODO 自動生成されたメソッド・スタブ
		setWorldClass(new Stage2World(this));

	}

	@Override
	public void stageEnd() {
		// TODO 自動生成されたメソッド・スタブ
		super.stageEnd();
		changeScreen(new LoadScreen(edh, NextScreen.EVENT4));
	}

	@Override
	void genWorldClass(GameData data) {
		// TODO 自動生成されたメソッド・スタブ
		setWorldClass(new Stage2World(this, data).load());
	}

}

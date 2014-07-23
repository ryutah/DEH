package game.edh.game.screen;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.game.model.frame.GameData;
import game.edh.game.model.stage1.Stage1World;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class ScreenStage1 extends GameBaseScreen {

	public ScreenStage1(EdhGame game) {
		super(game);
		// TODO 自動生成されたコンストラクター・スタブ
		setMusic(Assets.YUUGURE);
	}

	public ScreenStage1(EdhGame game, GameData data) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(game, data);
		setMusic(Assets.YUUGURE);
	}

	@Override
	public void showScreen() {
		// TODO 自動生成されたメソッド・スタブ
		super.showScreen();
	}

	@Override
	void genWorldClass() {
		// TODO 自動生成されたメソッド・スタブ
		setWorldClass(new Stage1World(this));
	}

	@Override
	public void stageEnd() {
		// TODO 自動生成されたメソッド・スタブ
		super.stageEnd();
		changeScreen(new LoadScreen(edh, NextScreen.EVENT2));
	}

	@Override
	void genWorldClass(GameData data) {
		// TODO 自動生成されたメソッド・スタブ
		setWorldClass(new Stage1World(this, data).load());
	}

}

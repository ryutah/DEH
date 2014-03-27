package game.edh.screen;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.actors.TextLabel;
import game.edh.frame.BaseScreen;

public class GameScreen extends BaseScreen {
	Table textTable;
	TextLabel texts;
	int[] hasItem;

	public GameScreen(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		textTable = new Table();
		texts = new TextLabel("", Assets.title.get("mikachan", LabelStyle.class));
		textTable.addActor(texts);
		hasItem = new int[6];
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}
	
	public void textEvent(String ... texts) {
		this.texts.setText(texts);
		mainTable.addActor(textTable);
	}
	
	public void changeItem(int[] hasItem) {
		this.hasItem = hasItem;
	}

}

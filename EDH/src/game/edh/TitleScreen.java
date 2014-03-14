package game.edh;

import com.badlogic.gdx.Gdx;

import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;

public class TitleScreen extends BaseScreen {
	BaseTable table;

	public TitleScreen(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		mainTable.setBackground(Assets.title.getDrawable("titleback"));
		table = new MenuTable(game, this, mainTable);
		mainTable.addActor(table);
		table.show();
		table.debug();
		
		setMusic(Assets.MORUDAU);
	}
	
	public void changeTable(BaseTable table) {
		table.show();
		mainTable.addActor(table);
	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ
		Gdx.app.log("Screen", "Pause");
	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ
		Gdx.app.log("Screen", "Resume");
	}

	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}

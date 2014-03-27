package game.edh.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.actors.title.MenuTable;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;

public class TitleScreen extends BaseScreen {
	BaseTable table;
	Image back;

	public TitleScreen(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		TextureRegion backImage = Assets.title.getRegion("titleback");
		back = new Image(backImage);
		back.setBounds(0, 0, stageWidth, stageHeight);
		mainTable.addActor(back);
		
		table = new MenuTable(this, mainTable);
		mainTable.addActor(table);
		table.show();

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
	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ
		super.hide();
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		Gdx.app.exit();
	}

}

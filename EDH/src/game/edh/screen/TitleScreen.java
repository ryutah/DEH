package game.edh.screen;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;
import game.edh.title.actor.EventDemoTable;
import game.edh.title.actor.MenuTable;
import game.edh.title.actor.StageTitleTable;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TitleScreen extends BaseScreen {
	public enum TableType {
		STAGETITLE1, STAGETITLE2, STAGETITLE3, STAGETITLE4, ARCHIVE
	}

	BaseTable table;
	Image back;

	public TitleScreen(EdhGame game) {
		super(game);
		// TODO 自動生成されたコンストラクター・スタブ
		TextureRegion backImage = Assets.title.getRegion("titleback");
		back = new Image(backImage);
		back.setBounds(0, 0, 432, 768);
		mainTable.addActor(back);

		table = new MenuTable(this, mainTable);
		mainTable.addActor(table);
		table.show();

		setMusic(Assets.THAIKOV);
//
//		mainTable.addListener(new ActorGestureListener() {
//			@Override
//			public void fling(InputEvent event, float velocityX,
//					float velocityY, int button) {
//				// TODO 自動生成されたメソッド・スタブ
//				if (velocityX < -500) {
//					changeScreen(new LoadScreen(edh, NextScreen.STAGE1));
//				} else if (velocityX > 500) {
//					changeScreen(new LoadScreen(edh, NextScreen.STAGE2));
//				} else if (velocityY < -500) {
//					changeScreen(new LoadScreen(edh, NextScreen.STAGE3));
//				} else if (velocityY > 500) {
//					changeScreen(new LoadScreen(edh, NextScreen.STAGE4));
//				}
//			}
//		});
	}

	public TitleScreen(EdhGame game, TableType type) {
		super(game);
		TextureRegion backImage = Assets.title.getRegion("titleback");
		back = new Image(backImage);
		back.setBounds(0, 0, 432, 768);
		mainTable.addActor(back);

		switch (type) {
		case STAGETITLE1:
			table = new StageTitleTable(this, mainTable, 1);
			break;
		case STAGETITLE2:
			table = new StageTitleTable(this, mainTable, 2);
			break;
		case STAGETITLE3:
			table = new StageTitleTable(this, mainTable, 3);
			break;
		case STAGETITLE4:
			table = new StageTitleTable(this, mainTable, 4);
			break;
		case ARCHIVE:
			table = new EventDemoTable(this, mainTable);
		}
		mainTable.addActor(table);
		table.show();

		if (type != TableType.STAGETITLE1)
			setMusic(Assets.THAIKOV);
	}

	public void changeTable(BaseTable table) {
		table.show();
		mainTable.addActor(table);
		this.table = table;
	}

	@Override
	public void showScreen() {
		// TODO 自動生成されたメソッド・スタ
		super.showScreen();
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
		table.backPress();
	}

}

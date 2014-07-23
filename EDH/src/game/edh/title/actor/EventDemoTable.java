package game.edh.title.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.frame.BaseClickAction;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class EventDemoTable extends BaseTable {

	public EventDemoTable(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		Image back = new Image(Assets.title.getRegion("back"));
		back.setPosition(216 - back.getWidth() / 2, 30);
		back.setColor(Color.BLACK);
		back.addListener(new BaseClickAction(back) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new ArchiveTable(EventDemoTable.this.screen,
						EventDemoTable.this.mainTable));
			}
		});
		addActor(back);

		LabelStyle style = Assets.title.get("TOfont", LabelStyle.class);

		Table table = new Table();
		table.defaults().space(20);
		ScrollPane pane = new ScrollPane(table);

		float width = 300;
		float height = 400;
		float x = 216 - 150;
		float y = 200;
		pane.setBounds(x, y, width, height);

		addActor(pane);

		if (EdhGame.settings.clearStage[0]) {
			Label event1 = new Label("EVENT1", style);
			event1.setColor(Color.BLACK);
			addTapAction(event1, NextScreen.EVENT1);
			table.add(event1).row();

			Label event2 = new Label("EVENT2", style);
			addTapAction(event2, NextScreen.EVENT2);
			event2.setColor(Color.BLACK);
			table.add(event2).row();
		}

		if (EdhGame.settings.clearStage[1]) {
			Label event3 = new Label("EVENT3", style);
			event3.setColor(Color.BLACK);
			addTapAction(event3, NextScreen.EVENT3);
			table.add(event3).row();

			Label event4 = new Label("EVENT4", style);
			event4.setColor(Color.BLACK);
			addTapAction(event4, NextScreen.EVENT4);
			table.add(event4).row();
		}

		if (EdhGame.settings.clearStage[2]) {
			Label event5 = new Label("EVENT5", style);
			event5.setColor(Color.BLACK);
			addTapAction(event5, NextScreen.EVENT5);
			table.add(event5).row();

			Label event6 = new Label("EVENT6", style);
			event6.setColor(Color.BLACK);
			addTapAction(event6, NextScreen.EVENT6);
			table.add(event6).row();
		}

		if (EdhGame.settings.clearStage[3]) {
			Label event7 = new Label("EVENT7", style);
			event7.setColor(Color.BLACK);
			addTapAction(event7, NextScreen.EVENT7);
			table.add(event7).row();

			Label event8 = new Label("EVENT8", style);
			event8.setColor(Color.BLACK);
			addTapAction(event8, NextScreen.EVENT8);
			table.add(event8).row();
		}

	}

	void addTapAction(Label label, final NextScreen next) {
		label.addListener(new BaseClickAction(label) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				screen.changeScreen(new LoadScreen(screen.getEdh(), next, true));
			}
		});
	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		changeTable(new MenuTable(EventDemoTable.this.screen,
				EventDemoTable.this.mainTable));
	}

}

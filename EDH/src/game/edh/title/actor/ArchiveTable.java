package game.edh.title.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import game.edh.Assets;
import game.edh.frame.BaseClickAction;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;

public class ArchiveTable extends BaseTable {

	public ArchiveTable(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		setFillParent(true);

		// TODO 自動生成されたコンストラクター・スタブ
		LabelStyle style = Assets.title.get("TOfont", LabelStyle.class);

		Label memo = new Label("MEMO", style);
		memo.setColor(Color.BLACK);
		memo.setFontScale(1.2f);
		memo.addListener(new BaseClickAction(memo) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new ArchiveMemoTable(ArchiveTable.this.screen,
						ArchiveTable.this.mainTable));
			}
		});

		Label event = new Label("EVENT", style);
		event.setColor(Color.BLACK);
		event.setFontScale(1.2f);
		event.addListener(new BaseClickAction(event) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new EventDemoTable(ArchiveTable.this.screen,
						ArchiveTable.this.mainTable));
			}
		});

		defaults().spaceBottom(70);

		add(memo).row();
		add(event);

		Image back = new Image(Assets.title.getRegion("back"));
		back.setColor(Color.BLACK);
		back.addListener(new BaseClickAction(back) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new MenuTable(ArchiveTable.this.screen,
						ArchiveTable.this.mainTable));
			}
		});

		back.setPosition(216 - back.getWidth() / 2, 30);
		addActor(back);
	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		changeTable(new MenuTable(ArchiveTable.this.screen,
				ArchiveTable.this.mainTable));
	}

}

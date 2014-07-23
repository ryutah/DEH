package game.edh.title.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.frame.BaseClickAction;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;

public class ArchiveMemoTable extends BaseTable {

	public ArchiveMemoTable(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		setFillParent(true);

		Image back = new Image(Assets.title.getRegion("back"));
		back.setColor(Color.BLACK);
		back.addListener(new BaseClickAction(back) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new ArchiveTable(ArchiveMemoTable.this.screen,
						ArchiveMemoTable.this.mainTable));
			}
		});

		back.setPosition(216 - back.getWidth() / 2, 30);
		addActor(back);

		back.setPosition(216 - back.getWidth() / 2, 30);
		addActor(back);

		Label[] label = new Label[4];
		for (int i = 0; i < label.length; i++) {
			label[i] = new Label("MEMO " + (i + 1), Assets.title, "TOfont");
			label[i].setColor(Color.BLACK);
		}

		defaults().height(70).center();
		Gdx.app.log("Table", getWidth() + ", " + getHeight());

		if (EdhGame.settings.clearStage[0]) {
			addListener(label[0], 0);
			add(label[0]).row();
		}

		if (EdhGame.settings.clearStage[1]) {
			addListener(label[1], 1);
			add(label[1]).row();
		}

		if (EdhGame.settings.clearStage[2]) {
			addListener(label[2], 2);
			add(label[2]).row();
		}

		if (EdhGame.settings.clearStage[3]) {
			addListener(label[3], 3);
			add(label[3]).row();
		}
	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ

	}

	void addListener(Label label, int num) {
		switch (num) {
		case 0:
			label.addListener(new BaseClickAction(label) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					changeTable(new Memo1Table(ArchiveMemoTable.this.screen,
							ArchiveMemoTable.this.mainTable));
				}
			});
			break;

		case 1:
			label.addListener(new BaseClickAction(label) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					changeTable(new Memo2Table(ArchiveMemoTable.this.screen,
							ArchiveMemoTable.this.mainTable));
				}
			});
			break;

		case 2:
			label.addListener(new BaseClickAction(label) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					changeTable(new Memo3Table(ArchiveMemoTable.this.screen,
							ArchiveMemoTable.this.mainTable));
				}
			});
			break;

		case 3:
			label.addListener(new BaseClickAction(label) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					changeTable(new Memo4Table(ArchiveMemoTable.this.screen,
							ArchiveMemoTable.this.mainTable));
				}
			});
		}
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		changeTable(new MenuTable(ArchiveMemoTable.this.screen,
				ArchiveMemoTable.this.mainTable));
	}
}

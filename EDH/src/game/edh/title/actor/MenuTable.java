package game.edh.title.actor;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;
import game.edh.frame.BaseClickAction;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MenuTable extends BaseTable {
	Label start;
	Label setting;
	Label archive;
	Table table;
	Image Ltitle;

	public MenuTable(BaseScreen screen, Table mainTable) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(screen, mainTable);
		table = new Table();

		TextureRegion logo = new TextureRegion(
				Assets.title.getRegion("titlelogo"));
		Ltitle = new Image(logo);
		Ltitle.setBounds(225f - logo.getRegionWidth() / 2, 382, 325,
				logo.getRegionHeight());
		addActor(Ltitle);

		setBounds(0, 0, screen.getStage().getWidth(), screen.getStage()
				.getHeight());
		setTable();
		addActor(table);
	}

	private void setTable() {
		table.setBounds(0, 0, getWidth(), getHeight() / 2);
		LabelStyle style = Assets.title.get("TOfont", LabelStyle.class);
		start = new Label("S T A R T", style);
		start.setColor(Color.BLACK);
		start.addListener(new BaseClickAction(start) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new StageTable(screen, mainTable));
			}
		});
		table.add(start).height(70);
		table.row();

		setting = new Label("S E T T I N G", style);
		setting.setColor(Color.BLACK);
		setting.addListener(new BaseClickAction(setting) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new SettingTable(screen, mainTable));
			}
		});
		table.add(setting).height(70);
		table.row();

		if (EdhGame.settings.clearStage[0]) {
			archive = new Label("A R C H I V E", style);
			archive.setColor(Color.BLACK);
			archive.addListener(new BaseClickAction(archive) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					changeTable(new ArchiveTable(screen, mainTable));
				}
			});
		}

		table.add(archive).height(70);
	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		Gdx.app.exit();
	}
}

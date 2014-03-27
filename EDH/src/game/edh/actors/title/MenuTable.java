package game.edh.actors.title;

import game.edh.Assets;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;
import game.edh.screen.LoadScreen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuTable extends BaseTable {
	Label start;
	Label setting;
	Label help;
	Table table;
	Image Ltitle;

	public MenuTable(BaseScreen screen, Table mainTable) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(screen, mainTable);
		table = new Table();

		TextureRegion logo = new TextureRegion(Assets.title.getRegion("titlelogo"));
		Ltitle = new Image(logo);
		Ltitle.setBounds(225f - logo.getRegionWidth() / 2, 382, 320, 200);
		addActor(Ltitle);

		setBounds(0, 0, screen.getStage().getWidth(), screen.getStage()
				.getHeight());
		setTable();
		addActor(table);
	}

	private void setTable() {
		table.setBounds(0, 0, getWidth(), getHeight() / 2);
		LabelStyle style = Assets.title.get("black", LabelStyle.class);
		start = new Label("S T A R T", style);
		start.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				start.setStyle(Assets.title.get("cyan", LabelStyle.class));
				changeTable(new StageTable(screen, mainTable));
			}
		});
		table.add(start).height(70);
		table.row();

		setting = new Label("S E T T I N G", style);
		setting.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				setting.setStyle(Assets.title.get("cyan", LabelStyle.class));
				changeTable(new SettingTable(screen, mainTable));
			}
		});
		table.add(setting).height(70);
		table.row();

		help = new Label("H E L P", style);
		help.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				help.setStyle(Assets.title.get("cyan", LabelStyle.class));
				screen.changeScreen(new LoadScreen(screen.getEdh(), LoadScreen.NextScreen.Event));
			}
		});
		table.add(help).height(70);
		table.row();
	}
}

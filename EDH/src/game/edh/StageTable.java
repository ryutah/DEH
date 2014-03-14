package game.edh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;

public class StageTable extends BaseTable {
	Image Slogo;
	Image back;
	Label[] stage = new Label[4];

	public StageTable(EdhGame game, BaseScreen screen, Table mainTable) {
		super(game, screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		setTable();
		setBounds(0, 0, 432, 768);
		setFillParent(true);
	}

	void setTable() {
		TextureRegion logo = new TextureRegion(
				Assets.title.getRegion("stagelogo"));
		Slogo = new Image(logo);
		Slogo.setBounds(225 - logo.getRegionWidth() / 2, 600,
				logo.getRegionWidth(), logo.getRegionHeight());
		addActor(Slogo);

		center();
		for (int i = 0; i < edh.settings.nowStage; i++) {
			stage[i] = new Label("STAGE " + (i + 1), Assets.title.get("black",
					LabelStyle.class));
			stage[i].setAlignment(Align.center);
			add(stage[i]).height(70);
			row();
		}
		stage[0].addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				screen.changeScreen(new LoadScreen(edh, LoadScreen.NextScreen.Batle));
			}
		});

		TextureRegion Blogo = new TextureRegion(Assets.title.getRegion("back"));
		back = new Image(Blogo);
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				back.setColor(Color.CYAN);
				changeTable(new MenuTable(edh, screen, mainTable));
			}
		});
		back.setBounds(216 - Blogo.getRegionWidth() / 2, 60,
				Blogo.getRegionWidth(), Blogo.getRegionHeight());
		back.setColor(Color.BLACK);
		addActor(back);
	}
}

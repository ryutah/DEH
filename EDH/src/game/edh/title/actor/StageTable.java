package game.edh.title.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;
import game.edh.frame.BaseClickAction;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class StageTable extends BaseTable {
	Image Slogo;
	Image back;
	Label[] stage = new Label[4];

	public StageTable(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
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

		LabelStyle style = Assets.title.get("TOfont", LabelStyle.class);
		Label stage1 = new Label("STAGE1", style);
		stage1.setColor(Color.BLACK);
		stage1.setAlignment(Align.center);
		stage1.addListener(new BaseClickAction(stage1) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new StageTitleTable(screen, mainTable, 1));
			}
		});
		add(stage1).height(70).row();

		if (EdhGame.settings.clearStage[0]) {
			Label stage2 = new Label("STAGE2", style);
			stage2.setColor(Color.BLACK);
			stage2.setAlignment(Align.center);
			stage2.addListener(new BaseClickAction(stage2) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					changeTable(new StageTitleTable(screen, mainTable, 2));
				}
			});
			add(stage2).height(70).row();
		}

		if (EdhGame.settings.clearStage[1]) {
			Label stage3 = new Label("STAGE3", style);
			stage3.setColor(Color.BLACK);
			stage3.setAlignment(Align.center);
			stage3.addListener(new BaseClickAction(stage3) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					changeTable(new StageTitleTable(screen, mainTable, 3));
				}
			});
			add(stage3).height(70).row();
		}

		if (EdhGame.settings.clearStage[2]) {
			Label stage4 = new Label("STAGE4", style);
			stage4.setColor(Color.BLACK);
			stage4.setAlignment(Align.center);
			stage4.addListener(new BaseClickAction(stage4) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					changeTable(new StageTitleTable(screen, mainTable, 4));
				}
			});
			add(stage4).height(70).row();
		}

		if (EdhGame.gameData != null) {
			Label cont = new Label("CONTINUE", style);
			cont.setColor(Color.BLACK);
			cont.addListener(new BaseClickAction(cont) {

				@Override
				public void clickAction() {
					// TODO 自動生成されたメソッド・スタブ
					screen.changeScreen(new LoadScreen(screen.getEdh(),
							NextScreen.LOAD));
				}
			});
			add(cont).height(70);
		}

		TextureRegion Blogo = new TextureRegion(Assets.title.getRegion("back"));
		back = new Image(Blogo);
		back.addListener(new BaseClickAction(back) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new MenuTable(screen, mainTable));
			}
		});
		back.setBounds(216 - Blogo.getRegionWidth() / 2, 60,
				Blogo.getRegionWidth(), Blogo.getRegionHeight());
		back.setColor(Color.BLACK);
		addActor(back);
	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		changeTable(new MenuTable(screen, mainTable));
	}
}

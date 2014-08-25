package game.edh.title.actor;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.frame.BaseClickAction;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SettingTable extends BaseTable {
	private Image sLogo;
	private Label sound, save;
	Image back;

	public SettingTable(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		setTable();

		setBounds(0, 0, mainTable.getWidth(), 768);
	}

	private void setTable() {
		setFillParent(true);

		TextureRegion logo = Assets.title.getRegion("settinglogo");
		sLogo = new Image(logo);
		sLogo.setBounds(225f - logo.getRegionWidth() / 2, 600,
				logo.getRegionWidth(), logo.getRegionHeight());
		addActor(sLogo);

		LabelStyle style = new LabelStyle(Assets.title.get("TOfont",
				LabelStyle.class));

		if (EdhGame.settings.sound)
			sound = new Label("SOUND   ON", style);
		else
			sound = new Label("SOUND   OFF", style);

		sound.setColor(Color.BLACK);
		sound.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				clickSound();
			}
		});

		if (EdhGame.settings.autoSave)
			save = new Label("AUTOSAVE  ON", style);
		else
			save = new Label("AUTOSAVE  OFF", style);
		save.setColor(Color.BLACK);
		save.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				clickSave();
			}
		});

		defaults().space(20);

		center().add(sound).height(70);
		row();
		add(save);
		row();

		Label pad = new Label("PadSetting", style);
		pad.setColor(Color.BLACK);
		pad.addListener(new BaseClickAction(pad) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				changeTable(new PadSettingTable(SettingTable.this.screen,
						SettingTable.this.mainTable));
			}
		});
		center().add(pad).height(70);

		TextureRegion Blogo = new TextureRegion(Assets.title.getRegion("back"));
		back = new Image(Blogo);
		back.addListener(new BaseClickAction(back) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				EdhGame.save();
				changeTable(new MenuTable(screen, mainTable));
			}
		});
		back.setBounds(216 - Blogo.getRegionWidth() / 2, 60,
				Blogo.getRegionWidth(), Blogo.getRegionHeight());
		back.setColor(Color.BLACK);
		addActor(back);
	}

	private void clickSound() {
		if (EdhGame.settings.sound) {
			EdhGame.settings.sound = false;
			sound.setText("SOund   OFF");
			EdhGame.music.pauseMusic();
		} else {
			EdhGame.settings.sound = true;
			sound.setText("SOund   ON");
			EdhGame.music.playMusic();
		}
	}

	void clickSave() {
		EdhGame.settings.autoSave = !EdhGame.settings.autoSave;
		if (EdhGame.settings.autoSave)
			save.setText("AUTOSAVE  ON");
		else
			save.setText("AUTOSAVE  OFF");
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

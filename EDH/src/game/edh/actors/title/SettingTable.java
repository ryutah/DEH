package game.edh.actors.title;

import game.edh.Assets;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class SettingTable extends BaseTable {
	private Image sLogo;
	private Label sound;
	private Label vibrate;
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

		LabelStyle style = new LabelStyle(Assets.title.get("black",
				LabelStyle.class));

		if (screen.getEdh().settings.sound)
			sound = new Label("SOUND   ON", style);
		else
			sound = new Label("SOUND   OFF", style);
		sound.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				clickSound();
			}
		});

		if (screen.getEdh().settings.vibrate)
			vibrate = new Label("Vibrate   ON", style);
		else
			vibrate = new Label("Vibrate   OFF", style);
		vibrate.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				clickVibrate();
			}
		});

		center().add(sound).height(70);
		row();
		add(vibrate);
		row();

		TextureRegion Blogo = new TextureRegion(Assets.title.getRegion("back"));
		back = new Image(Blogo);
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				screen.getEdh().save();
				back.setColor(Color.CYAN);
				changeTable(new MenuTable(screen, mainTable));
			}
		});
		back.setBounds(216 - Blogo.getRegionWidth() / 2, 60,
				Blogo.getRegionWidth(), Blogo.getRegionHeight());
		back.setColor(Color.BLACK);
		addActor(back);
	}

	private void clickSound() {
		if (screen.getEdh().settings.sound) {
			screen.getEdh().settings.sound = false;
			sound.setText("SOund   OFF");
			screen.getEdh().music.pauseMusic();
		} else {
			screen.getEdh().settings.sound = true;
			sound.setText("SOund   ON");
			screen.getEdh().music.playMusic();
		}
	}

	private void clickVibrate() {
		if (screen.getEdh().settings.vibrate) {
			screen.getEdh().settings.vibrate = false;
			vibrate.setText("Vibrate   OFF");
		} else {
			screen.getEdh().settings.vibrate = true;
			vibrate.setText("Vibrate   ON");
			Gdx.input.vibrate(100);
		}
	}
}

package game.edh.actors.batle;

import game.edh.Assets;
import game.edh.actors.games.HPBar;
import game.edh.frame.BatleScreen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class StatusGroup extends Table {
	HPBar hpbar;
	ClearBar clearbar;
	Image hp;
	Image clear;
	Label pause;
	
	BatleGroup group;
	BatleScreen screen;

	public StatusGroup(BatleGroup group, BatleScreen screen) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.group = group;
		this.screen = screen;
		
		initActors();
		pause.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				StatusGroup.this.screen.pause();
			}
		});
	}
	
	private void initActors() {
		hpbar = new HPBar(group);
		clearbar = new ClearBar(group);

		TextureRegion hpRegion = Assets.batle.getRegion("hpwaku");
		hp = new Image(hpRegion);
		TextureRegion clearRegion = Assets.batle.getRegion("clearwaku");
		clear = new Image(clearRegion);

		setBounds(0, 0, 432, 150);

		int hpWidth = hpRegion.getRegionWidth();
		int hpHeight = hpRegion.getRegionHeight();
		hp.setOrigin(10 + hpWidth / 2 - 8, 20 + hpHeight / 2);
		hp.setBounds(hp.getOriginX() - hpWidth / 2 , hp.getOriginY() - hpHeight
				/ 2, hpWidth, hpHeight);

		int clearWidth = clearRegion.getRegionWidth();
		int clearHeight = clearRegion.getRegionHeight();
		clear.setOrigin(getWidth() / 2, getHeight() - clearHeight - 2);
		clear.setBounds(clear.getOriginX() - clearWidth / 2, clear.getOriginY()
				- clearHeight / 2, clearWidth, clearHeight);

		hpbar.setPosition(hp.getOriginX() - hpbar.getWidth() / 2,
				hp.getOriginY() - hpbar.getHeight() / 2);
		clearbar.setPosition(clear.getOriginX() - clearbar.getWidth() / 2,
				clear.getOriginY() - clearbar.getHeight() / 2);
		
		pause = new Label("PAUSE", Assets.title.get("black", LabelStyle.class));
		
		addActor(hp);
		addActor(hpbar);
		addActor(clear);
		addActor(clearbar);
		bottom().right().add(pause).pad(13);
	}
}

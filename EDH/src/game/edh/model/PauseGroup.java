package game.edh.model;

import game.edh.Assets;
import game.edh.LoadScreen;
import game.edh.LoadScreen.NextScreen;
import game.edh.frame.GameScreen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class PauseGroup extends Group {
	Image pause;
	Image pauseMenu;
	Label saikai;
	Label title;
	Table table;
	
	GameScreen screen;
	
	private boolean hide;

	public PauseGroup(GameScreen screen) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.screen = screen;
		
		getColor().a = 0;
		setOrigin(216, 384);
		initActors();

		
		saikai = new Label("再 開",
				Assets.title.get("mikachan", LabelStyle.class));
		title = new Label("タイトルへ", Assets.title.get("mikachan",
				LabelStyle.class));

		
		table = new Table();
		table.setBounds(pauseMenu.getX(), pauseMenu.getY(),
				pauseMenu.getWidth(), pauseMenu.getHeight());
		table.add(saikai);
		table.row();
		table.add(title);
	}
	
	private void initActors() {
		TextureRegion pRegion = Assets.title.getRegion("pausemenu");
		pauseMenu = new Image(pRegion);

		TextureRegion pauseR = Assets.batle.getRegion("pause");
		pause = new Image(pauseR);
		pauseMenu.setBounds(0, 0, pRegion.getRegionWidth(),
				pRegion.getRegionHeight());

		pause.setOrigin(216,
				384 + pauseMenu.getHeight() / 2 + pauseR.getRegionHeight() / 2
						+ 20);
		pause.setBounds(pause.getOriginX() - pauseR.getRegionWidth() / 2,
				pause.getOriginY() - pauseR.getRegionHeight() / 2,
				pauseR.getRegionWidth(), pauseR.getRegionHeight());

		setBounds(getOriginX() - pauseMenu.getWidth() / 2, getOriginY()
				- pauseMenu.getHeight() / 2, pauseMenu.getWidth(),
				pauseMenu.getHeight() + pause.getHeight() + 50);
		
		addActor(table);
		textAddListener();
		
		setTouchable(Touchable.disabled);
	}
	
	private void textAddListener() {
		saikai.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				hide();
			}
		});
		
		title.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				screen.changeScreen(new LoadScreen(screen.getEdh(), NextScreen.Title));
			}
		});
	}
	
	public void show() {
		hide = false;
		addAction(sequence(fadeIn(1.0f), run(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				setTouchable(Touchable.enabled);
			}
		})));
	}
	
	private void hide() {
		setTouchable(Touchable.disabled);
		addAction(sequence(fadeOut(1.0f), run(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				hide = true;
			}
		})));
		remove();
	}
	
	public boolean isHide() {
		return hide;
	}
}

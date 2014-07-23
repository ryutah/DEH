package game.edh.frame;

import game.edh.EdhGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public abstract class BaseScreen implements Screen {
	protected EdhGame edh;
	protected Stage stage;
	protected Table mainTable;
	protected int music;
	BaseScreen next;
	boolean countinueMusic;

	public BaseScreen(EdhGame game) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.edh = game;
		stage = EdhGame.stage;

		music = -1;

		mainTable = new Table();
		mainTable.setBounds(0, 0, 432, 768);
		mainTable.setTouchable(Touchable.disabled);
		mainTable.getColor().a = 0;

		stage.addActor(mainTable);

	}

	public void screenOff() {
		mainTable.setTouchable(Touchable.disabled);
		mainTable.addAction(sequence(fadeOut(1.0f), run(new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				edh.setScreen(next);
			}
		})));
	}

	public void screenOn() {
		mainTable.addAction(sequence(fadeIn(1.0f), run(new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				mainTable.setTouchable(Touchable.enabled);
				showScreen();
			}
		})));
	}
	
	public void countinueMusic() {
		countinueMusic = true;
	}

	public void changeScreen(BaseScreen screen) {
		screenOff();
		next = screen;
		if (!countinueMusic)
			EdhGame.music.stopMusic();
	}

	public void showScreen() {
		EdhGame.music.playMusic();
	}

	public EdhGame getEdh() {
		return edh;
	}

	public Stage getStage() {
		return stage;
	}

	public void setMusic(int music) {
		this.music = music;
		EdhGame.music.changeMusic(music);
	}

	public abstract void backPress();

	@Override
	public abstract void render(float delta);

	@Override
	public abstract void resize(int width, int height);

	@Override
	public void show() {
		screenOn();
	}

	@Override
	public void hide() {
		mainTable.remove();
	}

	@Override
	public abstract void pause();

	@Override
	public abstract void resume();

	@Override
	public void dispose() {
		Gdx.app.log("Screen", "dispose");
		edh.setScreen(null);
	}
}

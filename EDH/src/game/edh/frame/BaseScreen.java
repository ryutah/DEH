package game.edh.frame;

import game.edh.Assets;
import game.edh.EdhGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public abstract class BaseScreen implements Screen {
	 protected EdhGame edh;
	 protected Stage stage;
	 protected Table mainTable;
	 protected int music;
	 
	 private boolean isFade = false;

	public BaseScreen(EdhGame game, float stageWidth, float stageHeight) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.edh = game;
		stage = new Stage();
		stage.setViewport(stageWidth, stageHeight);
		Gdx.app.log("Stage", "" + stage.getWidth());
		
		music = -1;
		
		mainTable = new Table();
		mainTable.setBounds(0, 0, stageWidth, stageHeight);
		Gdx.app.log("Maintable", "" + mainTable.getWidth());
		mainTable.setTouchable(Touchable.disabled);
		mainTable.getColor().a = 0;

		stage.addActor(mainTable);
		Gdx.input.setCatchBackKey(true);
		stage.addListener(new InputListener() {
			@Override
			public boolean keyUp(InputEvent event, int keycode) {
				// TODO 自動生成されたメソッド・スタブ
				if(keycode == Keys.BACK)
					backPress();
			
				return false;
			}
		});

		Gdx.input.setInputProcessor(stage);
	}

	public void screenOff() {
		isFade = true;
		
		//if(music != -1)
		
		mainTable.setTouchable(Touchable.disabled);
		mainTable.addAction(sequence(fadeOut(1.0f), run(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				isFade = false;
			}
		})));
	}

	public void screenOn() {
		isFade = true;
		
		if(music != -1)
			edh.music.changeMusic(music);
		
		mainTable.addAction(sequence(fadeIn(1.0f),
				run(new Runnable() {

					@Override
					public void run() {
						// TODO 自動生成されたメソッド・スタブ
						mainTable.setTouchable(Touchable.enabled);
						isFade = false;
						edh.music.playMusic();
					}
				})));
	}
	
	public void changeScreen(BaseScreen screen) {
		screenOff();
		edh.setNextScreen(screen);
	}
	
	public EdhGame getEdh() {
		return edh;
	}
	
	public boolean isFade() {
		return isFade;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public void setMusic(int music) {
		this.music = music;
	}
	
	public abstract void backPress();

	@Override
	public abstract void render(float delta);

	@Override
	public abstract void resize(int width, int height);

	@Override
	public void show(){
		screenOn();
	}

	@Override
	public void hide() {
		
	}

	@Override
	public abstract void pause();

	@Override
	public abstract void resume();

	@Override
	public void dispose() {
		Gdx.app.log("Screen", "dispose");
		Assets.dispose();
		Assets.music.dispose();
		stage.dispose();
	}
}

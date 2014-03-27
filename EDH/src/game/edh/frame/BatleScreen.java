package game.edh.frame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.actors.batle.BatleGroup;
import game.edh.actors.batle.PauseGroup;
import game.edh.actors.batle.StatusGroup;
import game.edh.screen.TitleScreen;

public abstract class BatleScreen extends BaseScreen {

	enum GameState {
		RESUME, READY, RUNNING, PAUSE, GAMEOVER, STAGECLEAR
	}

	public GameState state;
	int nowCombo;

	Image batleBack;
	Image ready;
	Label combo;
	protected BatleGroup group;
	protected StatusGroup status;

	PauseGroup pauseGroup;

	public BatleScreen(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		state = GameState.RESUME;

		initGame();

		mainTable.setTouchable(Touchable.disabled);
		mainTable.addActor(group);
		
		TextureRegion backImage = Assets.batle.getRegion("batleback");
		batleBack = new Image(backImage);
		batleBack.setBounds(0, 0, stageWidth, stageHeight);
		batleBack.setTouchable(Touchable.disabled);
		mainTable.addActor(batleBack);
		
		mainTable.addActor(status);

		TextureRegion readyImage = Assets.batle.getRegion("ready");
		int readyW = readyImage.getRegionWidth();
		int readyH = readyImage.getRegionHeight();
		ready = new Image(readyImage);
		ready.setOrigin(stageWidth / 2, stageHeight / 2);
		ready.setBounds(ready.getOriginX() - readyW / 2, ready.getOriginY()
				- readyH / 2, readyW, readyH);
		ready.setTouchable(Touchable.disabled);
		ready.getColor().a = 0;
		mainTable.addActor(ready);

		combo = new Label("", Assets.title.get("black", LabelStyle.class));
		mainTable.top().add(combo).right().pad(20f);

		pauseGroup = new PauseGroup(this);

		nowCombo = 0;
	}

	/**
	 * GameGroupインスタンス、StatusGroupインスタンス生成等の初期設定をし、 mainTableにActorとして登録する。
	 */
	public abstract void initGame();

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		switch (state) {
		case RESUME:
			updateResume();
			break;

		case READY:
			updateReady();
			break;

		case PAUSE:
			updatePause();
			break;

		case GAMEOVER:
			updateGameOver();
			break;

		case STAGECLEAR:
			updateStageClear();
			break;

		case RUNNING:
			updateRunning();
			break;
		}

		stage.act();
		stage.draw();
	}

	public void updateResume() {
		if (!isFade()) {
			state = GameState.READY;
			mainTable.addActor(ready);
		}
	}

	public void updateReady() {
		if (ready.getActions().size == 0) {
			ready.addAction(sequence(fadeIn(0.5f), delay(0.5f), fadeOut(0.5f),
					run(new Runnable() {

						@Override
						public void run() {
							// TODO 自動生成されたメソッド・スタブ
							state = GameState.RUNNING;
							ready.clearActions();
							group.run();
							mainTable.removeActor(ready);
						}
					})));
		}
	}

	public void updatePause() {
		if (pauseGroup.isHide()) {
			mainTable.addActor(ready);
			state = GameState.READY;
		}
	}

	public void updateRunning() {
		if (group.checkClear())
			state = GameState.STAGECLEAR;
		if (group.checkGameOver())
			state = GameState.GAMEOVER;
	}

	public void updateGameOver() {
		changeScreen(new TitleScreen(edh, 432, 768));
	}

	public void updateStageClear() {
		changeScreen(new TitleScreen(edh, 432, 768));
		Gdx.app.log("STAGECLEAR", "");
	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ
		super.hide();
	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ
		group.pause();
		mainTable.addActor(pauseGroup);
		pauseGroup.show();
		state = GameState.PAUSE;
	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}
	
	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		pause();
	}

}

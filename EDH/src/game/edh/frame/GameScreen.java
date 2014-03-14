package game.edh.frame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.model.PauseGroup;
import game.edh.model.StatusGroup;

public abstract class GameScreen extends BaseScreen {

	enum GameState {
		RESUME, READY, RUNNING, PAUSE, GAMEOVER, STAGECLEAR
	}

	public GameState state;
	int nowCombo;

	Image batleBack;
	Image ready;
	Label combo;
	GameGroup group;
	StatusGroup status;

	PauseGroup pauseGroup;

	public GameScreen(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		state = GameState.RESUME;

		initGame();

		TextureRegion backImage = Assets.batle.getRegion("batleback");
		batleBack = new Image(backImage);
		batleBack.setBounds(0, 0, stageWidth, stageHeight);
		batleBack.setTouchable(Touchable.disabled);
		mainTable.addActor(batleBack);

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

	}

	public void updateStageClear() {

	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ
		group.pause();
		state = GameState.PAUSE;
		mainTable.addActor(pauseGroup);
		pauseGroup.show();
	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}

}

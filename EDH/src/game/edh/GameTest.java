package game.edh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.edh.frame.BaseScreen;
import game.edh.model.HPBar;

public class GameTest extends BaseScreen {
	public final int READY = 0;
	public final int RUNNING = 1;
	public final int PAUSE = 2;
	public final int RESUME = 3;
	
	int type;

	public volatile boolean isPause;

	Table table;
	Image backImage;
	Label enemy;
	GameTestGroup gGroup;
	//HPbar hp;
	Image hpbar;
	Label back;
	Label combo;
	Label resume;
	Label pause;
	Label pauseButtun;
	public int nowcombo = 0;
	private float stateTime = 0;

	float eHP;
	float pHP;

	public GameTest(EdhGame game, float stageWidth, float stageHeight) {
		super(game, stageWidth, stageHeight);
		// TODO 自動生成されたコンストラクター・スタブ
		gGroup = new GameTestGroup();
		mainTable.addActor(gGroup);

		backImage = new Image(Assets.batle.getDrawable("batleback"));
		backImage.setBounds(0, 0, 432, 768);
		backImage.setTouchable(Touchable.disabled);
		mainTable.addActor(backImage);

		combo = new Label("Test", Assets.title.get("black", LabelStyle.class));
		mainTable.top().left().add(combo);

		back = new Label("BACK", Assets.title.get("black", LabelStyle.class));
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				changeScreen(new LoadScreen(edh, LoadScreen.NextScreen.Title));
			}
		});
		mainTable.top().add(back).right();

		resume = new Label("READY", Assets.title.get("black", LabelStyle.class));
		resume.setVisible(false);
		mainTable.addActor(resume);
		pause = new Label("PAUSE", Assets.title.get("black", LabelStyle.class));
		pause.setVisible(false);
		pause.setBounds(100, 300, 200, 100);
		mainTable.addActor(pause);
		pause.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				type = READY;
				isPause = false;
				pause.setVisible(false);
			}
		});

		table = new Table();
		//table.setBackground(Assets.event.getDrawable("waku"));
		table.setBounds(0, 0, 432, 150);

		eHP = gGroup.getEnemyHP();
		pHP = gGroup.getHP();

		enemy = new Label("" + gGroup.getEnemyHP(), Assets.title.get("mikachan",
				LabelStyle.class));
		table.top().add(enemy);
		table.row();
		
		TextureRegion hp = Assets.batle.getRegion("hpwaku");
		hpbar = new Image(hp);
		hpbar.setBounds(10, 20, hp.getRegionWidth(), hp.getRegionHeight());
		table.addActor(hpbar);

		pauseButtun = new Label("PAUSE", Assets.title.get("black",
				LabelStyle.class));
		pauseButtun.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				if (GameTest.this.type != PAUSE) {
					pause();
					// isPause = true;
					// type = PAUSE;
					// gGroup.pause();
				}
			}
		});

		table.add(pauseButtun);

		mainTable.addActor(table);

		type = RESUME;
	}

	@Override
	public void render(float delta) {
		switch (type) {
		case PAUSE:
			updatePause(delta);
			break;

		case READY:
			updateReady(delta);
			break;
			
		case RESUME:
			updateResume(delta);
			break;

		case RUNNING:
			updateRunning(delta);
			break;
		}

		stage.act();
		
		stage.draw();
	}

	public void updateReady(float delta) {
		//stateTime = 0;
		Gdx.app.log("READY", "");
		resume.setVisible(true);
		resume.setBounds(100, 300, 200, 100);
		resume.addAction(Actions.sequence(Actions.delay(1.0f),
				Actions.moveTo(-250, 300, 1.2f), Actions.run(new Runnable() {

					@Override
					public void run() {
						// TODO 自動生成されたメソッド・スタブ
						isPause = false;
						type = RUNNING;
						gGroup.run();
						resume.clearActions();
						resume.setVisible(false);
					}
				})));
	}
	
	public void updateResume(float delta) {
		if(!isFade())
			type = READY;
	}

	public void updatePause(float delta) {
		Gdx.app.log("Pause", "" + type);
		pause.setVisible(true);
		//pause.setBounds(100, 300, 200, 100);
		// gGroup.pause();

		// type = PAUSE;
		// gGroup.pause();

		
//		stateTime += delta;
//		if(stateTime >= .3f)
//			stage.act();
	}

	public void updateRunning(float delta) {
		// Gdx.app.log("RUNNGING", "" + type);
		if (nowcombo != GameTestGroup.combo) {
			nowcombo = GameTestGroup.combo;
			if (nowcombo == 0)
				combo.setText("");
			else
				combo.setText("COMBO " + nowcombo);
		}

		if (eHP != gGroup.getEnemyHP()) {
			eHP = gGroup.getEnemyHP();
			enemy.setText("" + eHP);
		}

		if (gGroup.gameOver)
			changeScreen(new LoadScreen(edh, LoadScreen.NextScreen.Title));
		
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
		type = PAUSE;
		gGroup.pause();
	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}

}

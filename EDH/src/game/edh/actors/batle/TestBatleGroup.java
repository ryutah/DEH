package game.edh.actors.batle;

import game.edh.Assets;
import game.edh.actors.batle.TestEnemyEvent.AtackEvent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestBatleGroup extends Group {
	public final float WIDTH = 10.8f;
	public final float HEIGHT = 19.2f;
	
	public final int PAUSE = 0;
	public final int RUNNING = 1;
	public int state;

	OrthographicCamera cam;
	Matrix4 matrix;

	Image back;
	TestPlayer player;
	TestEnemyActor enemy;
	TestEnemyActor enemy2;
	Vector3 v3;

	public boolean gameOver;

	private volatile boolean running;

	public final float scaleX = Gdx.graphics.getWidth() / 432f;
	public final float scaleY = Gdx.graphics.getHeight() / 768f;

	public static int combo = 0;

	public TestBatleGroup() {
		// TODO 自動生成されたコンストラクター・スタブ
		gameOver = false;
		setBounds(0, 0, WIDTH, HEIGHT);

		back = new Image(Assets.batle.getRegion("spring2"));
		back.setBounds(0, 0, 10.8f, 19.2f);
		addActor(back);
		setBounds(0, 0, 10.8f, 19.2f);

		cam = new OrthographicCamera();
		cam.setToOrtho(false, WIDTH, HEIGHT);
		cam.update();

		v3 = new Vector3();

		matrix = new Matrix4();

		enemy = new TestEnemyActor().init(10.8f / 432f);
		addActor(enemy);
		player = new TestPlayer();
		enemy2 = new TestEnemyActor().init(10.8f / 432f);
		addActor(enemy2);

		addListener(new EventListener() {

			@Override
			public boolean handle(Event event) {
				// TODO 自動生成されたメソッド・スタブ
				if (event instanceof AtackEvent) {
					player.nowHP -= ((AtackEvent) event).getDamege();
					if (player.nowHP <= 0)
						gameOver = true;
				}
				return false;
			}
		});

		running = false;
		//state = PAUSE;
	}

	public static void addCombo() {
		combo++;
	}

	public int getCombo() {
		return combo;
	}

	public float getEnemyHP() {
		return enemy.nowHP;
	}

	public float getHP() {
		return player.nowHP;
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (running) {
			cam.update();
			super.act(delta);
		}
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
		// TODO 自動生成されたメソッド・スタブ
		v3.set(x * scaleX, Gdx.graphics.getHeight() - (y * scaleY), 0);
		cam.unproject(v3);
		// Gdx.app.log("Touch", v3.x + "," + v3.y);
		return super.hit(v3.x, v3.y, touchable);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		matrix.set(batch.getProjectionMatrix());
		batch.setProjectionMatrix(cam.combined);
		super.draw(batch, parentAlpha);
		batch.setProjectionMatrix(matrix);
		//Gdx.app.log("RUNNING", "" + running);
	}

	public void run() {
		setTouchable(Touchable.enabled);
		running = true;
		//state = RUNNING;
	}

	public void pause() {
		setTouchable(Touchable.disabled);
		running = false;
		//state = PAUSE;
		//Gdx.app.log("Pause", running + "");
	}
}

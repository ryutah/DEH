package game.edh.frame;

import game.edh.model.Efect;
import game.edh.model.Enemy;
import game.edh.model.Player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Pool;

/**
 * init()をオーバーライドして、backに背景を設定する
 * clearFlagを設定し、clearCountを減らすロジックを決定する。
 * 通常バトルの際は、enemyDownでclearCount--を追加する
 * @author ryuta
 *
 */
public abstract class GameGroup extends Group{
	public final float WORLD_X = 0.1f;
	public final float WORLD_Y = 3.3f;
	public final float WORLD_WIDTH = 10.6f;
	public final float WORLD_HEIGHT = 14f;
	
	public float scale = 10.8f / 432f;
	
	protected float clearFlag;
	private float clearCount;
	
	OrthographicCamera cam;
	Matrix4 matrix;
	Vector3 v3;
	Player player;
	Pool<Enemy> enemyPool;
	Pool<Efect> efectPool;
	
	private int nowCombo;
	private boolean running;
	
	protected Image back;
	
	/**
	 * 拡張クラスでclearFlagを設定する。
	 */
	public GameGroup() {
		// TODO 自動生成されたコンストラクター・スタブ
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 10.8f, 19.2f);
		cam.update();
		
		enemyPool = new Pool<Enemy>() {
			
			@Override
			protected Enemy newObject() {
				// TODO 自動生成されたメソッド・スタブ
				return new Enemy(enemyPool);
			}
		};
		efectPool = new Pool<Efect>() {
			
			@Override
			protected Efect newObject() {
				// TODO 自動生成されたメソッド・スタブ
				return new Efect(efectPool);
			}
		};
		
		matrix = new Matrix4();
		v3 = new Vector3();
		
		back = new Image();
	}
	
	/**
	 * 拡張クラスにbackに背景イメージの設定
	 * @return
	 */
	public GameGroup init() {
		setBounds(0, 0, 10.8f, 19.2f);
		// backに背景を設定する
		back.setBounds(0, 0, 10.8f, 19.2f);
		player = new Player().init();
		
		clearCount = clearFlag;
		nowCombo = 0;
		running = false;
		return this;
	}
	
	public void run() {
		setTouchable(Touchable.enabled);
		running = true;
	}
	
	public void pause() {
		setTouchable(Touchable.disabled);
		running = false;
	}
	
	@Override
	public Actor hit(float x, float y, boolean touchable) {
		// TODO 自動生成されたメソッド・スタブ
		v3.set(x * scale, Gdx.graphics.getHeight() - (y * scale), 0);
		cam.unproject(v3);
		return super.hit(v3.x, v3.y, touchable);
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(running) {
			enemyGen(delta);
			player.update(delta);
			super.act(delta);
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		matrix.set(batch.getProjectionMatrix());
		batch.setProjectionMatrix(cam.combined);
		super.draw(batch, parentAlpha);
		batch.setProjectionMatrix(matrix);
	}
	
	public void playerDamege(float damege) {
		// エフェクト鳴らす
		player.damege(damege);
		nowCombo = 0;
	}
	
	public float getPlayerAtack() {
		return player.getAtack();
	}
	
	public float getPlayerHp() {
		return player.getHp();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void enemyDamege(Enemy enemy) {
		nowCombo = 0;
		// エフェクト鳴らす
		addActor(efectPool.obtain().init(enemy, Efect.HIT));
	}
	
	public void justHit(Enemy enemy) {
		nowCombo++;
		//　エフェクト鳴らす
		addActor(efectPool.obtain().init(enemy, Efect.JUST));
	}
	
	public void enemyDown(float originX, float originY) {
		if(MathUtils.random() > 0.9f) {
			// アイテム生成
		}
	}
	
	public float getClearFlag() {
		return clearFlag;
	}
	
	public float getClearCount() {
		return clearCount;
	}
	
	public int getCombo() {
		return nowCombo;
	}
	
	public boolean checkClear() {
		return clearCount >= clearFlag;
	}
	
	public boolean checkGameOver() {
		return player.getHp() <= 0;
	}
	
	/**
	 * Enemy生成アルゴリズム設定する
	 * @param delta
	 */
	public abstract void enemyGen(float delta);
}

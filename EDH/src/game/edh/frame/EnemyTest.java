package game.edh.frame;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public abstract class EnemyTest {
	public float width;
	public float height;
	
	public Vector2 position;
	public Vector2 origin;
	Vector2 speed;
	
	public final int ATACK;
	public final int MAX_HP;
	
	public float stateTime = 0f;
	public float moveTime = 1.0f;
	public float atackTime = 0;
	public float atackDem = MathUtils.random(0.8f, 1.4f);
	
	public EnemyTest(int hp, int atack) {
		// TODO 自動生成されたコンストラクター・スタブ
		position = new Vector2();
		origin = new Vector2();
		speed = new Vector2();
		
		this.ATACK = atack;
		this.MAX_HP = hp;
	}
	
	/**
	 * atackに各キャラに応じた値を設定する。
	 */
	protected abstract void setAtack();
	
	/**
	 * hpに書くキャラに応じた値を設定する。
	 */
	protected abstract void setHP();
	
	private void move() {
		speed.set(MathUtils.random() * 2.0f, MathUtils.random() * 2.0f);
		position.add(speed);
		origin.add(speed);
	}
	
	public void setPosition(float x, float y) {
		this.position.set(x, y);
		this.origin.set(x + width / 2, y + height / 2);
	}
	
	public void update(float delta) {
		
	}
}

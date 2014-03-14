package game.edh.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Pool;

public class Efect extends Image {
	public static final int HIT = 0;
	public static final int JUST = 1;
	
	private int efectType;
	private float stateTime;
	private Sprite efect;
	Pool<Efect> efectPool;
	
	Enemy enemy;
	
	public Efect(Pool<Efect> efectPool) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.efectPool = efectPool;
	}

	public Efect init(Enemy enemy, int type) {
		this.enemy = enemy;
		this.efectType = type;
		move();
		
		switch (efectType) {
		case HIT:
			//通常ヒット時のエフェクト
			break;
			
		case JUST:
			//ジャストヒット時のエフェクト
			break;
		}

		stateTime = 0;
		return this;
	}

	private void move() {
		setPosition(enemy.getOriginX() - getWidth() / 2, enemy.getOriginY()
				- getHeight() / 2);
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		stateTime += delta;
		if (stateTime >= 0.3f) {
			remove();
			efectPool.free(this);
		}
		move();
		
		super.act(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		efect.setBounds(getX(), getY(), getWidth(), getHeight());
		efect.setOrigin(getOriginX(), getOriginY());
		efect.draw(batch);
		super.draw(batch, parentAlpha);
	}
}

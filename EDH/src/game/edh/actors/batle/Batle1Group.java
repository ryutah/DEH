package game.edh.actors.batle;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import game.edh.Assets;
import game.edh.actors.batle.Enemy.EnemyType;

public class Batle1Group extends BatleGroup {
	float enemyGenTime;
	float stateTime;
	
	public Batle1Group() {
		// TODO 自動生成されたコンストラクター・スタブ
		super();
		clearFlag = 60;
		enemyGenTime = 3f;
	}
	
	@Override
	public BatleGroup init() {
		// TODO 自動生成されたメソッド・スタブ
		back = new Image(Assets.batle.getRegion("spring1"));
		stateTime = 0;
		return super.init();
	}
	
	@Override
	public void enemyDown(float originX, float originY) {
		// TODO 自動生成されたメソッド・スタブ
		super.enemyDown(originX, originY);
		clearCount--;
	}

	@Override
	public void enemyGen(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		stateTime += delta;
		if(stateTime >= enemyGenTime && getChildren().size < 10) {
			float rand = MathUtils.random();
			if(rand <= 0.3f)
				addActor(enemyPool.obtain().init(EnemyType.Mouse, this));
			else if(rand <= 0.6f)
				addActor(enemyPool.obtain().init(EnemyType.Obake, this));
			else
				addActor(enemyPool.obtain().init(EnemyType.Fly, this));
			
			stateTime = 0;
		}
	}

}

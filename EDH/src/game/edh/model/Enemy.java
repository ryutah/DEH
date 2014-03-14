package game.edh.model;

import game.edh.Assets;
import game.edh.frame.GameGroup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Pool;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Enemy extends Actor {
	private Sprite enemy;

	private float worldX, worldY, worldWidth, worldHeight;

	private float hp;
	private float atack;

	private final float DEFAULT_SCALE = 0.55f;
	private float scale;

	private float ATACK_TIME;
	private float stateTime = 0;
	private float atackDelay;
	private boolean nowAtack;

	private Color init;
	Pool<Enemy> enemyPool;
	GameGroup group;

	public enum EnemyType {
		Pumpkin
	}

	public Enemy(Pool<Enemy> enemyPool) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.enemyPool = enemyPool;

		addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO 自動生成されたメソッド・スタブ
				if (atackDelay <= .3f) {
					group.justHit(Enemy.this);
					justDamege();
				} else {
					group.enemyDamege(Enemy.this);
					damege();
				}

				return false;
			}
		});
		scale = (10.2f / 432f) * DEFAULT_SCALE;
	}

	public Enemy init(EnemyType eType, GameGroup group) {
		this.group = group;

		switch (eType) {
		case Pumpkin:
			enemy = Assets.batle.getSprite("enemy");

			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			atackDelay = MathUtils.random(1.2f, 1.5f);
			atack = 5f;
			hp = 100f;

			init = new Color(Color.YELLOW);
			break;
		}

		nowAtack = false;
		stateTime = 0;
		setColor(init);
		initBounds();

		return this;
	}

	protected void initBounds() {
		float width = enemy.getRegionWidth() * scale;
		float height = enemy.getRegionHeight() * scale;
		float x = MathUtils.random(worldX, worldWidth - width);
		float y = MathUtils.random(worldY, worldHeight - height);

		setBounds(x, y, width, height);
		setOrigin(getX() + getWidth() / 2, getY() + getHeight() / 2);
	}

	protected void move() {
		if (getActions().size == 0) {
			float x = MathUtils
					.random(worldX, worldX + worldWidth - getWidth());
			float y = MathUtils.random(worldHeight, worldY + worldHeight
					- getHeight());
			float time = MathUtils.random(2.0f, 2.5f);

			addAction(moveTo(x, y, time));
		}
	}

	private void damege() {
		hp -= group.getPlayerAtack();
		checkHp();
	}

	private void justDamege() {
		if (group.getCombo() >= 10) {
			hp -= group.getPlayerAtack() * 10;
		} else {
			hp -= group.getPlayerAtack() * group.getCombo();
		}
		stateTime = 0;
		nowAtack = false;
		setColor(init);
		// 攻撃準備エフェクト停止

		checkHp();
	}

	private void checkHp() {
		if (hp <= 0) {
			group.enemyDown(getOriginX(), getOriginY());
			remove();
			enemyPool.free(this);
		}
	}

	protected void atack() {
		nowAtack = true;
		atackDelay -= Gdx.graphics.getDeltaTime();
		if (atackDelay <= 0) {
			group.playerDamege(atack * MathUtils.random(0.7f, 1.1f));
			setColor(init);
			stateTime = 0;
			nowAtack = false;
		}
	}

	public float getAtack() {
		return atack * MathUtils.random(0.7f, 1.1f);
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		move();
		stateTime += delta;
		if (stateTime >= ATACK_TIME) {
			if (!nowAtack) {
				addAction(color(Color.RED, atackDelay));
				// 攻撃準備エフェクトを鳴らす
			}
			atack();
		}
		setOrigin(getX() + getWidth() / 2, getY() + getWidth() / 2);

		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		enemy.setBounds(getX(), getY(), getWidth(), getHeight());
		enemy.setOrigin(getOriginX(), getOriginY());
		enemy.setColor(getColor());
		enemy.draw(batch);
		super.draw(batch, parentAlpha);
	}
}

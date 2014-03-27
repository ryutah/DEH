package game.edh.actors.batle;

import game.edh.Assets;

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

	private final float DEFAULT_SCALE = 1.3f;
	private float scale;

	private float ATACK_TIME;
	private float stateTime = 0;
	private float atackDelay;
	private boolean nowAtack;

	private Color init;
	Pool<Enemy> enemyPool;
	BatleGroup group;

	public enum EnemyType {
		Pumpkin, Bat, Bear, Bug, Fly, Gost, Mouse, Mush, Obake, Spiar, Wolf, Wood
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

	public Enemy init(EnemyType eType, BatleGroup group) {
		this.group = group;

		switch (eType) {
		case Pumpkin:
			enemy = Assets.batle.getSprite("enemy");

			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;
			
			ATACK_TIME = MathUtils.random(1.2f, 1.5f);

			atack = 5f;
			hp = 100f;

			init = new Color(Color.ORANGE);
			break;
			
		case Bat:
			enemy = Assets.batle.getSprite("bat");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT / 2;
			worldX = group.WORLD_X;
			worldY = worldHeight;
			
			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 3f;
			hp = 50f;
			
			init = new Color(Color.DARK_GRAY);
			break;
			
		case Bear:
			enemy = Assets.batle.getSprite("bear");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT / 3;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;
			
			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 10f;
			hp = 150f;
			
			init = new Color(Color.BLUE);
			break;
			
		case Bug:
			enemy = Assets.batle.getSprite("bug");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT / 2;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;
			
			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 8f;
			hp = 80f;
			
			init = new Color(Color.ORANGE);
			break;
			
		case Fly:
			enemy = Assets.batle.getSprite("fly");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 5f;
			hp = 30f;

			init = new Color(Color.DARK_GRAY);
			break;
			
		case Gost:
			enemy = Assets.batle.getSprite("gost");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT / 2;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 5f;
			hp = 100f;

			init = new Color(Color.ORANGE);
			break;
			
		case Mouse:
			enemy = Assets.batle.getSprite("mouse");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT / 3;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 3f;
			hp = 30f;

			init = new Color(Color.CYAN);
			break;
			
		case Mush:
			enemy = Assets.batle.getSprite("mush");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT / 3;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 5f;
			hp = 100f;

			init = new Color(Color.ORANGE);
			break;
			
		case Obake:
			enemy = Assets.batle.getSprite("obake");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 5f;
			hp = 100f;

			init = new Color(Color.CYAN);
			break;
			
		case Spiar:
			enemy = Assets.batle.getSprite("spiar");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 5f;
			hp = 100f;

			init = new Color(Color.YELLOW);
			break;
			
		case Wolf:
			enemy = Assets.batle.getSprite("wolf");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT / 3;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 5f;
			hp = 100f;

			init = new Color(Color.BLUE);
			break;
			
		case Wood:
			enemy = Assets.batle.getSprite("wood");
			
			worldWidth = group.WORLD_WIDTH;
			worldHeight = group.WORLD_HEIGHT / 3;
			worldX = group.WORLD_X;
			worldY = group.WORLD_Y;

			ATACK_TIME = MathUtils.random(1.2f, 1.5f);
			atack = 5f;
			hp = 100f;

			init = new Color(Color.GREEN);
			break;
		}

		nowAtack = false;
		atackDelay = 0.8f;
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
		Gdx.app.log("Damege", group.getPlayerAtack() + "");
		checkHp();
	}

	private void justDamege() {
		if (group.getCombo() >= 30) {
			hp -= group.getPlayerAtack() * 30 * 5;
		} else {
			hp -= group.getPlayerAtack() * group.getCombo() * 5;
		}
		stateTime = 0;
		atackDelay = 0.8f;
		nowAtack = false;
		clearActions();
		setColor(init);
		// 攻撃準備エフェクト停止

		Gdx.app.log("JUST", group.getPlayerAtack() + "");
		
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
			clearActions();
			setColor(init);
			stateTime = 0;
			atackDelay = 0.8f;
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

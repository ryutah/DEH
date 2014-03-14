package game.edh.model;

import com.badlogic.gdx.math.MathUtils;

public class Player {
	final float MAX_HP = 100f;
	final float DEF_ATACK = 10f;
	
	private float nowHP;
	private float nowAtack;
	
	float stateTime;
	boolean powUP;
	
	public Player init() {
		nowHP = MAX_HP;
		nowAtack = DEF_ATACK;
		powUP = false;
		return this;
	}
	
	public void damege(float damege) {
		nowHP -= damege;
	}
	
	public float getAtack() {
		return nowAtack * MathUtils.random(0.8f, 1.2f);
	}
	
	public float getMaxHP() {
		return MAX_HP;
	}
	
	public float getHp() {
		return nowHP;
	}
	
	public void recover() {
		nowHP += 25f;
		if(nowHP >= MAX_HP)
			nowHP = MAX_HP;
	}
	
	public void powUP() {
		nowAtack += 15f;
		stateTime = 0;
		powUP = true;
	}
	
	public void update(float delta) {
		if(powUP) {
			stateTime += delta;
			if(stateTime >= 10f) {
				nowAtack = DEF_ATACK;
				powUP = false;
				stateTime = 0;
			}
		}
	}
}

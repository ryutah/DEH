package game.edh.model;

import game.edh.Assets;
import game.edh.frame.GameGroup;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class HPBar extends Image {
	GameGroup group;

	
	private final float MAX_HPBAR;
	private float nowHpBar;
	
	private float playerHp;
	private final float PLAYER_MAX_HP;

	TextureRegion hpbar;

	public HPBar(GameGroup group) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.group = group;
		hpbar = Assets.batle.getRegion("hpbar");
		playerHp = group.getPlayerHp();
		PLAYER_MAX_HP = group.getPlayer().getMaxHP();

		MAX_HPBAR = hpbar.getRegionWidth();
		nowHpBar = playerHp / PLAYER_MAX_HP * MAX_HPBAR;

		hpbar.setRegionWidth((int) nowHpBar);
		
		setDrawable((Drawable) hpbar);
		setBounds(0, 0, hpbar.getRegionWidth(), hpbar.getRegionHeight());
	}
	
	private void checkHP() {
		if(playerHp != group.getPlayerHp()) {
			playerHp = group.getPlayerHp();
			nowHpBar = playerHp / PLAYER_MAX_HP * MAX_HPBAR;
			hpbar.setRegionWidth((int) nowHpBar);
		}
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		checkHP();
		super.act(delta);
	}
}

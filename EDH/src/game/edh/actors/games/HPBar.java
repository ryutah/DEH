package game.edh.actors.games;

import game.edh.Assets;
import game.edh.actors.batle.BatleGroup;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class HPBar extends Image {
	BatleGroup group;

	
	private final float MAX_HPBAR;
	private float nowHpBar;
	
	private float playerHp;
	private final float PLAYER_MAX_HP;

	TextureRegionDrawable hpbar;

	public HPBar(BatleGroup group) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.group = group;
		TextureRegion hpbarR = Assets.batle.getRegion("hpbar");
		playerHp = group.getPlayerHp();
		PLAYER_MAX_HP = group.getPlayer().getMaxHP();

		MAX_HPBAR = hpbarR.getRegionWidth();
		nowHpBar = playerHp / PLAYER_MAX_HP * MAX_HPBAR;

		hpbarR.setRegionWidth((int) nowHpBar);
		hpbar = new TextureRegionDrawable(hpbarR);
		setDrawable(hpbar);
		
		setBounds(0, 0, hpbarR.getRegionWidth(), hpbarR.getRegionHeight());
	}
	
	private void checkHP() {
		if(playerHp != group.getPlayerHp()) {
			playerHp = group.getPlayerHp();
			nowHpBar = playerHp / PLAYER_MAX_HP * MAX_HPBAR;
			hpbar.setRightWidth(nowHpBar);
			setWidth(hpbar.getRightWidth());
			if(getWidth() <= 0)
				setWidth(0);
		}
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		checkHP();
		super.act(delta);
	}
}

package game.edh.model;

import game.edh.Assets;
import game.edh.frame.GameGroup;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ClearBar extends Image {
	private final float MAX_CLEAR_BAR;
	private float nowBar;
	
	private final float MAX_CLEAR;
	private float nowClear;
	
	GameGroup group;
	
	TextureRegion clearbar;
	
	public ClearBar(GameGroup group) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.group = group;
		clearbar = Assets.batle.getRegion("clearbar");
		
		MAX_CLEAR = group.getClearFlag();
		nowClear = group.getClearCount();
		
		MAX_CLEAR_BAR = clearbar.getRegionWidth();
		nowBar = nowClear / MAX_CLEAR * MAX_CLEAR_BAR;
		
		clearbar.setRegionWidth((int) nowBar);
		setBounds(0, 0, nowBar, clearbar.getRegionHeight());
	}
	
	private void checkClear() {
		if(nowClear != group.getClearCount()) {
			nowClear = group.getClearCount();
			nowBar = nowClear / MAX_CLEAR * MAX_CLEAR_BAR;
			clearbar.setRegionWidth((int) nowBar);
		}
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		checkClear();
		super.act(delta);
	}
}

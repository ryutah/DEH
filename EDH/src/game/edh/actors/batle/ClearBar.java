package game.edh.actors.batle;

import game.edh.Assets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ClearBar extends Image {
	private final float MAX_CLEAR_BAR;
	private float nowBar;
	
	private final float MAX_CLEAR;
	private float nowClear;
	
	BatleGroup group;
	
	TextureRegion clearbarR;
	TextureRegionDrawable clearbar;
	
	public ClearBar(BatleGroup group) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.group = group;
		TextureRegion clearbarR = Assets.batle.getRegion("clearbar");
		
		MAX_CLEAR = group.getClearFlag();
		nowClear = group.getClearCount();
		
		MAX_CLEAR_BAR = clearbarR.getRegionWidth();
		nowBar = nowClear / MAX_CLEAR * MAX_CLEAR_BAR;
		
		clearbarR.setRegionWidth((int) nowBar);
		clearbar = new TextureRegionDrawable(clearbarR);
		setDrawable(clearbar);
		setBounds(0, 0, nowBar, clearbarR.getRegionHeight());
	}
	
	private void checkClear() {
		if(nowClear != group.getClearCount()) {
			nowClear = group.getClearCount();
			nowBar = nowClear / MAX_CLEAR * MAX_CLEAR_BAR;
			clearbar.setRightWidth(nowBar);
			setWidth(clearbar.getRightWidth());
			if(getWidth() <= 0)
				setWidth(0);
		}
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		checkClear();
		super.act(delta);
	}
}

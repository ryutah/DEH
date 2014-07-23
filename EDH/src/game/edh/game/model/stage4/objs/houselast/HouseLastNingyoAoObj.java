package game.edh.game.model.stage4.objs.houselast;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class HouseLastNingyoAoObj extends MapObject {

	public HouseLastNingyoAoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8.5f, 6, 1, 1);
		setCheck(false);
		setDrawable(Assets.games.get("ningyoAo", TextureRegionDrawable.class));
		
		if(world.getFlag(Stage4Flag.RIM_TSUKUE2))
			setDraw(false);
	}
	
	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(draw && world.getFlag(Stage4Flag.RIM_TSUKUE2))
			setDraw(false);
	}

}

package game.edh.game.model.stage4.objs.houselast;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.stage4.event.MapEventRemTana1;

public class HouseLastTana1Obj extends MapObject {

	public HouseLastTana1Obj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(19, 5, 2, 4);
		setCollision(false);
		setDrawable(Assets.games.get("tana1", TextureRegionDrawable.class));
		
		if(world.getFlag(Stage4Flag.RIM_TANA1)) {
			setDraw(false);
			setCheck(false);
		}
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addMapEvent(new MapEventRemTana1(world));
	}
	
	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(draw && world.getFlag(Stage4Flag.RIM_TANA1)) {
			setDraw(false);
			setCheck(false);
		}
	}
}

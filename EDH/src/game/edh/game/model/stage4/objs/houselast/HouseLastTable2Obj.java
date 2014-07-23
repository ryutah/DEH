package game.edh.game.model.stage4.objs.houselast;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.stage4.event.MapEventRemTsukue1;

public class HouseLastTable2Obj extends MapObject {
	public static final String NAME = "tsukue1";

	public HouseLastTable2Obj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setName(NAME);
		setBounds(14, 5, 3, 3);
		setCollision(false);
		setDrawable(Assets.games.get("tsukue1", TextureRegionDrawable.class));
		
		if(world.getFlag(Stage4Flag.RIM_TSUKUE1)) {
			setDraw(false);
			setCheck(false);
		}
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addMapEvent(new MapEventRemTsukue1(world));
	}
	
	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(draw && world.getFlag(Stage4Flag.RIM_TSUKUE1)) {
			setDraw(false);
			setCheck(false);
		}
	}
}

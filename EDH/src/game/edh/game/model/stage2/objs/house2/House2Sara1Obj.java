package game.edh.game.model.stage2.objs.house2;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;

public class House2Sara1Obj extends MapObject {

	public House2Sara1Obj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(16, 6, 1, 1);
		setDrawable(Assets.games.get("sara", TextureRegionDrawable.class));
		setCheck(false);
	
		if(!world.getFlag(Stage2Flag.PUT_RYOURI1))
			setDraw(false);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(!draw && world.getFlag(Stage2Flag.PUT_RYOURI1))
			setDraw(true);
	}
	
}

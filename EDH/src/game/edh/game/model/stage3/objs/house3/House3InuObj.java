package game.edh.game.model.stage3.objs.house3;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;

public class House3InuObj extends MapObject {

	public House3InuObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(1.5f, 5, 1, 1);
		setDrawable(Assets.games.get("inu", TextureRegionDrawable.class));
		
		if(world.getFlag(Stage3Flag.PUT_INU))
			setDraw(true);
		else
			setDraw(false);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(!draw && world.getFlag(Stage3Flag.PUT_INU))
			setDraw(true);
	}
	
}

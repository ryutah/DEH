package game.edh.game.model.stage3.objs.map3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.MapObject;

public class Map3FlagWallObj extends MapObject {

	public Map3FlagWallObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(0, 8, .5f, 8);
		setCollision(true);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(world.getFlag(Stage3Flag.PUT_INU))
			setCollision(false);
	}
}

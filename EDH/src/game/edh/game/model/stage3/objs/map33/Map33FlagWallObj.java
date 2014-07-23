package game.edh.game.model.stage3.objs.map33;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;

public class Map33FlagWallObj extends MapObject {

	public Map33FlagWallObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(13, 6, 1, 3);
		setCollision(true);
	}
	
	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(world.getFlag(Stage3Flag.PUT_INU))
			setCollision(false);
	}

}

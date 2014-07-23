package game.edh.game.model.stage1.objs.map1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class Map1Stage1EndWallObj extends MapObject {
	public static final String NAME = "stageEnd";

	public Map1Stage1EndWallObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setName(NAME);
		setBounds(1, 2, 1, 6);
		setCollision(true);
	}

}

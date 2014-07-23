package game.edh.game.model.stage2.objs.map2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.stage2.MapMayoinomori;
import game.edh.game.model.stage2.MapMizuumi;

public class Map2MapChange extends MapChangeRect {
	GameWorld world;

	public Map2MapChange(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(29, 34.5f, 4, 1);
		this.world = world;
	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		if(world.getFlag(Stage2Flag.CLEAR_MORI))
			return MapMizuumi.NAME;
		else 
			return MapMayoinomori.NAME;
	}

}

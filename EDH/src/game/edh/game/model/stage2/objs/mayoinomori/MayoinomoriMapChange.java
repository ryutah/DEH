package game.edh.game.model.stage2.objs.mayoinomori;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.stage2.MapMayoinomori;
import game.edh.game.model.stage2.MapMizuumi;

public class MayoinomoriMapChange extends MapChangeRect {
	MapMayoinomori map;
	GameWorld world; 

	public MayoinomoriMapChange(GameWorld world, MapMayoinomori map) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(6, 14.5f, 3, .5f, MapMizuumi.NAME);
		this.map = map;
		this.world = world;
	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		if (!map.stap3) {
			map.step1 = map.stap2 = map.stap3 = map.stap4 = false;
			return MapMayoinomori.NAME;
		} else {
			map.step1 = map.stap2 = map.stap3 = map.stap4 = false;
			world.changeFlag(Stage2Flag.CLEAR_MORI, true);
			return super.getName();
		}

	}
}

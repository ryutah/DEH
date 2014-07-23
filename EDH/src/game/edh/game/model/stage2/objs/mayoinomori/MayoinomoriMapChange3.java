package game.edh.game.model.stage2.objs.mayoinomori;

import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.stage2.MapMayoinomori;

public class MayoinomoriMapChange3 extends MapChangeRect {
	MapMayoinomori map;

	public MayoinomoriMapChange3(MapMayoinomori map) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(0, 6, .5f, 3, MapMayoinomori.NAME);
		this.map = map;
	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		if (!map.step1)
			map.step1 = true;
		else if (map.step1 && map.stap2)
			map.stap3 = true;
		else
			map.step1 = map.stap2 = map.stap3 = map.stap4 = false;

		return super.getName();
	}
}

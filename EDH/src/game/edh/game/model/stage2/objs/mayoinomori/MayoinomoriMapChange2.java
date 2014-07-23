package game.edh.game.model.stage2.objs.mayoinomori;

import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.stage2.MapMayoinomori;

public class MayoinomoriMapChange2 extends MapChangeRect {
	MapMayoinomori map;

	public MayoinomoriMapChange2(MapMayoinomori map) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(14.5f, 6, .5f, 3, MapMayoinomori.NAME);
		this.map = map;
	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		if (map.step1 && !map.stap2 && !map.stap3 && !map.stap4) {
			map.stap2 = true;
		} else
			map.step1 = map.stap2 = map.stap3 = map.stap4 = false;
		return super.getName();
	}
}

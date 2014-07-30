package game.edh.game.model.stage3.objs.map34;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.ModelInu;
import game.edh.game.model.stage3.MapStage3_4;
import game.edh.game.model.stage3.event.MapEventInu;

public class Map34ModelInu extends ModelInu {

	public Map34ModelInu(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setDir(InuDir.Down);
		setPosition(16.5f, 12.5f);
		if (world.getFlag(Stage3Flag.DELETE_INU)) {
			setDraw(false);
			setCollision(false);
			setCheck(false);
		}
		setName("inu");
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		super.checkObj();
		if (!world.getFlag(Stage3Flag.PUT_RYORI))
			world.textEvent("『この森もとても寒くなってきた…』", "『そろそろ君がここに来ることも無くなるね』");
		else {
			world.addMapEvent(new MapEventInu(world, world
					.getMap(MapStage3_4.NAME)));
		}
	}
}

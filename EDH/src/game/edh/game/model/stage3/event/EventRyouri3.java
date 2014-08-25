package game.edh.game.model.stage3.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.event.EventRyouri;
import game.edh.game.model.items.ItemsHandler;

public class EventRyouri3 extends EventRyouri {
	int[] colectId = { KINOKO, KINOKO, TAMANEGI, NINJIN, SPICE, SOLT, SAKANA,
			BUTTER };

	public EventRyouri3(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setColectId(colectId);

		if (world.getFlag(Stage3Flag.RYOURI_IN_KINOKO))
			addTableObj(KINOKO, "きのこ", "kinoko");
		else {
			if (world.getItems().findItem(ItemsHandler.KINOKO)) {
				world.removeItem(ItemsHandler.KINOKO);
				addShokuzai(KINOKO, "きのこ", "kinoko");
				world.changeFlag(Stage3Flag.RYOURI_IN_KINOKO, true);
			}
		}

		if (world.getFlag(Stage3Flag.RYOURI_IN_SAKANA))
			addTableObj(SAKANA, "さかな", "sakana");
		else {
			if (world.getItems().findItem(ItemsHandler.SAKANA)) {
				world.removeItem(ItemsHandler.SAKANA);
				addShokuzai(SAKANA, "さかな", "sakana");
				world.changeFlag(Stage3Flag.RYOURI_IN_SAKANA, true);
			}
		}
	}

}

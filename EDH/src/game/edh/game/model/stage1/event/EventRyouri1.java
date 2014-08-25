package game.edh.game.model.stage1.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.frame.event.EventRyouri;
import game.edh.game.model.items.ItemsHandler;

public class EventRyouri1 extends EventRyouri {
	final int[] colect = { SPICE, SOLT, KINOMI, KUSA, TAMANEGI };

	public EventRyouri1(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setColectId(colect);

		boolean kinomi = world.getFlag(Stage1Flag.RYORI_IN_KINOMI);
		boolean kusa = world.getFlag(Stage1Flag.RYORI_IN_KUSA);

		if (!kinomi) {
			if (world.getItems().findItem(ItemsHandler.KINOMI_1)) {
				world.removeItem(ItemsHandler.KINOMI_1);
				world.changeFlag(Stage1Flag.RYORI_IN_KINOMI, true);
				addShokuzai(KINOMI, "きのみ", "kinomi1");
			}
		} else
			addTableObj(KINOMI, "きのみ", "kinomi1");

		if (!kusa) {
			if (world.getItems().findItem(ItemsHandler.KUSA)) {
				world.removeItem(ItemsHandler.KUSA);
				world.changeFlag(Stage1Flag.RYORI_IN_KUSA, true);
				addShokuzai(KUSA, "山草", "kusa");
			}
		} else
			addTableObj(KUSA, "山草", "kusa");
	}
}

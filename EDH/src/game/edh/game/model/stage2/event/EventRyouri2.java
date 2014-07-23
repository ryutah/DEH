package game.edh.game.model.stage2.event;

import java.util.Arrays;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.frame.event.EventRyouri;
import game.edh.game.model.items.ItemsHandler;

public class EventRyouri2 extends EventRyouri {
	int[] colectId1 = { NASU, TOMATO, SOLT, OIL };
	int[] celectId2 = {SOLT, SPICE, SAKANA, NINJIN, TAMAGO};

	public EventRyouri2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		Arrays.sort(colectId1);
		Arrays.sort(celectId2);

		if (world.getFlag(Stage2Flag.RYORI_IN_SAKANA))
			addTableObj(SAKANA, "さかな", "sakana");
		else {
			if (world.getItems().findItem(ItemsHandler.SAKANA)) {
				addTableObj(SAKANA, "さかな", "sakana");
				world.removeItem(ItemsHandler.SAKANA);
				world.changeFlag(Stage2Flag.RYORI_IN_SAKANA, true);
			}
		}

		if (world.getFlag(Stage2Flag.RYORI_IN_TAMAGO))
			addTableObj(TAMAGO, "たまご", "tamago");
		else {
			if (world.getItems().findItem(ItemsHandler.TAMAGO)) {
				addTableObj(TAMAGO, "たまご", "tamago");
				world.removeItem(ItemsHandler.TAMAGO);
				world.changeFlag(Stage2Flag.RYORI_IN_TAMAGO, true);
			}
		}

	}

	@Override
	public void kansei() {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getItems().findItem(ItemsHandler.RYOURI_SEIKO)
				|| world.getItems().findItem(ItemsHandler.RYOURI_SEIKO2)
				|| world.getItems().findItem(ItemsHandler.RYOURI_SHIPPAI)) {
			world.textEvent("今は料理を作れない");
			return;
		} else {
			boolean a = Arrays.equals(inId, colectId1);
			boolean b = Arrays.equals(inId, celectId2);
			
			world.textEvent("料理を作った");

			if (a)
				world.addItem(ItemsHandler.RYOURI_SEIKO);
			else if (b)
				world.addItem(ItemsHandler.RYOURI_SEIKO2);
			else
				world.addItem(ItemsHandler.RYOURI_SHIPPAI);
		}
	}
}

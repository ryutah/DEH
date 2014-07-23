package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.event.EventRyouri;

public class EventRyouri4 extends EventRyouri {

	public EventRyouri4(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		addTableObj(KINOMI, "きのみ", "kinomi1");
		addTableObj(KUSA, "山草", "kusa");
		addTableObj(SAKANA, "さかな", "sakana");
		addTableObj(TAMAGO, "たまご", "tamago");
		addTableObj(KINOKO, "きのこ", "kinoko");
	}

}

package game.edh.game.model.stage1.objs.house1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.items.ItemsHandler;

public class House1KouguBakoObj extends MapObject {
	String[] texts = {"何かの箱がある", "鍵がかかっていて開かない…"};
	String[] texts2 = {"鍵を使った", "木の棒を手に入れた"};
	String[] texts3 = {"もう何も入っていない"};

	public House1KouguBakoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(5, 11, 1, 1);
		setName("kouguBako");
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if(!world.getFlag(Stage1Flag.HAKO_OPEN)) {
			if(world.getSelectItem() == ItemsHandler.KAGI) {
				world.textEvent(texts2);
				world.clearSelectItem();
				world.removeItem(ItemsHandler.KAGI);
				world.addItem(ItemsHandler.BOU);
				world.changeFlag(Stage1Flag.HAKO_OPEN, true);
			} else
				world.textEvent(texts);
		} else
			world.textEvent(texts3);
	}
}

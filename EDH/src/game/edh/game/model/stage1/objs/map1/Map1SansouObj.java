package game.edh.game.model.stage1.objs.map1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map1SansouObj extends MapObject {

	public Map1SansouObj(float x, float y, float width, float height, String name,
			GameWorld world) {
		super(x, y, width, height, name, world);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public Map1SansouObj(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(world);
		setBounds(30, 10, 2, 2);
		setName("sansou");
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("「山草」を手に入れた");
		world.addItem(ItemsHandler.KUSA);
		world.changeFlag(Stage1Flag.SANSOU, true);
		world.getMap().removeObjs(this);
		super.checkObj();
	}

}

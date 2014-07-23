package game.edh.game.model.stage3.objs.house3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;

public class House3KouguBakoObj extends MapObject {

	public House3KouguBakoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(5, 11, 1, 1);
		
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("特に気になるものは入っていない");
	}
}

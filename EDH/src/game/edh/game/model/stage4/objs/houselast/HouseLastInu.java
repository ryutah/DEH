package game.edh.game.model.stage4.objs.houselast;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelInu;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.stage4.event.MapEventRemInu;

public class HouseLastInu extends ModelInu {

	public HouseLastInu(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setPosition(3, 6);
		setDir(InuDir.Rignt);
		if (world.getFlag(Stage4Flag.RIM_INU)) {
			setDraw(false);
			setCollision(false);
			setCheck(false);
		}
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addMapEvent(new MapEventRemInu(world));
	}
	
	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(draw && world.getFlag(Stage4Flag.RIM_INU)) {
			setDraw(false);
			setCollision(false);
			setCheck(false);
		}
	}
}

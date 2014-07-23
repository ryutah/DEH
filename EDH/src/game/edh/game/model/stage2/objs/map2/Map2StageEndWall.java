package game.edh.game.model.stage2.objs.map2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;

public class Map2StageEndWall extends MapObject {
	boolean remove;

	public Map2StageEndWall(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(0, 22, 2, 4);

		if (world.getFlag(Stage2Flag.NINGYO_PUT)) {
			remove = true;
			setCollision(false);
		} else
			setCollision(true);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (!remove && world.getFlag(Stage2Flag.NINGYO_PUT)) {
			setCollision(false);
			remove = true;
		}
	}
}

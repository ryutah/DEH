package game.edh.game.model.stage4.objs.map43;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class Map43WallObj extends MapObject {
	boolean rem;

	public Map43WallObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(6, 14, 3, 1);

		if (world.getFlag(Stage4Flag.HAKA_HANA)) {
			setCollision(true);
			rem = true;
		} else {
			setCollision(false);
			rem = false;
		}
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (!rem && world.getFlag(Stage4Flag.HAKA_HANA)) {
			setCollision(false);
			rem = true;
		}
	}
}

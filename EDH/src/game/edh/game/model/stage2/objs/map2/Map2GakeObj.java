package game.edh.game.model.stage2.objs.map2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;

public class Map2GakeObj extends MapObject {
	boolean remove;

	public Map2GakeObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(22, 14, 2, 1);

		if (world.getFlag(Stage2Flag.PUT_RYOURI1)
				&& world.getFlag(Stage2Flag.PUT_RYOURI2)) {
			setCollision(false);
			remove = true;
		} else
			setCollision(true);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (!remove) {
			if (world.getFlag(Stage2Flag.PUT_RYOURI1)
					&& world.getFlag(Stage2Flag.PUT_RYOURI2)) {
				setCollision(false);
				remove = true;
			}
		}
	}
}

package game.edh.game.model.stage4.objs.houselast;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class HouseLastWallObj extends MapObject {
	int id;

	public HouseLastWallObj(GameWorld world, int id) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		this.id = id;
		if (id == 0) {
			setBounds(15, 5, 2, 2);
			if (world.getFlag(Stage4Flag.RIM_TSUKUE1))
				setCollision(false);
			else
				setCollision(true);
		} else {
			setBounds(19, 5, 2, 1);
			if (world.getFlag(Stage4Flag.RIM_TANA1))
				setCollision(false);
			else
				setCollision(true);
		}
		setCheck(false);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		switch (id) {
		case 0:
			if (collision && world.getFlag(Stage4Flag.RIM_TSUKUE1))
				setCollision(false);
			break;
		default:
			if (collision && world.getFlag(Stage4Flag.RIM_TANA1))
				setCollision(false);
			break;
		}
	}
}

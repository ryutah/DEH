package game.edh.game.model.stage3.objs.map35;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;

public class Map35FlagWallObj extends MapObject {

	public Map35FlagWallObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(1, 1, 1, 4);
		setCollision(true);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("柵がある…", "結構高いから乗り越えるのは無理そう");
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(world.getFlag(Stage3Flag.PUT_INU))
			setCollision(false);
	}

}

package game.edh.game.model.stage2.objs.map2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelInu;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;

public class Map2Inu extends ModelInu {
	int textNum;
	String[] text = { "『今日もここに来たんだね", "また会えて嬉しいよ』" };
	String[] text2 = { "『たまに何かを調べた時に、調べたものが大きく表示されることがあるでしょ』",
			"『その時は、タップで調べる以外にも何かできることがあるかもしれないよ』" };
	String[] text3 = {"『これからまたあの子に会いに行くんだね』", "『楽しんでおいで』"};

	public Map2Inu(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setPosition(32, 20);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if(!world.getFlag(Stage2Flag.NINGYO_PUT)) {
			if(textNum == 0) {
				world.textEvent(text);
				textNum++;
			} else {
				world.textEvent(text2);
				textNum = 0;
			}
		} else
			world.textEvent(text3);
	}
}

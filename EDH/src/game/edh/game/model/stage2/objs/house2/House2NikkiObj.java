package game.edh.game.model.stage2.objs.house2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;

public class House2NikkiObj extends MapObject {
	String[] texts1 = { "○月×日\nパパが鍵をなくす", "今度はパパが工具箱の鍵を無くしちゃったみたい！",
			"橋はもう完成したからあまり困っていないみたいだけど、", "昨日は池まで釣りに行ってたからその時に落としたんじゃないかしら？",
			"もう、なんで釣りに行くのに鍵を持っていくのかしら！" };

	String[] texts2 = { "○月×日\n裁縫ってむずかしい", "最近はあの子と家でお人形を作っているの",
			"でも、料理なんかはわりとできるんだけど、お裁縫はちょっと苦手…",
			"あの子も全然やった事ないみたいだから、なかなかうまくいかないわ",
			"たまに気分転換に森に遊びに行くんだけど、そのたびにパパはオオカミに気をつけろって言うのよね",
			"そんなに遠くには行かないし、暗くなる前に帰るからだいじょうぶなのに…パパって心配症ね" };

	public House2NikkiObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8, 6, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if(world.getFlag(Stage2Flag.FISH))
			world.textEvent(texts2);
		else
			world.textEvent(texts1);
	}
}

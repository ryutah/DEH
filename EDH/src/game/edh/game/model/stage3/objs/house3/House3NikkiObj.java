package game.edh.game.model.stage3.objs.house3;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;

public class House3NikkiObj extends MapObject {

	public House3NikkiObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8, 6, 1, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		super.checkObj();
		if (!world.getFlag(Stage3Flag.TEBUKURO_GET))
			world.textEvent("日記がある", "○月×日\n寒い季節", "冬になってこの森もとても寒くなってきたわ",
					"雪も積もってるし、もう歩くだけで手も耳もまっかになっちゃう！",
					"あの子はいつも手袋もせずにいるから、こっちまで寒くなってくるわ",
					"いっつも手をこすり合わせたり、息を吹きかけたりしてるし…", "なんとかしてあげたいな");
		else
			world.textEvent("○月×日\nてぶくろをプレゼント！", "今日、あの子にてぶくろをプレゼントしてあげたわ",
					"”雪を持っても冷たくない ”なんて言って、おおはしゃぎ！",
					"でも走り回ったせいで転んじゃって雪まみれになっちゃった", "今日はあったかいスープを作ってあげることにした",
					"お料理メモを無くしちゃったけど、作り方は覚えているからだいじょうぶ！");
	}
}

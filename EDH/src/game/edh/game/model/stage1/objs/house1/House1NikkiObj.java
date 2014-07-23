package game.edh.game.model.stage1.objs.house1;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.stage1.MapStage1;

public class House1NikkiObj extends MapObject {
	String[] texts = { "何かのノートがある", "この家の人の日記みたい", "なんとなく気になるページがある",
			"○月×日\nどうしましょう！", "昨日のこぎりをパパのところに届けに行ったのだけど、その後パパの工具箱の鍵をなくしてしまったわ",
			"家中ひっくり返して探したのだけど、どうしても見つからない", "パパは、今度街まで行って新しいモノを買ってくるって言ってるけど…",
			"もしかしたら、看板に落書きしてた時に落としたのかしら", "いっかい森の中も探してみようかな…" };

	String[] texts2 = { "日記のページが増えている…", "○月×日\n鍵が見つかった！",
			"なくした鍵はやっぱりあの看板の近くで見つかったわ", "迷惑かけてごめんなさいパパ", "○月×日\n橋が完成！",
			"今日ついに橋ができた！", "これで街の行き来が簡単になるわ", "これからは1人で街に遊びに行っていいか、パパに聞いたら",
			"森の中はオオカミもでるし危ないからダメだって…", "ちょっと残念" };

	public House1NikkiObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(8, 6, 1, 1);
		setName("houseMemo");
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage1Flag.HAKO_OPEN))
			world.textEvent(texts);
		else {
			if (!world.getFlag(Stage1Flag.NIKKI)) {
				world.changeFlag(Stage1Flag.NIKKI, true);
				world.getMap(MapStage1.NAME).addFrontLayers("flagfore");
				world.getMap(MapStage1.NAME).addBackLayers("flagback");
				world.getMap(MapStage1.NAME).removeObjs("hashi");
			}
			world.textEvent(texts2);
		}
	}
}

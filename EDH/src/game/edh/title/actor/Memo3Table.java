package game.edh.title.actor;

import game.edh.frame.BaseScreen;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Memo3Table extends MemoTable {
	String text = "○月×日　雪\n\n" + "今日はすごい雪だわ！\n"
			+ "こんなに降ってちゃさすがにあの子も来れないし、私だって外に出れないから退屈"
			+ "最初は窓から見える大雪にすこしはしゃいじゃったけど、さすがにお昼には飽きちゃった\n\n"
			+ "しかたないから、家にある材料を使ってお料理の練習をしてたわ\n"
			+ "試しにやってみただけだったのに、意外とおいしくできてびっくりしちゃった" + "今度あったら作ってあげよう！";

	String text2 = "○月×日　雪\n\n" + "昨日の夜止んだと思った雪が朝起きたら、また降り始めてた\n"
			+ "２日もこんな大雪なんて最悪だわ\n\n" + "きっと明日は雪かきで終わっちゃうわね\n\n"
			+ "パパは、どうしても今日中に街に行かなくちゃいけないって言って" + "こんな天気の中出かけちゃうし…\n\n"
			+ "パパだいじょうぶかしら？\n\n" + "それにしても今日は何をしようかしら\n" + "あーあ、退屈だわ";

	public Memo3Table(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		setText(text);
		addNewMemo(text2);
	}

}

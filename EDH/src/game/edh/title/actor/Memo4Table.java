package game.edh.title.actor;

import game.edh.frame.BaseScreen;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Memo4Table extends MemoTable {
	String text = "○月×日　晴れ\n\n"
			+ "やっと雪も上がって今日はいい天気\n\n"
			+ "まだパパは帰ってきてないし、雪かきは１人でやらなきゃ\n"
			+ "だいぶ雪も積もってるからあの子はまだしばらくこれないよね…\n\n"
			+ "早く遊びたいな";
	
	String text2 = "○月×日　\n\n今日も帰ってこない…\n\n"
			+ "……パパどうしたの";
	
	String text3 = "○月\n";
	
	String text4 = "○月×日　晴れ\n\n"
			+ "これからは、遠くに住んでる伯父さんの家で暮らすことになったわ\n\n"
			+ "あの子とお別れしなきゃならないから、伯父さんにはまたあとで迎えに来てもらうことにした\n";
	
	String text5 = "○月\n\n"
			+ "あの子に嫌われちゃった";
	
	String text6 = "○月×日　晴れ\n\n"
			+ "明日は伯父さんが迎えに来る日\n"
			+ "その前に、あの子の家に行ってお話してこようと思うの\n\n"
			+ "それで、この前作ってあげられなかったお料理も食べさせてあげよう\n\n"
			+ "だいたいの場所しか知らないけど、多分だいじょぶよね\n\n"
			+ "次に日記を書く時は、きっと仲直りできたって書いてあると思うわ！";

	public Memo4Table(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		setText(text);
		addNewMemo(text2);
		addNewMemo(text3);
		addNewMemo(text4);
		addNewMemo(text5);
		addNewMemo(text6);
	}

}

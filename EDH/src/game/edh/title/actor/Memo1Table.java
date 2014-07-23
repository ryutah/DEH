package game.edh.title.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import game.edh.frame.BaseScreen;

public class Memo1Table extends MemoTable {
	String text = "○月×日　雨\n\n最近はずっと天気が悪い" + "\n雨はざーざー降ってるし、風も痛いくらい吹いてくる"
			+ "\nいつもの場所にお花を摘みに行きたいけど、こんな天気じゃ行けないわ"
			+ "\nパパも心配症だから、『危ないから家でおとなしくしてなさい』だって\nこんな天気じゃいくら私でも外に遊びになんか行かないわ"
			+ "\n早く天気になってほしいな…";
	String text2 = "○月×日　晴れ\n\n"
			+ "今日、やっと天気がよくなったわ。\n\n"
			+ "外に出て、雨上がりの空気をいっぱい吸ってとってもいい気持ち。\n\n"
			+ "それで、久しぶりにあの場所へ行ってみたの。\nお花はだいじょうぶかしら、雨で枯れたりしていない？\n\n"
			+ "ついてみてびっくり、\n"
			+ "雨上がりのあの場所は、草花についてる雨粒が光を反射していて、\n"
			+ "まるで水晶が地面いっぱいにしいてあるみたい\n\n"
			+ "とってもきれいで、お花を持って帰ってパパに見せてあげなきゃと思ったんだけど、"
			+ "持って帰ったら、きっと水晶は普通の花に戻ってしまうものね。\n\n"
			+ "どうしようか悩んでいたら、私がたまにお昼寝してる木のあたりに"
			+ "赤い頭巾をかぶった女の子がいたわ\n"
			+ "この森で女の子なんて見たの初めてだったから、なんだかとってもたのしくなっちゃって女の子に話しかけてみたの\n\n"
			+ "その子は街のはずれに住んでるらしくて、森がきらきら光ってたからたまたまここまでんだって\n\n"
			+ "わたし、その子と仲良くなりたくて、家にきてみないって言ってみたわ。\n"
			+ "それで私の家に２人で行くことになって、\n"
			+ "せっかくだから一緒にご飯を作って食べて、"
			+ "それからいっぱいおしゃべりして、それから…えーっと、とりあえずとっても楽しかったの！\n\n"
			+ "彼女もまた遊ぼうっていってくれたし、今日はほんとに素敵な日だったわ。\n\n" + "また明日も会えるかしら？\n"
			+ "すごくたのしみだわ！";

	public Memo1Table(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		setText(text);
		addNewMemo(text2);
	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ

	}

}

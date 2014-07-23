package game.edh;

public class TextAssets {
	public static String[] test = new String[4];
	public static String[] event1;
	
	public static void loadTestText() {
		test[0] = "イベントシーンのテスト"
				+ "キャラクターとカメラを動か"
				+ "す。";
		
		test[1] = "このテキストの後にキャラク\n"
				+ "ターのテクスチャが変化する。";
		
		test[2] = "変わっていれば成功。";
		
		test[3] = "テキスト終了。\n"
				+ "タイトルに戻る";
	}
	
	public static void loadEvent1Text() {
		event1[0] = "あるところに、１人の少女がいました。";
		event1[1] = "少女のお家は街の外れの森の近くにあるのですが、"
				+ "お父さんもお母さんも、朝早くから仕事で街に行ってしまい"
				+ "帰ってくるのは夜遅くになるので";
		event1[2] = "いつも１人で森で遊んでいたそうです";
		
		event1[3] = "目をさますと、少女は知らないところにいました";
		event1[4] = "";
	}
}

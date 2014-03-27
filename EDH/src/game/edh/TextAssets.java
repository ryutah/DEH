package game.edh;

public class TextAssets {
	public static String[] test = new String[4];
	
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
}

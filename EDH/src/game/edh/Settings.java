package game.edh;

public class Settings {
	public boolean sound;
	public boolean autoSave;
	
	public boolean[] clearStage;
	
	public Settings() {
		// TODO 自動生成されたコンストラクター・スタブ
		sound = true;
		autoSave = false;
		
		clearStage = new boolean[4];
	}

	public void clearStage(int stageNum) {
		int num = stageNum - 1;
		clearStage[num] = true;
	}
}

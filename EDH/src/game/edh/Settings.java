package game.edh;

public class Settings {
	public boolean sound;
	public boolean autoSave;
	public float padSize;
	public float padX;
	public float padY;

	public boolean[] clearStage;

	public Settings() {
		// TODO 自動生成されたコンストラクター・スタブ
		sound = true;
		autoSave = false;

		padSize = 1;
		padX = 216;
		padY = 114;

		clearStage = new boolean[4];
	}

	public void clearStage(int stageNum) {
		int num = stageNum - 1;
		clearStage[num] = true;
	}

	public void savePadSettings(float x, float y, float size) {
		this.padSize = size;
		this.padX = x;
		this.padY = y;
	}
}

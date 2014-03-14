package game.edh;

public class Player {
	public static float MAX_HP = 100;
	public static float ATACK = 20;
	
	public float nowHP;
	
	public Player() {
		// TODO 自動生成されたコンストラクター・スタブ
		this.nowHP = MAX_HP;
	}
	
	public void Damege(float damege) {
		nowHP -= damege;	
	}
}

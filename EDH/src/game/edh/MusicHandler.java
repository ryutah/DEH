package game.edh;


public class MusicHandler {
	EdhGame edh;
	private int nowMusic;
	
	public MusicHandler(EdhGame game) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.edh = game;
		nowMusic = -1;
	}
	
	public void changeMusic(int musicNumber) {
		if(nowMusic == musicNumber)
			return;
		
		if(nowMusic != -1) {
			Assets.music.stop();
			Assets.music.dispose();
		}
		
		Assets.loadMusic(musicNumber);
		nowMusic = musicNumber;
	}
	
	public void playMusic() {
		if(edh.settings.sound && nowMusic != -1) {
			if(!isPlaying()) {
				Assets.music.play();
			}
		}
	}
	
	public void pauseMusic() {
		if(nowMusic != -1) {
			if(isPlaying())
				Assets.music.pause();
		}
	}
	
	public void disposeMusic() {
		if(nowMusic != -1)
			Assets.music.dispose();
	}
	
	public boolean isPlaying() {
		try {
			return Assets.music.isPlaying();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public int getNowMusic() {
		return nowMusic;
	}
}

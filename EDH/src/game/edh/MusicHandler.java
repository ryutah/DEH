package game.edh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class MusicHandler {
	public enum EfftctType {
		ITEMGET, KETTEI, PAGE, AWA, HARAU, KIRU, ONO, SUZU
	}

	EdhGame edh;
	private int nowMusic;
	Sound effect;
	long effectId;
	float volume;
	boolean playMusic, stopMusic, fadeMusic, fadeEffect;

	public MusicHandler(EdhGame game) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.edh = game;
		nowMusic = -1;
		volume = 1;
		fadeMusic = false;
		fadeEffect = false;
		playMusic = false;
		stopMusic = false;
	}

	public void changeMusic(int musicNumber) {
		fadeMusic = false;
		if (nowMusic == musicNumber)
			return;

		if (nowMusic != -1) {
			if (Assets.music.isPlaying())
				Assets.music.stop();
			Assets.music.dispose();
		}

		Assets.loadMusic(musicNumber);
		nowMusic = musicNumber;
	}

	public void playMusic() {
		if (EdhGame.settings.sound && nowMusic != -1) {
			if (!isPlaying()) {
				playMusic = true;
				stopMusic = false;
				Assets.music.setVolume(1.0f);
				volume = 1;
			}
		}
	}

	public void stopMusic() {
		if (nowMusic != -1) {
			if (isPlaying()) {
				fadeMusic = true;
				stopMusic = true;
			}
		}
	}

	public void pauseMusic() {
		if (nowMusic != -1) {
			if (isPlaying())
				Assets.music.pause();
		}
	}

	public void disposeMusic() {
		if (stopMusic) {
			if (nowMusic != -1) {
				if (isPlaying())
					Assets.music.stop();
				Assets.music.dispose();
				nowMusic = -1;
			}
		}
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

	public void playEffect(EfftctType type, boolean loop) {
		long id = 0;
		switch (type) {
		case ITEMGET:
			effect = Assets.effect[1];
			break;
		case KETTEI:
			effect = Assets.effect[0];
			break;
		case PAGE:
			effect = Assets.effect[2];
			break;
		case AWA:
			effect = Assets.effect[3];
			break;
		case HARAU:
			effect = Assets.effect[4];
			break;
		case KIRU:
			effect = Assets.effect[5];
			break;
		case ONO:
			effect = Assets.effect[6];
			break;
		case SUZU:
			effect = Assets.effect[7];
			break;
		}

		id = effect.play();
		if (loop) {
			effectId = id;
			effect.setLooping(effectId, true);
		}
	}

	public void stopEffect() {
		if (EdhGame.settings.sound)
			fadeEffect = true;
	}

	public void update() {
		if (fadeMusic) {
			float volume = Assets.music.getVolume()
					- Gdx.graphics.getDeltaTime() / 1.5f;
			Assets.music.setVolume(volume);
			if (volume < .01f) {
				Gdx.app.log("Music", "Stop");
				Assets.music.stop();
				fadeMusic = false;
			}
		}

		if (fadeEffect) {
			volume = volume - Gdx.graphics.getDeltaTime() / 1.5f;
			effect.setVolume(effectId, volume);
			if (volume < .01f) {
				effect.stop();
				volume = 1.0f;
				fadeEffect = false;
			}
		}

		if (playMusic) {
			Assets.music.play();
			playMusic = false;
		}
	}
}

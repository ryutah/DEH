package game.edh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class Assets {
	public static Skin title;
	public static Music music;
	public static TextureAtlas titleAtlas;
	public static BitmapFont TOfont;
	public static BitmapFont mikachan;

	public static final int MORUDAU = 0;
	public static final int YUUGURE = 1;

	public static volatile boolean finishLoad = false;
	public static boolean titleLoad = false;
	public static boolean eventLoad = false;
	public static boolean batleLoad = false;

	public static void loadTitle() {
		finishLoad = false;
		titleAtlas = new TextureAtlas(Gdx.files.internal("data/title.pack"));

		// フォントファイル、ラベルスタイルのスキン
		TOfont = new BitmapFont(
				Gdx.files.internal("data/font/TOfont.fnt"));
		TOfont.setScale(1.2f);
		title.add("TOfont", TOfont);

		LabelStyle lbl = new LabelStyle(TOfont, Color.WHITE);
		title.add("white", lbl);

		LabelStyle lbl2 = new LabelStyle(TOfont, Color.CYAN);
		title.add("cyan", lbl2);

		LabelStyle lbl3 = new LabelStyle(TOfont, Color.BLACK);
		title.add("black", lbl3);

		mikachan = new BitmapFont(
				Gdx.files.internal("data/font/mikachan.fnt"));
		mikachan.setScale(1.5f);
		LabelStyle mikaLabel = new LabelStyle(mikachan, Color.BLACK);
		title.add("mikachan", mikaLabel);

		// タイトル画面のバック、各ロゴのスキン
		TextureRegion TBack = new TextureRegion(
				titleAtlas.findRegion("titleback"));
		title.add("titleback", TBack);

		TextureRegion pause = new TextureRegion(
				titleAtlas.findRegion("pausemenu"));
		title.add("pause", pause);

		TextureRegion TLRegion = new TextureRegion(
				titleAtlas.findRegion("titlelogo"));
		title.add("titlelogo", TLRegion);

		TextureRegion SLReagion = new TextureRegion(
				titleAtlas.findRegion("settinglogo"));
		title.add("settinglogo", SLReagion, TextureRegion.class);

		TextureRegion HLRegion = new TextureRegion(
				titleAtlas.findRegion("heoplogo"));
		title.add("helplogo", HLRegion, TextureRegion.class);

		TextureRegion STLRegion = new TextureRegion(
				titleAtlas.findRegion("stagelogo"));
		title.add("stagelogo", STLRegion);

		TextureRegion back = new TextureRegion(titleAtlas.findRegion("back"));
		title.add("back", back);

		finishLoad = titleLoad = true;
	}

	public static TextureAtlas eventAtlas;
	public static Skin event;

	public static void loadEvent() {
		finishLoad = false;
		eventAtlas = new TextureAtlas(Gdx.files.internal("data/event.pack"));

		// 主人公のスキン
		Sprite s_aruku = new Sprite(eventAtlas.findRegion("s_aruku"));
		event.add("s_aruku", s_aruku, Sprite.class);

		Sprite s_furimuku = new Sprite(eventAtlas.findRegion("s_furimuku"));
		event.add("s_furimuku", s_furimuku, Sprite.class);

		Sprite s_hashiru = new Sprite(eventAtlas.findRegion("s_hashiru"));
		event.add("s_hashiru", s_hashiru, Sprite.class);

		Sprite s_kagamu = new Sprite(eventAtlas.findRegion("s_kagamu"));
		event.add("s_kagamu", s_kagamu, Sprite.class);

		Sprite s_miageru = new Sprite(eventAtlas.findRegion("s_miageru"));
		event.add("s_miageru", s_miageru, Sprite.class);

		Sprite s_miorosu = new Sprite(eventAtlas.findRegion("s_miorosu"));
		event.add("s_miorosu", s_miorosu, Sprite.class);

		Sprite s_shoumen = new Sprite(eventAtlas.findRegion("s_shoumen"));
		event.add("s_shoumen", s_shoumen, Sprite.class);

		Sprite s_yokomuki = new Sprite(eventAtlas.findRegion("s_yokomuki"));
		event.add("s_yokomuki", s_yokomuki, Sprite.class);

		// 友人のスキン
		Sprite y_aruku = new Sprite(eventAtlas.findRegion("y_aruku"));
		event.add("y_aruku", y_aruku, Sprite.class);

		Sprite y_hana = new Sprite(eventAtlas.findRegion("y_hana"));
		event.add("y_hana", y_hana, Sprite.class);

		Sprite y_miageru = new Sprite(eventAtlas.findRegion("y_miageru"));
		event.add("y_miageru", y_miageru, Sprite.class);

		Sprite y_miorosu = new Sprite(eventAtlas.findRegion("y_miorosu"));
		event.add("y_miorosu", y_miorosu, Sprite.class);

		Sprite y_odoroku = new Sprite(eventAtlas.findRegion("y_odoroku"));
		event.add("y_odoroku", y_odoroku, Sprite.class);

		Sprite y_yokomuki = new Sprite(eventAtlas.findRegion("y_yokomuki"));
		event.add("y_yokomuki", y_yokomuki, Sprite.class);

		// 他キャラクターのスキン
		Sprite inu = new Sprite(eventAtlas.findRegion("inu"));
		event.add("inu", inu, Sprite.class);

		Sprite ookami = new Sprite(eventAtlas.findRegion("ookami"));
		event.add("ookami", ookami, Sprite.class);

		// イベント背景のスキン
		TextureRegion spring = new TextureRegion(
				eventAtlas.findRegion("spring"));
		event.add("spring", spring);

		TextureRegion summer = new TextureRegion(
				eventAtlas.findRegion("summer"));
		event.add("summer", summer);

		TextureRegion fall = new TextureRegion(eventAtlas.findRegion("fall"));
		event.add("fall", fall);

		TextureRegion winter = new TextureRegion(
				eventAtlas.findRegion("winter"));
		event.add("winter", winter);

		TextureRegion ie = new TextureRegion(eventAtlas.findRegion("ie"));
		event.add("ie", ie);

		// その他イベントのスキン
		TextureRegion eventback = new TextureRegion(
				eventAtlas.findRegion("eventback"));
		event.add("eventback", eventback);

		TextureRegion waku = new TextureRegion(eventAtlas.findRegion("waku"));
		event.add("waku", waku);

		finishLoad = eventLoad = true;
	}

	private static TextureAtlas batleAtlas;
	public static Skin batle;

	public static void loadBatle() {
		finishLoad = false;
		batleAtlas = new TextureAtlas(Gdx.files.internal("data/batle.pack"));

		// バトル背景、バックのスキン
		TextureRegion batleback = new TextureRegion(
				batleAtlas.findRegion("batleback"));
		batle.add("batleback", batleback);

		TextureRegion spring1 = new TextureRegion(
				batleAtlas.findRegion("spring1"));
		batle.add("spring1", spring1);

		TextureRegion spring2 = new TextureRegion(
				batleAtlas.findRegion("spring2"));
		batle.add("spring2", spring2);

		TextureRegion summer1 = new TextureRegion(
				batleAtlas.findRegion("summer1"));
		batle.add("summer1", summer1);

		TextureRegion summer2 = new TextureRegion(
				batleAtlas.findRegion("summer2"));
		batle.add("summer2", summer2);

		TextureRegion fall1 = new TextureRegion(batleAtlas.findRegion("fall1"));
		batle.add("fall1", fall1);

		TextureRegion fall2 = new TextureRegion(batleAtlas.findRegion("fall2"));
		batle.add("fall2", fall2);

		// エネミーのスキン
		Sprite bat = new Sprite(batleAtlas.findRegion("bat"));
		batle.add("bat", bat, Sprite.class);

		Sprite bear = new Sprite(batleAtlas.findRegion("bear"));
		batle.add("bear", bear);

		Sprite b_gost = new Sprite(batleAtlas.findRegion("bossgost"));
		batle.add("b_gost", b_gost, Sprite.class);

		Sprite b_kuma = new Sprite(batleAtlas.findRegion("bosskuma"));
		batle.add("b_kuma", b_kuma, Sprite.class);

		Sprite b_scor = new Sprite(batleAtlas.findRegion("bossscor"));
		batle.add("b_scor", b_scor, Sprite.class);

		Sprite b_wood = new Sprite(batleAtlas.findRegion("bosswood"));
		batle.add("b_wood", b_wood, Sprite.class);

		Sprite bug = new Sprite(batleAtlas.findRegion("bug"));
		batle.add("bug", bug, Sprite.class);

		Sprite fly = new Sprite(batleAtlas.findRegion("fly"));
		batle.add("fly", fly, Sprite.class);

		Sprite gost = new Sprite(batleAtlas.findRegion("gost"));
		batle.add("gost", gost, Sprite.class);

		Sprite mouse = new Sprite(batleAtlas.findRegion("mouse"));
		batle.add("mouse", mouse, Sprite.class);

		Sprite mush = new Sprite(batleAtlas.findRegion("mush"));
		batle.add("mush", mush, Sprite.class);

		Sprite obake = new Sprite(batleAtlas.findRegion("obake"));
		batle.add("obake", obake, Sprite.class);

		Sprite pumpkin = new Sprite(batleAtlas.findRegion("pumpkin"));
		batle.add("pumpkin", pumpkin, Sprite.class);

		Sprite spiar = new Sprite(batleAtlas.findRegion("spiar"));
		batle.add("spiar", spiar, Sprite.class);

		Sprite wolf = new Sprite(batleAtlas.findRegion("wolf"));
		batle.add("wolf", wolf, Sprite.class);

		Sprite wood = new Sprite(batleAtlas.findRegion("wood"));
		batle.add("wood", wood, Sprite.class);

		// エフェクト、他スキン
		TextureRegion clearbar = new TextureRegion(
				batleAtlas.findRegion("clearbar"));
		batle.add("clearbar", clearbar, TextureRegion.class);

		TextureRegion clearwaku = new TextureRegion(
				batleAtlas.findRegion("clearwaku"));
		batle.add("clearwaku", clearwaku);

		TextureRegion hpbar = new TextureRegion(batleAtlas.findRegion("hpbar"));
		batle.add("hpbar", hpbar, TextureRegion.class);

		TextureRegion hpwaku = new TextureRegion(
				batleAtlas.findRegion("hpwaku"));
		batle.add("hpwaku", hpwaku);

		TextureRegion pause = new TextureRegion(batleAtlas.findRegion("pause"));
		batle.add("pause", pause);

		TextureRegion ready = new TextureRegion(batleAtlas.findRegion("ready"));
		batle.add("ready", ready);

		Animation just = new Animation(0.1f, batleAtlas.findRegions("just"));
		just.setPlayMode(Animation.NORMAL);
		batle.add("just", just, Animation.class);

		Animation hit = new Animation(0.1f, batleAtlas.findRegions("hit"));
		just.setPlayMode(Animation.NORMAL);
		batle.add("hit", hit, Animation.class);

		finishLoad = batleLoad = true;
	}

	public static void loadMusic(int musicNumber) {
		switch (musicNumber) {
		case MORUDAU:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/DieMoldau_Music_Box.mp3"));
			music.setLooping(true);
			break;
		case YUUGURE:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/yuugure.mp3"));
			music.setLooping(true);
			break;
		}
	}

	public static void initAssets() {
		finishLoad = titleLoad = eventLoad = batleLoad = false;
		title = new Skin();
		event = new Skin();
		batle = new Skin();
	}

	public static void dispose() {
		finishLoad = false;

		disTitle();
		disEvent();
		disBatle();
		
		title = event = batle = null;
		TOfont = mikachan = null;

		music.dispose();
	}

	public static void disTitle() {
		if (titleLoad) {
			titleLoad = false;
			titleAtlas.dispose();
			TOfont.dispose();
			mikachan.dispose();
			title.dispose();
		}
	}

	public static void disEvent() {
		if (eventLoad) {
			eventLoad = false;
			eventAtlas.dispose();
			event.dispose();
		}
	}

	public static void disBatle() {
		if (batleLoad) {
			batleLoad = false;
			batleAtlas.dispose();
			batle.dispose();
		}
	}

}

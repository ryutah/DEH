package game.edh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class Assets {
	public static Skin title;
	public static Music music;
	static TextureAtlas titleAtlas;
	static BitmapFont TOfont;
	static BitmapFont mikachan;

	public static final int MORUDAU = 0;
	public static final int YUUGURE = 1;
	public static final int NOISE = 2;
	public static final int AKAIFUUSEN = 3;
	public static final int ANTOINETTEN = 4;
	public static final int HINOKAGERI = 5;
	public static final int CHIISANA = 6;
	public static final int THAIKOV = 7;
	public static final int KAREHA = 8;

	public static Sound[] effect = new Sound[8];

	public static volatile boolean finishLoad = false;
	public static boolean titleLoad = false;

	public static void loadTitle() {
		finishLoad = false;
		title = new Skin();

		titleAtlas = new TextureAtlas(
				Gdx.files.internal("data/images/title.pack"));

		// フォントファイル、ラベルスタイルのスキン
		TOfont = new BitmapFont(Gdx.files.internal("data/font/TOfont.fnt"));
		TOfont.setScale(1.2f);

		LabelStyle lbl = new LabelStyle(TOfont, Color.WHITE);
		title.add("TOfont", lbl, LabelStyle.class);

		mikachan = new BitmapFont(Gdx.files.internal("data/font/mikachan.fnt"));
		mikachan.setScale(1.5f);
		LabelStyle mikaLabel = new LabelStyle(mikachan, Color.WHITE);
		title.add("mikachan", mikaLabel);

		// タイトル画面のバック、各ロゴのスキン
		TextureRegion TBack = new TextureRegion(
				titleAtlas.findRegion("titleback"));
		title.add("titleback", TBack);

		TextureRegionDrawable waku = new TextureRegionDrawable(
				titleAtlas.findRegion("pausemenu"));
		title.add("waku", waku, Drawable.class);

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

		TextureRegionDrawable tanshoku = new TextureRegionDrawable(
				titleAtlas.findRegion("tanshoku"));
		title.add("tanshoku", tanshoku, TextureRegionDrawable.class);

		// ノイズエフェクトのスキン
		TextureRegionDrawable noise = new TextureRegionDrawable(
				titleAtlas.findRegion("noise"));
		title.add("noise", noise);

		TextureRegionDrawable noise_line = new TextureRegionDrawable(
				titleAtlas.findRegion("noise_line"));
		title.add("noise_line", noise_line);

		TextureRegionDrawable noise_dot = new TextureRegionDrawable(
				titleAtlas.findRegion("noise_dot"));
		title.add("noise_dot", noise_dot);

		effect[0] = Gdx.audio.newSound(Gdx.files
				.internal("data/music/effect/kettei.mp3"));

		effect[1] = Gdx.audio.newSound(Gdx.files
				.internal("data/music/effect/itemGet.mp3"));

		effect[2] = Gdx.audio.newSound(Gdx.files
				.internal("data/music/effect/page.mp3"));

		effect[3] = Gdx.audio.newSound(Gdx.files
				.internal("data/music/effect/awa.mp3"));

		effect[4] = Gdx.audio.newSound(Gdx.files
				.internal("data/music/effect/harau.mp3"));

		effect[5] = Gdx.audio.newSound(Gdx.files
				.internal("data/music/effect/kiru.mp3"));

		effect[6] = Gdx.audio.newSound(Gdx.files
				.internal("data/music/effect/ono.mp3"));

		effect[7] = Gdx.audio.newSound(Gdx.files
				.internal("data/music/effect/suzu.mp3"));

		finishLoad = titleLoad = true;
	}

	public static boolean eventLoad = false;
	static TextureAtlas eventAtlas;
	public static Skin event;

	public static void loadEvent() {
		finishLoad = false;
		event = new Skin();

		eventAtlas = new TextureAtlas(
				Gdx.files.internal("data/images/event.pack"));

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

		Sprite s_otona = new Sprite(eventAtlas.findRegion("s_otona"));
		event.add("s_otona", s_otona, Sprite.class);

		// 友人のスキン
		Sprite y_aruku = new Sprite(eventAtlas.findRegion("y_aruku"));
		event.add("y_aruku", y_aruku, Sprite.class);

		Sprite y_miageru = new Sprite(eventAtlas.findRegion("y_miageru"));
		event.add("y_miageru", y_miageru, Sprite.class);

		Sprite y_miorosu = new Sprite(eventAtlas.findRegion("y_miorosu"));
		event.add("y_miorosu", y_miorosu, Sprite.class);

		Sprite y_odoroku = new Sprite(eventAtlas.findRegion("y_odoroku"));
		event.add("y_odoroku", y_odoroku, Sprite.class);

		Sprite y_yokomuki = new Sprite(eventAtlas.findRegion("y_yokomuki"));
		event.add("y_yokomuki", y_yokomuki, Sprite.class);

		TextureRegionDrawable inu = new TextureRegionDrawable(
				eventAtlas.findRegion("inu"));
		event.add("inu", inu, Drawable.class);

		// イベント背景のスキン
		TextureRegionDrawable spring = new TextureRegionDrawable(
				eventAtlas.findRegion("spring"));
		event.add("spring", spring, Drawable.class);

		TextureRegionDrawable summer = new TextureRegionDrawable(
				eventAtlas.findRegion("summer"));
		event.add("summer", summer, Drawable.class);

		TextureRegionDrawable fall = new TextureRegionDrawable(
				eventAtlas.findRegion("fall"));
		event.add("fall", fall, Drawable.class);

		TextureRegionDrawable winter = new TextureRegionDrawable(
				eventAtlas.findRegion("winter"));
		event.add("winter", winter, Drawable.class);

		TextureRegionDrawable past = new TextureRegionDrawable(
				eventAtlas.findRegion("past"));
		event.add("past", past, Drawable.class);

		TextureRegionDrawable ie = new TextureRegionDrawable(
				eventAtlas.findRegion("ie"));
		event.add("ie", ie, Drawable.class);

		// その他イベントのスキン
		TextureRegionDrawable eventback = new TextureRegionDrawable(
				eventAtlas.findRegion("eventback"));
		event.add("eventback", eventback, Drawable.class);

		finishLoad = eventLoad = true;
	}

	public static boolean gamesLoad = false;
	static boolean gamesBaseLoad = false;

	public static Skin games;
	static TextureAtlas gamesAtlas;

	public static void loadGames(int stageNum) {
		finishLoad = false;

		if (!gamesBaseLoad) {
			// キャラクターのスキン
			games = new Skin();
			gamesAtlas = new TextureAtlas(
					Gdx.files.internal("data/images/games.pack"));

			Animation ue = new Animation(0.2f, gamesAtlas.findRegions("ue"));
			ue.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
			Animation shita = new Animation(0.2f,
					gamesAtlas.findRegions("sita"));
			shita.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
			Animation hidari = new Animation(0.2f,
					gamesAtlas.findRegions("hidari"));
			hidari.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
			Animation migi = new Animation(0.2f, gamesAtlas.findRegions("migi"));
			migi.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
			games.add("ue", ue, Animation.class);
			games.add("shita", shita, Animation.class);
			games.add("hidari", hidari, Animation.class);
			games.add("migi", migi, Animation.class);

			TextureRegion inu_hidari = gamesAtlas.findRegion("inu_hidari");
			games.add("inu_hidari", inu_hidari, TextureRegion.class);
			TextureRegion inu_migi = gamesAtlas.findRegion("inu_migi");
			games.add("inu_migi", inu_migi, TextureRegion.class);
			TextureRegion inu_shita = gamesAtlas.findRegion("inu_shita");
			games.add("inu_shita", inu_shita, TextureRegion.class);
			TextureRegion inu_ue = gamesAtlas.findRegion("inu_ue");
			games.add("inu_ue", inu_ue, TextureRegion.class);

			// ゲームアイテム等のスキン
			TextureRegionDrawable memo = new TextureRegionDrawable(
					gamesAtlas.findRegion("memo"));
			games.add("memo", memo, TextureRegionDrawable.class);

			TextureRegionDrawable memo_back = new TextureRegionDrawable(
					gamesAtlas.findRegion("memo_back"));
			games.add("memo_back", memo_back, TextureRegionDrawable.class);

			TextureRegionDrawable nabe = new TextureRegionDrawable(
					gamesAtlas.findRegion("nabe"));
			games.add("nabe", nabe, TextureRegionDrawable.class);

			TextureRegionDrawable key = new TextureRegionDrawable(
					gamesAtlas.findRegion("Key"));
			games.add("key", key, TextureRegionDrawable.class);

			TextureRegionDrawable kinomi1 = new TextureRegionDrawable(
					gamesAtlas.findRegion("kinomi1"));
			games.add("kinomi1", kinomi1, TextureRegionDrawable.class);

			TextureRegionDrawable kinomi4 = new TextureRegionDrawable(
					gamesAtlas.findRegion("kinomi4"));
			games.add("kinomi4", kinomi4);

			TextureRegionDrawable hana = new TextureRegionDrawable(
					gamesAtlas.findRegion("hana"));
			games.add("hana", hana, TextureRegionDrawable.class);

			TextureRegionDrawable kusa = new TextureRegionDrawable(
					gamesAtlas.findRegion("kusa"));
			games.add("kusa", kusa, TextureRegionDrawable.class);

			TextureRegionDrawable ryouri = new TextureRegionDrawable(
					gamesAtlas.findRegion("ryouri"));
			games.add("ryouri", ryouri, TextureRegionDrawable.class);

			TextureRegionDrawable sara = new TextureRegionDrawable(
					gamesAtlas.findRegion("sara"));
			games.add("sara", sara, TextureRegionDrawable.class);

			TextureRegionDrawable ningyoAka = new TextureRegionDrawable(
					gamesAtlas.findRegion("ningyoAka"));
			games.add("ningyoAka", ningyoAka, TextureRegionDrawable.class);

			TextureRegionDrawable ningyoAo = new TextureRegionDrawable(
					gamesAtlas.findRegion("ningyoAo"));
			games.add("ningyoAo", ningyoAo, TextureRegionDrawable.class);

			TextureRegionDrawable inu = new TextureRegionDrawable(
					gamesAtlas.findRegion("inu"));
			games.add("inu", inu, TextureRegionDrawable.class);

			TextureRegionDrawable bou = new TextureRegionDrawable(
					gamesAtlas.findRegion("bou"));
			games.add("bou", bou, TextureRegionDrawable.class);

			TextureRegionDrawable tsurizao = new TextureRegionDrawable(
					gamesAtlas.findRegion("turizao"));
			games.add("tsurizao", tsurizao, TextureRegionDrawable.class);

			TextureRegionDrawable mTsurizao = new TextureRegionDrawable(
					gamesAtlas.findRegion("map_tsurizao"));
			games.add("mTsurizao", mTsurizao, TextureRegionDrawable.class);

			TextureRegionDrawable spice = new TextureRegionDrawable(
					gamesAtlas.findRegion("spice"));
			games.add("spice", spice, TextureRegionDrawable.class);

			TextureRegionDrawable taru = new TextureRegionDrawable(
					gamesAtlas.findRegion("taru"));
			games.add("taru", taru, TextureRegionDrawable.class);

			TextureRegionDrawable taru_b = new TextureRegionDrawable(
					gamesAtlas.findRegion("taru_b"));
			games.add("taru_b", taru_b, TextureRegionDrawable.class);

			TextureRegionDrawable kirikabu = new TextureRegionDrawable(
					gamesAtlas.findRegion("kirikabu"));
			games.add("kirikabu", kirikabu, TextureRegionDrawable.class);

			TextureRegionDrawable kirikabu_yuki = new TextureRegionDrawable(
					gamesAtlas.findRegion("kirikabu_yuki"));
			games.add("kirikabu_yuki", kirikabu_yuki,
					TextureRegionDrawable.class);

			TextureRegionDrawable maruta = new TextureRegionDrawable(
					gamesAtlas.findRegion("maruta"));
			games.add("maruta", maruta, TextureRegionDrawable.class);

			TextureRegionDrawable butter = new TextureRegionDrawable(
					gamesAtlas.findRegion("butter"));
			games.add("butter", butter, TextureRegionDrawable.class);

			TextureRegionDrawable houcho = new TextureRegionDrawable(
					gamesAtlas.findRegion("houcho"));
			games.add("houcho", houcho, TextureRegionDrawable.class);

			TextureRegionDrawable mapTsurizao = new TextureRegionDrawable(
					gamesAtlas.findRegion("map_tsurizao"));
			games.add("mapTsurizao", mapTsurizao, TextureRegionDrawable.class);

			TextureRegionDrawable nasu = new TextureRegionDrawable(
					gamesAtlas.findRegion("nasu"));
			games.add("nasu", nasu, TextureRegionDrawable.class);

			TextureRegionDrawable ninjin = new TextureRegionDrawable(
					gamesAtlas.findRegion("ninjin"));
			games.add("ninjin", ninjin, TextureRegionDrawable.class);

			TextureRegionDrawable sakana = new TextureRegionDrawable(
					gamesAtlas.findRegion("sakana"));
			games.add("sakana", sakana, TextureRegionDrawable.class);

			TextureRegionDrawable shaberu = new TextureRegionDrawable(
					gamesAtlas.findRegion("shaberu"));
			games.add("shaberu", shaberu, TextureRegionDrawable.class);

			TextureRegionDrawable kanazuti = new TextureRegionDrawable(
					gamesAtlas.findRegion("kanazuti"));
			games.add("kanazuti", kanazuti, TextureRegionDrawable.class);

			TextureRegionDrawable solt = new TextureRegionDrawable(
					gamesAtlas.findRegion("solt"));
			games.add("solt", solt, TextureRegionDrawable.class);

			TextureRegionDrawable oil = new TextureRegionDrawable(
					gamesAtlas.findRegion("oil"));
			games.add("oil", oil, TextureRegionDrawable.class);

			TextureRegionDrawable tamanegi = new TextureRegionDrawable(
					gamesAtlas.findRegion("tamanegi"));
			games.add("tamanegi", tamanegi, TextureRegionDrawable.class);

			TextureRegionDrawable tamago = new TextureRegionDrawable(
					gamesAtlas.findRegion("tamago"));
			games.add("tamago", tamago, TextureRegionDrawable.class);

			TextureRegionDrawable tomato = new TextureRegionDrawable(
					gamesAtlas.findRegion("tomato"));
			games.add("tomato", tomato, TextureRegionDrawable.class);

			TextureRegionDrawable tebukuro = new TextureRegionDrawable(
					gamesAtlas.findRegion("tebukuro"));
			games.add("tebukuro", tebukuro, TextureRegionDrawable.class);

			TextureRegionDrawable kakashi = new TextureRegionDrawable(
					gamesAtlas.findRegion("kakashi"));
			games.add("kakashi", kakashi, TextureRegionDrawable.class);

			TextureRegionDrawable kinoko = new TextureRegionDrawable(
					gamesAtlas.findRegion("kinoko"));
			games.add("kinoko", kinoko, TextureRegionDrawable.class);

			TextureRegionDrawable haka = new TextureRegionDrawable(
					gamesAtlas.findRegion("haka"));
			games.add("haka", haka, TextureRegionDrawable.class);

			TextureRegionDrawable haka_hana = new TextureRegionDrawable(
					gamesAtlas.findRegion("haka_hana"));
			games.add("haka_hana", haka_hana, TextureRegionDrawable.class);

			TextureRegionDrawable bed = new TextureRegionDrawable(
					gamesAtlas.findRegion("bed"));
			games.add("bed", bed, TextureRegionDrawable.class);

			TextureRegionDrawable hako = new TextureRegionDrawable(
					gamesAtlas.findRegion("hako"));
			games.add("hako", hako, TextureRegionDrawable.class);

			TextureRegionDrawable tsukue1 = new TextureRegionDrawable(
					gamesAtlas.findRegion("tsukue1"));
			games.add("tsukue1", tsukue1, TextureRegionDrawable.class);

			TextureRegionDrawable tsukue2 = new TextureRegionDrawable(
					gamesAtlas.findRegion("tsukue2"));
			games.add("tsukue2", tsukue2, TextureRegionDrawable.class);

			TextureRegionDrawable tana1 = new TextureRegionDrawable(
					gamesAtlas.findRegion("tana1"));
			games.add("tana1", tana1, TextureRegionDrawable.class);

			TextureRegionDrawable tana2 = new TextureRegionDrawable(
					gamesAtlas.findRegion("tana2"));
			games.add("tana2", tana2, TextureRegionDrawable.class);

			TextureRegionDrawable yukidaruma = new TextureRegionDrawable(
					gamesAtlas.findRegion("yukidaruma"));
			games.add("yukidaruma", yukidaruma, TextureRegionDrawable.class);

			// ゲームのUI等のスキン
			TextureRegionDrawable back = new TextureRegionDrawable(
					gamesAtlas.findRegion("gameback"));
			games.add("gameback", back, TextureRegionDrawable.class);

			TextureRegionDrawable b_modoru_up = new TextureRegionDrawable(
					gamesAtlas.findRegion("b_modoru_up"));
			TextureRegionDrawable b_modoru_down = new TextureRegionDrawable(
					gamesAtlas.findRegion("b_modoru_down"));
			ButtonStyle b_modoru = new ButtonStyle(b_modoru_up, b_modoru_down,
					b_modoru_up);
			games.add("b_modoru", b_modoru, ButtonStyle.class);

			TextureRegionDrawable b_kansei_up = new TextureRegionDrawable(
					gamesAtlas.findRegion("b_kansei_up"));
			TextureRegionDrawable b_kansei_down = new TextureRegionDrawable(
					gamesAtlas.findRegion("b_kansei_down"));
			ButtonStyle b_kansei = new ButtonStyle(b_kansei_up, b_kansei_down,
					b_kansei_up);
			games.add("b_kansei", b_kansei, ButtonStyle.class);

			TextureRegionDrawable b_yes_up = new TextureRegionDrawable(
					gamesAtlas.findRegion("b_yes_up"));
			TextureRegionDrawable b_yes_down = new TextureRegionDrawable(
					gamesAtlas.findRegion("b_yes_down"));
			ButtonStyle b_yes = new ButtonStyle(b_yes_up, b_yes_down,
					b_yes_down);
			games.add("b_yes", b_yes, ButtonStyle.class);

			TextureRegionDrawable b_no_up = new TextureRegionDrawable(
					gamesAtlas.findRegion("b_no_up"));
			TextureRegionDrawable b_no_down = new TextureRegionDrawable(
					gamesAtlas.findRegion("b_no_down"));
			ButtonStyle b_no = new ButtonStyle(b_no_up, b_no_down, b_no_down);
			games.add("b_no", b_no, ButtonStyle.class);

			// タッチパッドのスキン
			TextureRegionDrawable pad = new TextureRegionDrawable(
					gamesAtlas.findRegion("touchPad"));
			TextureRegionDrawable knob = new TextureRegionDrawable(
					gamesAtlas.findRegion("knob"));
			TouchpadStyle style = new TouchpadStyle(pad, knob);
			games.add("touchpad", style, TouchpadStyle.class);

			games.add("black", pad, Drawable.class);

			gamesBaseLoad = true;
		}

		loadMap(stageNum);

		finishLoad = true;
	}

	static boolean mapLoad = false;

	public static Skin map;
	static Array<TiledMap> maps;

	static void loadMap(int stageNum) {
		TmxMapLoader loader = new TmxMapLoader();
		map = new Skin();
		maps = new Array<TiledMap>();

		TiledMap house = loader.load("map/house.tmx");
		map.add("house", house, TiledMap.class);
		maps.add(house);

		switch (stageNum) {
		case 1:
			TiledMap stage1 = loader.load("map/stage1.tmx");
			map.add("stage1", stage1, TiledMap.class);
			maps.add(stage1);
			break;

		case 2:
			TiledMap stage2 = loader.load("map/stage2.tmx");
			map.add("stage2", stage2, TiledMap.class);
			maps.add(stage2);

			TiledMap stage2_2 = loader.load("map/stage2_2.tmx");
			map.add("stage2_2", stage2_2, TiledMap.class);
			maps.add(stage2_2);

			TiledMap stage2_3 = loader.load("map/stage2_3.tmx");
			map.add("stage2_3", stage2_3, TiledMap.class);
			maps.add(stage2_3);

			TiledMap mayoinomiri = loader.load("map/mayoinomori.tmx");
			map.add("mayoinomori", mayoinomiri, TiledMap.class);
			maps.add(mayoinomiri);

			TiledMap mizuumi = loader.load("map/mizuumi.tmx");
			map.add("mizuumi", mizuumi, TiledMap.class);
			maps.add(mizuumi);
			break;

		case 3:
			TiledMap stage3 = loader.load("map/stage3.tmx");
			map.add("stage3", stage3, TiledMap.class);
			maps.add(stage3);

			TiledMap stage3_2 = loader.load("map/stage3_2.tmx");
			map.add("stage3_2", stage3_2, TiledMap.class);
			maps.add(stage3_2);

			TiledMap stage3_3 = loader.load("map/stage3_3.tmx");
			map.add("stage3_3", stage3_3, TiledMap.class);
			maps.add(stage3_3);

			TiledMap stage3_4 = loader.load("map/stage3_4.tmx");
			map.add("stage3_4", stage3_4, TiledMap.class);
			maps.add(stage3_4);

			TiledMap stage3_5 = loader.load("map/stage3_5.tmx");
			map.add("stage3_5", stage3_5, TiledMap.class);
			maps.add(stage3_5);
			break;

		case 4:
			TiledMap stage4 = loader.load("map/stage4.tmx");
			map.add("stage4", stage4, TiledMap.class);
			maps.add(stage4);

			TiledMap stage4_2 = loader.load("map/stage4_2.tmx");
			map.add("stage4_2", stage4_2, TiledMap.class);
			maps.add(stage4_2);

			TiledMap stage4_3 = loader.load("map/stage4_3.tmx");
			map.add("stage4_3", stage4_3, TiledMap.class);
			maps.add(stage4_3);

			TiledMap stage4_4 = loader.load("map/stage4_4.tmx");
			map.add("stage4_4", stage4_4, TiledMap.class);
			maps.add(stage4_4);

			TiledMap stage4_house = loader.load("map/stage4_house.tmx");
			map.add("stage4_house", stage4_house, TiledMap.class);
			maps.add(stage4_house);
			break;
		}

		mapLoad = true;
	}

	public static void loadMusic(int musicNumber) {
		switch (musicNumber) {
		case MORUDAU:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/DieMoldau_Music_Box.mp3"));
			break;
		case YUUGURE:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/yuugure.mp3"));
			break;
		case NOISE:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/noise.mp3"));
			break;
		case AKAIFUUSEN:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/akaifuusen.mp3"));
			break;
		case ANTOINETTEN:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/antoinettenoniwa.mp3"));
			break;
		case HINOKAGERI:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/hinokageri_orchestra.mp3"));
			break;
		case CHIISANA:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/chiisanayorunokanashimi.mp3"));
			break;
		case THAIKOV:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/tchaikovsky.mp3"));
			break;
		case KAREHA:
			music = Gdx.audio.newMusic(Gdx.files
					.internal("data/music/kareha.mp3"));
		}

		music.setLooping(true);
	}

	public static void initAssets() {
		finishLoad = titleLoad = eventLoad = false;
	}

	public static void dispose() {
		finishLoad = false;

		disTitle();
		disEvent();
		disGames();
		disStage();

		if (music != null)
			music.dispose();
		music = null;
	}

	public static void disTitle() {
		if (titleLoad) {
			titleLoad = false;
			titleAtlas.dispose();
			TOfont.dispose();
			mikachan.dispose();
			title.dispose();
			for (int i = 0; i < effect.length; i++)
				effect[i].dispose();
		}

		titleAtlas = null;
		title = null;
		TOfont = mikachan = null;
	}

	public static void disEvent() {
		if (eventLoad) {
			eventLoad = false;
			eventAtlas.dispose();
			event.dispose();
		}

		eventAtlas = null;
		event = null;
	}

	public static void disGames() {
		if (gamesBaseLoad) {
			gamesBaseLoad = false;
			gamesAtlas.dispose();
			games.dispose();
		}

		gamesAtlas = null;
		games = null;
	}

	public static void disStage() {
		if (mapLoad) {
			mapLoad = false;
			map.dispose();

			for (TiledMap map : maps) {
				map.dispose();
			}
			maps.clear();
		}
		map = null;
	}

}

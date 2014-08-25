package game.edh.event.actor;

import game.edh.Assets;
import game.edh.EdhGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class CresitGroup extends Group {
	String text1 = "素材提供サイト様";
	String text2 = "マップチップ、キャラチップ\n\n"
			+ "First Seed Material(現在閉鎖中)\n"
			+ "http://www.tekepon.net/fsm/";
	String text3 = "フォント\n\n"
			+ "オリジナルフォント みかちゃん\n"
			+ "http://www001.upp.so-net.ne.jp/mikachan/";
	String text4 = "アイテム、その他ゲーム画像\n\n"
			+ "First Seed Material(現在閉鎖中)\n"
			+ "http://www.tekepon.net/fsm/\n\n"
			+ "化け猫缶 素材屋\n"
			+ "http://neko.moo.jp/BS/\n\n"
			+ "小さい童話箱\n"
			+ "http://inabausa.s81.xrea.com/haihu/haihu.html\n\n"
			+ "素材のプチッチ\n"
			+ "http://putiya.com/index.html";

	String text5 = "効果音\n\n"
			+ "On-Jin ～音人～\n"
			+ "http://on-jin.com/";

	String text6 = "イベントキャラクター、背景\n\n"
			+ "SILHUIETTE DESIGN\n"
			+ "http://kage-design.com/wp/";

	String text7 = "BGM\n\n"
			+ "甘茶の音楽工房\n"
			+ "http://amachamusic.chagasi.com/"
			+ "「赤い風船とメリーゴーランド」\n"
			+ "「アントワネットの庭」\n"
			+ "「チャイコフスキー 風の旋律」\n"
			+ "「日の陰り(オーケストラ版)」\n"
			+ "「枯葉」\n"
			+ "「夕暮れのメリーゴーランド」\n\n"
			+ "音楽研究会\n"
			+ "http://www.asahi-net.or.jp/~HB9T-KTD/music/musj.html\n"
			+ "「DieMoldau_Music_Box」";

	String text8 = "その他\n"
			+ "画面ノイズ\n\n"
			+ "回想領域\n"
			+ "http://kaisou-ryouiki.sakura.ne.jp/\n\n\n"
			+ "背景\n\n"
			+ "Re:vre\n"
			+ "http://inabausa.s81.xrea.com/haihu/haihu.html\n\n\n"
			+ "フレーム素材\n\n"
			+ "Frame Design\n"
			+ "http://frames-design.com/\n\n\n"
			+ "フレームワーク\n\n"
			+ "libGDX\n"
			+ "http://libgdx.badlogicgames.com/";

	String text9 = "E N D";

	Table table;

	public CresitGroup() {
		// TODO 自動生成されたコンストラクター・スタブ
		setStage(EdhGame.stage);
		setBounds(0, 0, 432, 768);
		Image image = new Image(Assets.title.get("tanshoku", TextureRegionDrawable.class));
		image.setColor(Color.BLACK);
		image.setFillParent(true);
		addActor(image);

		table = new Table();
		table.setFillParent(true);
		table.setPosition(0, -1500);
		table.align(Align.left);
		addActor(table);

		LabelStyle style = Assets.title.get("mikachan", LabelStyle.class);

		table.defaults().width(370).padLeft(40).spaceBottom(50);

		Label label1 = new Label(text1, style);
		label1.setWrap(true);
		Label label2 = new Label(text2, style);
		label2.setWrap(true);
		Label label3 = new Label(text3, style);
		label3.setWrap(true);
		Label label4 = new Label(text4, style);
		label4.setWrap(true);
		Label label5 = new Label(text5, style);
		label5.setWrap(true);
		Label label6 = new Label(text6, style);
		label6.setWrap(true);
		Label label7 = new Label(text7, style);
		label7.setWrap(true);
		Label label8 = new Label(text8, style);
		label8.setWrap(true);
		Label label9 = new Label(text9, style);
		label9.setFontScale(2);
		label9.setWrap(true);

		table.add(label1).spaceBottom(100).row();
		table.add(label2).row();
		table.add(label3).row();
		table.add(label4).row();
		table.add(label5).row();
		table.add(label6).row();
		table.add(label7).row();
		table.add(label8).row();
		table.defaults().reset();
		table.align(Align.center).add(label9).center().spaceTop(500).row();
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		float y = table.getY();
		float pos = y + delta * 50;
		table.setY(pos);
		if(table.getY() >= 1400)
			table.setY(1400);
		super.act(delta);
	}
}

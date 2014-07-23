package game.edh.game.model.frame.event;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.items.ItemsHandler;

public abstract class EventRyouri extends ModelEvent {
	protected final int SPICE = 0;
	protected final int SOLT = 1;
	protected final int BUTTER = 2;
	protected final int NASU = 3;
	protected final int NINJIN = 4;
	protected final int TAMANEGI = 5;
	protected final int TOMATO = 6;
	protected final int KINOMI = 7;
	protected final int KUSA = 8;
	protected final int KINOKO = 9;
	protected final int SAKANA = 10;
	protected final int TAMAGO = 11;
	protected final int OIL = 12;

	Array<ModelEventObj> tableObj;
	int[] colectId;
	protected int[] inId;

	class ButtonKansei extends ModelEventObj {
		public ButtonKansei(ModelEvent parent) {
			// TODO 自動生成されたコンストラクター・スタブ
			super(parent, ObjType.Button);
			setPosition(5.8f, 1);
			setSize(3);
			setButtonStyle(Assets.games, "b_kansei");
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			((EventRyouri) parent).kansei();
		}
		
	}

	class Nabe extends ModelEventObj {
		public Nabe(ModelEvent parent) {
			// TODO 自動生成されたコンストラクター・スタブ
			super(parent, ObjType.Image);
			setDrawable(Assets.games, "nabe");
			setCenterX(true);
			setY(3);
			setSize(5);
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			world.textEvent("鍋に料理を入れれば何か料理が作れそう");
		}
		

		@Override
		protected boolean flingAction(float velocityX, float velocityY) {
			// TODO 自動生成されたメソッド・スタブ
			return false;
		}
		
		@Override
		protected boolean longTapAction() {
			// TODO 自動生成されたメソッド・スタブ
			return false;
		}
	}

	public EventRyouri(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		tableObj = new Array<ModelEventObj>();

		ModelEventObj kansei = new ButtonKansei(this);
		addObjs(kansei);
		ModelEventObj modoru = new ButtonModoru(this);
		modoru.setX(2);
		addObjs(modoru);
		ModelEventObj nabe = new Nabe(this);
		addObjs(nabe);

		addTableObj(SPICE, "胡椒", "spice");
		addTableObj(SOLT, "塩", "solt");
		addTableObj(OIL, "オリーブオイル", "oil");
		addTableObj(BUTTER, "バター", "butter");
		addTableObj(NASU, "なす", "nasu");
		addTableObj(NINJIN, "にんじん", "ninjin");
		addTableObj(TAMANEGI, "たまねぎ", "tamanegi");
		addTableObj(TOMATO, "トマト", "tomato");
	}

	public void addTableObj(int id, String name, String drawableName) {
		EventRyouriTableObj obj = new EventRyouriTableObj(this);
		obj.setParam(id, name, drawableName);
		tableObj.add(obj);
	}

	public void inShokuzai(EventRyouriTableObj shokuzai) {
		EdhGame.music.playEffect(EfftctType.AWA, false);
		world.textEvent(shokuzai.getName() + "を入れた");
		addInId(shokuzai.getId());
	}

	public void setColectId(int[] ids) {
		colectId = ids;
		Arrays.sort(colectId);
		for(int i : ids) {
			Gdx.app.log("SEIKAI", i + "");
		}
	}

	void addInId(int id) {
		if (inId == null) {
			inId = new int[1];
			inId[0] = id;
		} else {
			int[] buf = inId;
			inId = Arrays.copyOf(buf, buf.length + 1);
			inId[inId.length - 1] = id;
			Arrays.sort(inId);
		}
		for(int i : inId) {
			Gdx.app.log("IN", i + "");
		}
	}

	public void kansei() {
		boolean b = world.getItems().findItem(ItemsHandler.RYOURI_SEIKO);
		boolean b2 = world.getItems().findItem(ItemsHandler.RYOURI_SHIPPAI);

		if (b || b2) {
			world.textEvent("今は料理を作れない");
		} else {
			world.textEvent("料理を作った");

			boolean check = Arrays.equals(colectId, inId);

			if (check)
				seikou();
			else
				shippai();
		}
	}

	protected void seikou() {
		world.addItem(ItemsHandler.RYOURI_SEIKO);
	}

	protected void shippai() {
		world.addItem(ItemsHandler.RYOURI_SHIPPAI);
	}

	public Array<ModelEventObj> getTableObj() {
		return tableObj;
	}
}

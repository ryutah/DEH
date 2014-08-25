package game.edh.title.actor;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.frame.BaseClickAction;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;
import game.edh.game.actor.ActorTouchPad;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class PadSettingTable extends BaseTable {

	class SizeSlider extends Slider {
		public SizeSlider() {
			// TODO 自動生成されたコンストラクター・スタブ
			super(80, 120, 1, false, Assets.title);
			setSize(300, 70);
			setCenterPosition(216, 400);
			setValue(EdhGame.settings.padSize * 100);
		}
	}

	class XposSlider extends Slider {

		public XposSlider() {
			super(116, 316, 1, false, Assets.title);
			// TODO 自動生成されたコンストラクター・スタブ
			setSize(300, 70);
			setCenterPosition(216, 300);
			setValue(EdhGame.settings.padX);
		}
	}

	class YposSlider extends Slider {

		public YposSlider() {
			super(90, 216, 1, false, Assets.title);
			// TODO 自動生成されたコンストラクター・スタブ
			setSize(300, 70);
			setCenterPosition(216, 200);
			setValue(EdhGame.settings.padY);
		}

	}

	Slider slider, xSlider, ySlider;
	ActorTouchPad pad;

	public PadSettingTable(BaseScreen screen, Table mainTable) {
		super(screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(0, 0, 432, 500);

		slider = new SizeSlider();
		xSlider = new XposSlider();
		ySlider = new YposSlider();

		Label size = new Label("SIZE", Assets.title, "TOfont");
		size.setColor(Color.BLACK);
		size.setFontScale(.8f);
		Label x = new Label("X", Assets.title, "TOfont");
		x.setColor(Color.BLACK);
		x.setFontScale(.8f);
		Label y = new Label("Y", Assets.title, "TOfont");
		y.setColor(Color.BLACK);
		y.setFontScale(.8f);
		defaults().spaceLeft(50).spaceTop(30);
		top().add(size);
		add(slider).height(50).width(250).row();
		add(x);
		add(xSlider).height(50).width(250).row();
		add(y);
		add(ySlider).height(50).width(250);

		pad = new ActorTouchPad();
		addActor(pad);

		Image back = new Image(Assets.title.getRegion("back"));
		back.addListener(new BaseClickAction(back) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				EdhGame.save();
				changeTable(new SettingTable(PadSettingTable.this.screen,
						PadSettingTable.this.mainTable));
			}
		});
		back.setCenterPosition(216, 700);
		back.setColor(Color.BLACK);
		addActor(back);

		Label defa = new Label("DEFAULT", Assets.title, "TOfont");
		defa.setCenterPosition(216, 580);
		defa.setColor(Color.BLACK);
		defa.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				padDefault();
			}
		});
		addActor(defa);
	}

	void padDefault() {
		slider.setValue(100);
		xSlider.setValue(216);
		ySlider.setValue(114);
		pad.setSize(slider.getValue() / 100f);
		pad.setPadX(xSlider.getValue());
		pad.setPadY(ySlider.getValue());
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		if (slider.isDragging()) {
			pad.setSize(slider.getValue() / 100f);
		}
		if (xSlider.isDragging()) {
			pad.setPadX(xSlider.getValue());
		}
		if (ySlider.isDragging()) {
			pad.setPadY(ySlider.getValue());
		}
	}

	@Override
	public void changeTable(BaseTable table) {
		// TODO 自動生成されたメソッド・スタブ
		super.changeTable(table);
		EdhGame.settings.savePadSettings(xSlider.getValue(),
				ySlider.getValue(), slider.getValue() / 100f);
		EdhGame.save();
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		changeTable(new SettingTable(screen, mainTable));
	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ

	}

}

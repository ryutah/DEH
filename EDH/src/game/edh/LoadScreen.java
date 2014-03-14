package game.edh;

import game.edh.frame.BaseScreen;

public class LoadScreen extends BaseScreen {
	public static enum NextScreen {
		Title,
		Event,
		Batle
	}
	
	EdhGame edh;
	
	private NextScreen next;
	
	public LoadScreen(EdhGame edh, NextScreen next) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(edh, 432, 768);
		this.edh = edh;
		this.next = next;
	}
	
	private void AssetsLoad() {
		switch (next) {
		case Title:
			if(!Assets.titleLoad)
				Assets.loadTitle();
			break;
			
		case Event:
			if(!Assets.eventLoad)
				Assets.loadEvent();
			break;
		
		case Batle:
			if(!Assets.batleLoad)
				Assets.loadBatle();
			break;
		}
	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(Assets.finishLoad) {
			switch (next) {
			case Title:
				edh.setScreen(new TitleScreen(edh, 432, 768));
				break;
				
			case Event:
				edh.setScreen(new EventTest(edh, 432, 768));
				break;
				
			case Batle:
				edh.setScreen(new GameTest(edh, 432, 768));
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void show() {
		// TODO 自動生成されたメソッド・スタブ
		AssetsLoad();
	}

	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}

}

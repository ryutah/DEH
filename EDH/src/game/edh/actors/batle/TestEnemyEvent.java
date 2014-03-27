package game.edh.actors.batle;

import com.badlogic.gdx.scenes.scene2d.Event;

public class TestEnemyEvent extends Event{
	public static class AtackEvent extends TestEnemyEvent {
		public float getDamege() {
			TestEnemyActor enemy = (TestEnemyActor) getTarget();
			return enemy.Atack;
		}
	}

}

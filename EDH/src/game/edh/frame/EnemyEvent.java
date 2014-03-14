package game.edh.frame;

import game.edh.EnemyActor;

import com.badlogic.gdx.scenes.scene2d.Event;

public class EnemyEvent extends Event{
	public static class AtackEvent extends EnemyEvent {
		public float getDamege() {
			EnemyActor enemy = (EnemyActor) getTarget();
			return enemy.Atack;
		}
	}

}

package br.com.zort.view.battle
{
	import br.com.zort.model.Skill;
	
	import flash.events.Event;

	public class BattleEvent extends Event
	{
		public static const SKILLSTART:String = "skillStart";
		public static const SKILLEND:String = "skillEnd";

		public var skill:Skill;

		public function BattleEvent(type:String, skill:Skill bubbles:Boolean = false, cancelable:Boolean = false)
		{
			super(type, bubbles, cancelable);
			this.skill = skill;
		}
	}
}
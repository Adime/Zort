package br.com.zort.event
{
	import br.com.zort.model.Skill;

	import flash.events.Event;

	public class SkillEvent extends Event
	{
		public static const SKILL_DONE:String = "skillDone";
		public static const SKILL_START:String = "skillStart";

		public var skill:Skill;

		public function SkillEvent(type:String, skill:Skill, bubbles:Boolean = false, cancelable:Boolean = false)
		{
			super(type, bubbles, cancelable);
			this.skill = skill;
		}

		override public function clone():Event
		{
			var e:SkillEvent = new SkillEvent(type, skill, bubbles, cancelable);
			return e;
		}
	}
}
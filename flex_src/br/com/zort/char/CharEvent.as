package br.com.zort.char
{
	import br.com.zort.model.Person;

	import flash.events.Event;

	public class CharEvent extends Event
	{
		public static const BATTLE:String = "battle";

		public var person:Person;

		public function CharEvent(type:String, person:Person, bubbles:Boolean = false, cancelable:Boolean = false)
		{
			super(type, bubbles, cancelable);
			this.person = person;
		}

		override public function clone():Event
		{
			return new CharEvent(type, person, bubbles, cancelable);
		}
	}
}
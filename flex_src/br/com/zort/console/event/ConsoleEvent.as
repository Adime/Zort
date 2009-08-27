package br.com.zort.console.event
{
	import flash.events.Event;

	public class ConsoleEvent extends Event
	{
		public static const TYPE_TEXT:String = "typeText";

		public var data:Object;

		public function ConsoleEvent(type:String, data:Object, bubbles:Boolean = false, cancelable:Boolean = false)
		{
			super(type, bubbles, cancelable);
			this.data = data;
		}

	}
}
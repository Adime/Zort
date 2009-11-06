package br.com.zort.messaging.event
{
	import flash.events.Event;

	public class MessagingEvent extends Event
	{
		public var classes:Array;

		public function MessagingEvent(type:String, bubbles:Boolean = false, cancelable:Boolean = false)
		{
			super(type, bubbles, cancelable);
		}

	}
}
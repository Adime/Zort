package br.com.zort.map.event
{
	import flash.events.Event;

	public class MapEvent extends Event
	{
		public static const TELEPORT:String = "teleport";
		public static const CHAR_MOVE:String = "charMove";
		public static const CHAR_DANCE:String = "charDance";
		public static const CHAR_INITIALIZE:String = "charInitialize";

		public var data:Object;

		public function MapEvent(type:String, data:Object, bubbles:Boolean = false, cancelable:Boolean = false)
		{
			super(type, bubbles, cancelable);
			this.data = data;
		}

	}
}
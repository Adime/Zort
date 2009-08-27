package br.com.zort.model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="br.com.zort.model.Robot")]
	[Bindable]
	public class Robot
	{
		public var id:int;
		public var hp:int;
		public var level:int;
		public var image:String;

		public var head:Item;
		public var body:Item;
		public var leftHand:Item;
		public var rightHand:Item;
		public var legs:Item;
		public var feet:Item;

		public var skills:ArrayCollection;
	}
}
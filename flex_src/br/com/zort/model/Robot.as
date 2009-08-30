package br.com.zort.model
{
	import br.com.zort.helper.StringHelper;

	import mx.collections.ArrayCollection;

	[RemoteClass(alias="br.com.zort.model.Robot")]
	[Bindable]
	public class Robot implements IProtocol
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

		public function generateProtocol():String
		{
			return StringHelper.parseIt(getClassName(), this.id);
		}

		public function fillFromProtocol(protocol:String):*
		{
			var array:Array = protocol.split(';');

			this.id = array[1];

			return this;
		}

		public function getClassName():String
		{
			return "$ROBOT";
		}
	}
}
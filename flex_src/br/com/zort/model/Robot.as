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
		
		//aux methods
		
		private function calculate(field:String):int
		{
			var aux:int = 0;
			aux += update(head, field);
			aux += update(body, field);
			aux += update(leftHand, field);
			aux += update(rightHand, field);
			aux += update(legs, field);
			aux += update(feet, field);
			
			return aux;
		}

		private function update(i:Item, field:String):int
		{
			if(i != null)
			{
				return i[field];
			}
			return 0;
		}
		public function get attack():int
		{
			return calculate("attack");
		}
		public function get defense():int
		{
			return calculate("defense");
		}
	}
}
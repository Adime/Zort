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
		public var experience:int;
		public var image:String;
		public var nome:String;

		public var head:Item;
		public var body:Item;
		public var leftHand:Item;
		public var rightHand:Item;
		public var legs:Item;
		public var feet:Item;

		public var skills:ArrayCollection = new ArrayCollection();

		[Transient]
		private var _attack:int = 0;
		[Transient]
		private var _defense:int = 0;

		public function generateProtocol():String
		{
			var temp:String = "";
			for each(var s:Skill in skills)
			{
				temp += s.generateProtocol().replace('$', '#');
			}

			return StringHelper.parseIt(getClassName(), this.id, this.hp, this.level, this.image, attack, defense, skills.length, temp);
		}

		public function fillFromProtocol(protocol:String):*
		{
			var array:Array = protocol.split(';');

			this.id = array[1];
			this.hp = array[2];
			this.level = array[3];
			this.image = array[4];
			this._attack = array[5];
			this._defense = array[6];
			var length:int = array[7];

			var i:uint = 8;
			while(length > 0)
			{
				var temp:String = "";
				for(var j = 0; j < 8; j++)
				{
					temp += array[i++] + ';';
				}
				skills.addItem(new Skill().fillFromProtocol(temp));
				length--;
			}

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
			if(_attack == 0)
			{
				return calculate("attack");
			}
			else
			{
				return _attack;
			}
		}

		public function get defense():int
		{
			if(_defense == 0)
			{
				return calculate("defense");
			}
			else
			{
				return _defense;
			}
		}
	}
}
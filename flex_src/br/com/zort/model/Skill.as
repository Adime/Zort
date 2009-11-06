package br.com.zort.model
{
	import br.com.zort.helper.StringHelper;


	[RemoteClass(alias="br.com.zort.model.Skill")]
	[Bindable]
	public class Skill implements IProtocol
	{
		public var id:int;
		public var name:String;
		public var description:String;
		public var castTime:int;
		public var delayTime:int;
		public var type:String;
		public var value:int;

		public var robot:Robot;

		public function generateProtocol():String
		{
			return StringHelper.parseIt(getClassName(), this.id, name, description, castTime, delayTime, type, value);
		}

		public function fillFromProtocol(protocol:String):*
		{
			var array:Array = protocol.split(';');

			this.id = array[1];
			this.name = array[2];
			this.description = array[3];
			this.castTime = array[4];
			this.delayTime = array[5];
			this.type = array[6];
			this.value = array[7];

			return this;
		}

		public function getClassName():String
		{
			return "$SKILL";
		}

		public function compare(skill:Skill):Boolean
		{
			return(this.id == skill.id);
		}
	}
}
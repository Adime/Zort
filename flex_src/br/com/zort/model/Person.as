package br.com.zort.model
{
	import br.com.zort.helper.StringHelper;


	[RemoteClass(alias="br.com.zort.model.Person")]
	[Bindable]
	public class Person implements IProtocol
	{

		public var id:Number;
		public var name:String;
		public var sex:Boolean;
		public var imageFront:String;
		public var imageBack:String;
		public var imageRight:String;
		public var imageLeft:String;

		public function generateProtocol():String
		{
			return StringHelper.parseIt(getClassName(), this.id, this.imageFront, this.imageBack, this.imageRight, this.imageLeft, this.name);
		}

		public function fillFromProtocol(protocol:String):*
		{
			var array:Array = protocol.split(';');

			this.id = array[1];
			this.imageFront = array[2];
			this.imageBack = array[3];
			this.imageRight = array[4];
			this.imageLeft = array[5];
			this.name = array[6];

			return this;
		}

		public function getClassName():String
		{
			return "$CHAR";
		}

	}
}
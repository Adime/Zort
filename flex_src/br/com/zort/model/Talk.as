package br.com.zort.model
{
	import br.com.zort.helper.StringHelper;


	public class Talk implements IProtocol
	{

		public var message:String;

		public function generateProtocol():String
		{
			return StringHelper.parseIt(getClassName(), this.message);
		}

		public function fillFromProtocol(protocol:String):*
		{
			var array:Array = protocol.split(';');

			this.message = array[1];

			return this;
		}

		public function getClassName():String
		{
			return "$MESSAGE";
		}

	}
}
package br.com.zort.messaging
{
	import br.com.zort.model.IProtocol;
	import br.com.zort.model.Map;
	import br.com.zort.model.MapTile;
	import br.com.zort.model.Person;
	import br.com.zort.model.PrivateTalk;
	import br.com.zort.model.Robot;
	import br.com.zort.model.Skill;
	import br.com.zort.model.Talk;


	public class MessageHandler
	{

		public function handlerIt(message:String):MessageComposer
		{
			var retorno:MessageComposer = new MessageComposer();
			var array:Array = message.split(';');

			retorno.type = array[0];
			var classes:Array = new Array();
			var protocol:String = "";
			for(var i:uint = 1; i < array.length; i++)
			{
				if(String(array[i]).charAt(0) == '$')
				{
					if(protocol != "")
					{
						classes.push(getInstance(protocol));
					}
					protocol = "";
				}
				protocol += array[i] + ';';
			}
			if(protocol != "")
			{
				classes.push(getInstance(protocol));
			}
			retorno.classes = classes;
			return retorno;
		}

		private function getInstance(message:String):*
		{
			var classes:Array = getProtocolClasses();
			for each(var p:IProtocol in classes)
			{
				var className:String = p.getClassName() + ';';
				if(message.indexOf(className) > -1)
				{
					return p.fillFromProtocol(message);
				}
			}
			return null;
		}

		private function getProtocolClasses():Array
		{
			return[new Map(), new MapTile(), new Person(), new Talk(), new PrivateTalk(), new Robot(), new Skill()];
		}

	}
}
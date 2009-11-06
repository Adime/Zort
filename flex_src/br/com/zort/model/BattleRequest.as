package br.com.zort.model
{
	import br.com.zort.helper.StringHelper;

	public class BattleRequest implements IProtocol
	{

		public var battleOrigin:Person;
		public var battleDestin:Person;
		public var betValue:int;

		private function replace(str:String, p:String, repl:String):String
		{
			while(str.indexOf(p) > -1)
			{
				str = str.replace(p, repl);
			}
			return str;
		}

		public function generateProtocol():String
		{
			var battleOriginProtocol:String = battleOrigin.generateProtocol().replace('$', '#');
			battleOriginProtocol = replace(battleOriginProtocol, ';', '|');
			var battleDestinProtocol:String = battleDestin.generateProtocol().replace('$', '#');
			battleDestinProtocol = replace(battleDestinProtocol, ';', '|');

			return StringHelper.parseIt(getClassName(), this.betValue, battleOriginProtocol, battleDestinProtocol);
		}

		public function fillFromProtocol(protocol:String):*
		{
			var array:Array = protocol.split(';');

			this.betValue = array[1];
			var bo:String = array[2];
			bo = bo.replace('#', '$');
			bo = replace(bo, '|', ';');
			this.battleOrigin = new Person().fillFromProtocol(bo);
			var bd:String = array[3];
			bd = bd.replace('#', '$');
			bd = replace(bd, '|', ';');
			this.battleDestin = new Person().fillFromProtocol(bd);

			return this;
		}

		public function getClassName():String
		{
			return "$BATTLEREQUEST";
		}

	}
}
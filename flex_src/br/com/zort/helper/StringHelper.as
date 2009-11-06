package br.com.zort.helper
{

	public class StringHelper
	{
		public function StringHelper()
		{
		}

		public static function stringBooleanToBoolean(value:String):Boolean
		{
			if(value == "true")
			{
				return true;
			}
			return false;
		}

		public static function parseIt(... params):String
		{
			var retorno:String = "";
			for(var i:uint = 0; i < params.length; i++)
			{
				retorno += params[i] + ";";
			}
			return retorno;
		}

	}
}
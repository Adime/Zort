package br.com.zort.assets
{

	[Bindable]
	public class Assets
	{
		public static function getTileImage(name:String):String
		{
			return "br/com/zort/assets/tiles/" + name + ".png";
		}

		public static function getCharImage(name:String):String
		{
			return "br/com/zort/assets/char/" + name + ".png";
		}

	}
}
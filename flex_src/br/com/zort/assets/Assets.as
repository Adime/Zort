package br.com.zort.assets
{

	[Bindable]
	public class Assets
	{

		[Embed(source="br/com/zort/assets/ico/cart.png")]
		public static var cart:Class;

		[Embed(source="br/com/zort/assets/ico/robot.png")]
		public static var robot:Class;

		[Embed(source="br/com/zort/assets/ico/friends.png")]
		public static var friends:Class;

		[Embed(source="br/com/zort/assets/ico/bag.png")]
		public static var bag:Class;

		[Embed(source="br/com/zort/assets/ico/coin.png")]
		public static var coin:Class;

		[Embed(source="br/com/zort/assets/ico/msg.png")]
		public static var msg:Class;

		[Embed(source="br/com/zort/assets/ico/balloon.png")]
		public static var balloon:Class;

		[Embed(source="br/com/zort/assets/tiles/agua.png")]
		public static var agua:Class;

		[Embed(source="br/com/zort/assets/tiles/mato.png")]
		public static var mato:Class;

		[Embed(source="br/com/zort/assets/tiles/pedra.png")]
		public static var pedra:Class;

		public static function getTileImage(name:String):Class
		{
			return Assets[name];
		}

		public static function getCharImage(name:String):String
		{
			return "br/com/zort/assets/char/" + name + ".png";
		}

		public static function getItemImage(name:String):String
		{
			return "br/com/zort/assets/items/" + name + ".png";
		}

	}
}
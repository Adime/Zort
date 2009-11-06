package br.com.zort.model
{
	import br.com.zort.helper.StringHelper;


	[RemoteClass(alias="br.com.zort.model.MapTile")]
	[Bindable]
	public class MapTile implements IProtocol
	{
		public var id:Number;
		public var x:Number;
		public var y:Number;
		public var teleport:Teleport;
		public var tile:Tile = new Tile();

		/**
		 * Get mapTo from teleport propertie, if not found return 0;
		 **/
		public function getMapTo():Number
		{
			var retorno:Number = 0;
			if(teleport)
			{
				retorno = teleport.mapTo;
			}
			return retorno;
		}

		/**
		 * Check if the tile propertie is walkable, if no tile, return false;
		 **/
		public function isWalkable():Boolean
		{
			var retorno:Boolean = false;
			if(tile)
			{
				retorno = tile.isWalkable;
			}
			return retorno;
		}

		public function generateProtocol():String
		{
			return StringHelper.parseIt(getClassName(), this.x, this.y);
		}

		public function fillFromProtocol(protocol:String):*
		{
			var array:Array = protocol.split(';');

			this.x = array[1];
			this.y = array[2];

			return this;
		}

		public function getClassName():String
		{
			return "$MAPTILE";
		}
	}
}
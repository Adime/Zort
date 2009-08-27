package br.com.zort.model
{
	import br.com.zort.assets.Assets;
	import br.com.zort.helper.StringHelper;
	import br.com.zort.map.TileCanvas;

	import mx.collections.ArrayCollection;
	import mx.controls.Image;
	import mx.core.ScrollPolicy;

	[RemoteClass(alias="br.com.zort.model.Map")]
	[Bindable]
	public class Map implements IProtocol
	{
		public var id:Number;
		public var name:String;
		public var tiles:ArrayCollection;

		[Transient]
		public var squareSize:Number = 60;

		public function getTitle(x:int, y:int):MapTile
		{
			var t:MapTile = null;

			for each(var tile:MapTile in tiles)
			{
				if(tile.x == x && tile.y == y)
				{
					t = tile;
					break;
				}
			}
			return t;
		}

		public function getTeleportFrom(mapFrom:int):MapTile
		{
			var t:MapTile = null;
			for each(var tile:MapTile in tiles)
			{
				if(tile.teleport && tile.teleport.mapFrom == mapFrom)
				{
					t = tile;
				}
			}
			if(t == null)
			{
				t = getTitle(0, 0);
			}
			return t;
		}

		public function getTileDisplays(borderOnly:Boolean = false):Array
		{
			var arr:Array = new Array();

			for each(var t:MapTile in tiles)
			{
				var c:TileCanvas = new TileCanvas();
				c.x = t.x * squareSize;
				c.y = t.y * squareSize;
				c.width = squareSize;
				c.height = squareSize;
				c.tile = t;
				c.horizontalScrollPolicy = c.verticalScrollPolicy = ScrollPolicy.OFF;

				if(borderOnly)
				{
					c.setStyle("borderStyle", "solid");
					c.setStyle("backgroundColor", 0xFFFFFF)
				}

				if(t.tile.isValid())
				{
					var img:Image = new Image();
					img.width = img.height = squareSize;
					img.maintainAspectRatio = false;
					img.source = Assets.getTileImage(t.tile.source);
					c.addChild(img);
				}
				arr.push(c);
			}
			return arr;
		}

		public static function generateMap(name:String, tilesQuantityX:int, tilesQuantityY:int):Map
		{
			var map:Map = new Map();
			var tiles:ArrayCollection = new ArrayCollection();

			for(var i:int = 0; i < tilesQuantityX; i++)
			{
				for(var j:int = 0; j < tilesQuantityY; j++)
				{
					var tile:MapTile = new MapTile();
					tile.x = i;
					tile.y = j;
					tiles.addItem(tile);
				}
			}
			map.name = name;
			map.tiles = tiles;
			return map;
		}

		public function generateProtocol():String
		{
			return StringHelper.parseIt(getClassName(), this.id);
		}

		public function fillFromProtocol(protocol:String):*
		{
			var array:Array = protocol.split(';');

			this.id = array[1];

			return this;
		}

		public function getClassName():String
		{
			return "$MAP";
		}

	}

}
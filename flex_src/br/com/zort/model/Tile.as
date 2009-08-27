package br.com.zort.model
{
	import br.com.zort.helper.StringHelper;

	[RemoteClass(alias="br.com.zort.model.Tile")]
	[Bindable]
	public class Tile
	{
		public var id:Number;
		public var isWalkable:Boolean;
		public var source:String = "";

		public function isValid():Boolean
		{
			return source.length > 0 ? true : false;
		}

	}
}
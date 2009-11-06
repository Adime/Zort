package br.com.zort.model
{

	[RemoteClass(alias="br.com.zort.model.Item")]
	[Bindable]
	public class Item
	{
		public var id:int;
		public var name:String;
		public var description:String;
		public var image:String;
		public var type:Type;
		public var defense:int;
		public var attack:int;
		public var price:Number;

		public var user:User;
	}
}
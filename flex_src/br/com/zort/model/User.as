package br.com.zort.model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="br.com.zort.model.User")]
	[Bindable]
	public class User
	{
		public var id:Number;
		public var login:String;
		public var password:String;
		public var nome:String;
		public var email:String;

		public var person:Person;

		public var robot:Robot;

		public var wins:int;
		public var loses:int;

		public var items:ArrayCollection;

		public var money:int;
	}
}
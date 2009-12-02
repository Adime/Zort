package br.com.zort.model
{

	[RemoteClass(alias="br.com.zort.model.Message")]
	[Bindable]
	public class MessageDTO
	{
		public var id:int;
		public var dest:String;
		public var orig:String;
		public var message:String;
	}
}
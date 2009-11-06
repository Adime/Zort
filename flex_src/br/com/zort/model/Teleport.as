package br.com.zort.model
{

	[RemoteClass(alias="br.com.zort.model.Teleport")]
	[Bindable]
	public class Teleport
	{
		public var id:Number;
		public var mapFrom:Number;
		public var mapTo:Number;
	}
}
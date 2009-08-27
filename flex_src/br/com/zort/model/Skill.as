package br.com.zort.model
{

	[RemoteClass(alias="br.com.zort.model.Skill")]
	[Bindable]
	public class Skill
	{
		public var id:int;
		public var name:String;
		public var description:String;
		public var castTime:int;
		public var delayTime:int;
		public var attack:int;
		public var defense:int;

		public var robot:Robot;
	}
}
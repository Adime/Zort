package br.com.zort.model
{

	public interface IProtocol
	{
		function generateProtocol():String;
		function fillFromProtocol(protocol:String):*;
		function getClassName():String;
	}
}
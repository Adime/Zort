package br.com.zort.model
{
	import br.com.zort.helper.StringHelper;

	public class PrivateTalk extends Talk implements IProtocol
	{
		override public function getClassName():String
		{
			return "$PRIVATEMESSAGE";
		}

	}
}
package br.com.zort.service
{
	import mx.rpc.events.ResultEvent;

	public class MessageService extends Service
	{
		private var callbackFuncton:Function;

		function MessageService(callbackFuncton:Function = null)
		{
			super("messageService");
			this.callbackFuncton = callbackFuncton;
		}

		public function getMessageByUserName(userName:String):void
		{
			service.getMessageByUserName(userName);
		}

		public function getMessageByUserNameResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function doCallBack(event:ResultEvent):void
		{
			if(this.callbackFuncton != null)
			{
				this.callbackFuncton(event);
			}
		}
	}
}
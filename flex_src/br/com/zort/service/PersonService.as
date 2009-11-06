package br.com.zort.service
{
	import mx.rpc.events.ResultEvent;

	public class PersonService extends Service
	{
		private var callbackFuncton:Function;

		function PersonService(callbackFuncton:Function = null)
		{
			super("personService");
			this.callbackFuncton = callbackFuncton;
		}

		public function getAllPerson():void
		{
			service.getAllPerson();
		}

		public function getAllPersonResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function getPersonById(id:int):void
		{
			service.getPersonById(id);
		}

		public function getPersonByIdResult(event:ResultEvent):void
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
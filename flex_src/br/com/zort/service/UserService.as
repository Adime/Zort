package br.com.zort.service
{
	import br.com.zort.model.Robot;
	import br.com.zort.model.User;

	import mx.rpc.events.ResultEvent;

	public class UserService extends Service
	{
		private var callbackFuncton:Function;

		function UserService(callbackFuncton:Function = null)
		{
			super("userService");
			this.callbackFuncton = callbackFuncton;
		}

		public function saveUser(user:User):void
		{
			service.saveUser(user);
		}

		public function saveUserResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function getUserByLoginAndPass(login:String, password:String):void
		{
			service.getUserByLoginAndPass(login, password);
		}

		public function getUserByLoginAndPassResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function getStoreItems():void
		{
			service.getStoreItems();
		}

		public function getStoreItemsResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function saveRobot(robot:Robot):void
		{
			service.saveRobot(robot);
		}

		public function saveRobotResult(event:ResultEvent):void
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
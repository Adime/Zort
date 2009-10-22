package br.com.zort.service
{
	import br.com.zort.model.Item;
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

		public function buyItem(user:User, item:Item):void
		{
			service.buyItem(user, item);
		}

		public function buyItemResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function getItemsByUser(user:User):void
		{
			service.getItemsByUser(user);
		}

		public function getItemsByUserResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function removeItemFromUser(i:Item):void
		{
			service.removeItemFromUser(i);
		}

		public function remoteItemFromUserResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function setUserWin(u:User, money:int, enemyLevel:int):void
		{
			service.setUserWin(u, money, enemyLevel);
		}

		public function setUserWinResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function setUserLose(u:User, money:int):void
		{
			service.setUserLose(u, money);
		}

		public function setUserLoseResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function retrieveItem(u:User, i:Item):void
		{
			service.retrieveItem(u, i);
		}

		public function retrieveItemResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function enviaSMS(u:User, destin:String, msg:String):void
		{
			service.showBusyCursor = true;
			service.enviaSMS(u, destin, msg);
		}

		public function enviaSMSResult(event:ResultEvent):void
		{
			service.showBusyCursor = false;
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
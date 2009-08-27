package br.com.zort.service
{
	import mx.rpc.events.ResultEvent;

	public class TileService extends Service
	{
		private var callbackFuncton:Function;

		function TileService(callbackFuncton:Function = null)
		{
			super("tileService");
			this.callbackFuncton = callbackFuncton;
		}

		public function getAllTiles():void
		{
			service.getAllTiles();
		}

		public function getAllTilesResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		private function doCallBack(event:ResultEvent):void
		{
			if(this.callbackFuncton != null)
			{
				this.callbackFuncton(event);
			}
		}

	}
}
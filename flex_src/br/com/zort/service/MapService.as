package br.com.zort.service
{
	import br.com.zort.model.Map;

	import mx.rpc.events.ResultEvent;

	public class MapService extends Service
	{
		private var callbackFuncton:Function;

		function MapService(callbackFuncton:Function = null)
		{
			super("mapService");
			this.callbackFuncton = callbackFuncton;
		}

		public function addOrUpdate(map:Map):void
		{
			service.addOrUpdate(map);
		}

		public function addOrUpdateResult(event:ResultEvent):void
		{
			doCallBack(event);
		}

		public function getMapById(id:Number):void
		{
			service.getMapById(id);
		}

		public function getMapByIdResult(event:ResultEvent):void
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
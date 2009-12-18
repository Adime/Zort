package br.com.zort.view.login
{
	import br.com.zort.model.Robot;

	import mx.collections.ArrayCollection;

	[Bindable]
	public class RobotList
	{

		public static function generateRobots():ArrayCollection
		{
			var arr:ArrayCollection = new ArrayCollection();
			arr.addItem(generateRobot("robot1"));
			arr.addItem(generateRobot("robot2"));

			return arr;
		}

		private static function generateRobot(image:String):Robot
		{
			var r:Robot = new Robot();
			r.level = 1;
			r.experience = 0;
			r.image = image;
			r.hp = 200;

			return r;
		}

	}
}
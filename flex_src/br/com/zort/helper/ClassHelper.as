package br.com.zort.helper
{

	public class ClassHelper
	{
		public static function getClassByType(classes:Array, type:Class, position:int=1):*
		{
			for(var i:uint = 0; i < classes.length; i++)
			{
				if(classes[i] is type)
				{
					if (position == 1)
					{
						return classes[i];
					}
					else
					{
						position--;
					}
				}
			}
			return null;
		}
	}
}
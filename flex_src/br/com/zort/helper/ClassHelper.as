package br.com.zort.helper
{

	public class ClassHelper
	{
		public static function getClassByType(classes:Array, type:Class):*
		{
			for(var i:uint = 0; i < classes.length; i++)
			{
				if(classes[i] is type)
				{
					return classes[i];
				}
			}
			return null;
		}
	}
}
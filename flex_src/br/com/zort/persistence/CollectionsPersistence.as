package br.com.zort.persistence
{
	import br.com.zort.model.Person;

	import mx.collections.ArrayCollection;

	public class CollectionsPersistence
	{
		[Bindable]
		public static var items:ArrayCollection = new ArrayCollection();
	}
}
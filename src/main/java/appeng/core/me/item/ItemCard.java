
package appeng.core.me.item;


import code.elix_x.excomms.reflection.ReflectionHelper.AClass;
import code.elix_x.excomms.reflection.ReflectionHelper.AClass.AEnum;

import appeng.core.lib.item.AEBaseItem;


/**
 * Generic upgrade cards superclass. Probably pointless.
 * 
 * @author Elix_x
 *
 */
public class ItemCard extends AEBaseItem
{

	public final EnumCardType type;

	public ItemCard( EnumCardType type )
	{
		this.type = type;
	}

	public enum EnumCardType
	{

		BASIC, ADVANCED;

		private static final AEnum<ItemCard.EnumCardType> CARDTYPE = new AClass( ItemCard.EnumCardType.class ).asEnum();

		public static EnumCardType addCardType( String type )
		{
			return CARDTYPE.addEnum( type );
		}

	}

}

package appeng.core.me.item;

import appeng.core.lib.item.AEBaseItem;

public class ItemProcessor extends AEBaseItem
{

	public final ProcessorType type;
	
	public ItemProcessor( ProcessorType type )
	{
		this.type = type;
	}

	public enum ProcessorType {
		
		LOGIC,
		CALCULATION,
		ENGINEERING
		
	}
	
}

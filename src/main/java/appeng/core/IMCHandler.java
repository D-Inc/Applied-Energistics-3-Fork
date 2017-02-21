/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2015, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.core;


import java.util.HashMap;
import java.util.Map;

import appeng.core.lib.AELog;
import appeng.core.lib.api.IIMCProcessor;
import appeng.core.lib.api.imc.IMCGrinder;
import appeng.core.lib.api.imc.IMCMatterCannon;
import net.minecraftforge.fml.common.event.FMLInterModComms;


/**
 * Handles the delegation of the corresponding IMC messages to the suitable IMC processors
 *
 * @author thatsIch
 * @version rv3 - 10.08.2015
 * @since rv1
 */
//TODO 1.10.2-APIBOOM - Move to modules.
@Deprecated
public class IMCHandler
{
	private static final int INITIAL_PROCESSORS_CAPACITY = 20;

	/**
	 * Contains the processors,
	 *
	 * is mutable, but write access only by the constructor
	 */
	private final Map<String, IIMCProcessor> processors;

	/**
	 * Initializes the processors
	 */
	public IMCHandler()
	{
		this.processors = new HashMap<String, IIMCProcessor>( INITIAL_PROCESSORS_CAPACITY );

		this.processors.put( "add-grindable", new IMCGrinder() );
		this.processors.put( "add-mattercannon-ammo", new IMCMatterCannon() );
	}

	/**
	 * Tries to find every message matching the internal IMC keys. When found the corresponding handler will process the
	 * attached message.
	 *
	 * @param event Event carrying the identifier and message for the handlers
	 */
	void handleIMCEvent( final FMLInterModComms.IMCEvent event )
	{
		for( final FMLInterModComms.IMCMessage message : event.getMessages() )
		{
			final String key = message.key;

			try
			{
				final IIMCProcessor handler = this.processors.get( key );
				if( handler != null )
				{
					handler.process( message );
				}
				else
				{
					throw new IllegalStateException( "Invalid IMC Called: " + key );
				}
			}
			catch( final Exception t )
			{
				AELog.warn( "Problem detected when processing IMC " + key + " from " + message.getSender() );
				AELog.debug( t );
			}
		}
	}
}

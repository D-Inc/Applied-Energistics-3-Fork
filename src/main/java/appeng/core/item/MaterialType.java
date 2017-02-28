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

package appeng.core.item;


import java.util.EnumSet;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import appeng.core.AppEng;
import appeng.core.lib.entity.EntityIds;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.features.MaterialStackSrc;
import appeng.core.me.entity.EntitySingularity;


public enum MaterialType
{
	Wireless( 41, "material_wireless", AEFeature.WirelessAccessTerminal ), WirelessBooster( 42, "material_wireless_booster", AEFeature.WirelessAccessTerminal ),

	Singularity( 47, "material_singularity", AEFeature.QuantumNetworkBridge, EntitySingularity.class ), QESingularity( 48, "material_qesingularity", AEFeature.QuantumNetworkBridge, EntitySingularity.class );

	private final EnumSet<AEFeature> features;
	private final ModelResourceLocation model;
	private Item itemInstance;
	private int damageValue;
	// stack!
	private MaterialStackSrc stackSrc;
	private String oreName;
	private Class<? extends Entity> droppedEntity;
	private boolean isRegistered = false;

	MaterialType( final int metaValue, String modelName )
	{
		this( metaValue, modelName, AEFeature.Core );
	}

	MaterialType( final int metaValue, String modelName, final AEFeature part )
	{
		this.setDamageValue( metaValue );
		this.features = EnumSet.of( part );
		this.model = new ModelResourceLocation( new ResourceLocation( AppEng.MODID, modelName ), "inventory" );
	}

	MaterialType( final int metaValue, String modelName, final AEFeature part, final Class<? extends Entity> c )
	{
		this( metaValue, modelName, part );
		this.droppedEntity = c;

		EntityRegistry.registerModEntity( new ResourceLocation( AppEng.MODID, this.droppedEntity.getSimpleName() ), this.droppedEntity, this.droppedEntity.getSimpleName(), EntityIds.get( this.droppedEntity ), AppEng.instance(), 16, 4, true );
	}

	MaterialType( final int metaValue, String modelName, final AEFeature part, final String oreDictionary, final Class<? extends Entity> c )
	{
		this( metaValue, modelName, part );
		this.oreName = oreDictionary;
		this.droppedEntity = c;
		EntityRegistry.registerModEntity( new ResourceLocation( AppEng.MODID, this.droppedEntity.getSimpleName() ), this.droppedEntity, this.droppedEntity.getSimpleName(), EntityIds.get( this.droppedEntity ), AppEng.instance(), 16, 4, true );
	}

	MaterialType( final int metaValue, String modelName, final AEFeature part, final String oreDictionary )
	{
		this( metaValue, modelName, part );
		this.oreName = oreDictionary;
	}

	public ItemStack stack( final int size )
	{
		return new ItemStack( this.getItemInstance(), size, this.getDamageValue() );
	}

	EnumSet<AEFeature> getFeature()
	{
		return this.features;
	}

	public String getOreName()
	{
		return this.oreName;
	}

	boolean hasCustomEntity()
	{
		return this.droppedEntity != null;
	}

	Class<? extends Entity> getCustomEntityClass()
	{
		return this.droppedEntity;
	}

	public boolean isRegistered()
	{
		return this.isRegistered;
	}

	void markReady()
	{
		this.isRegistered = true;
	}

	public int getDamageValue()
	{
		return this.damageValue;
	}

	void setDamageValue( final int damageValue )
	{
		this.damageValue = damageValue;
	}

	public Item getItemInstance()
	{
		return this.itemInstance;
	}

	void setItemInstance( final Item itemInstance )
	{
		this.itemInstance = itemInstance;
	}

	MaterialStackSrc getStackSrc()
	{
		return this.stackSrc;
	}

	void setStackSrc( final MaterialStackSrc stackSrc )
	{
		this.stackSrc = stackSrc;
	}

	public ModelResourceLocation getModel()
	{
		return model;
	}

}

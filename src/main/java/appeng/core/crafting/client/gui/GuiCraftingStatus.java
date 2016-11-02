/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved.
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

/**
 *
 */

package appeng.core.crafting.client.gui;


import java.io.IOException;

import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import appeng.core.crafting.container.ContainerCraftingStatus;
import appeng.core.lib.AELog;
import appeng.core.lib.ApiDefinitions;
import appeng.core.lib.AppEngApi;
import appeng.core.lib.api.definitions.ApiParts;
import appeng.core.lib.client.gui.widgets.GuiTabButton;
import appeng.core.lib.helpers.WirelessTerminalGuiObject;
import appeng.core.lib.localization.GuiText;
import appeng.core.lib.sync.GuiBridge;
import appeng.core.lib.sync.network.NetworkHandler;
import appeng.core.lib.sync.packets.PacketSwitchGuis;
import appeng.core.lib.sync.packets.PacketValueConfig;
import appeng.core.me.api.storage.ITerminalHost;
import appeng.core.me.part.reporting.PartCraftingTerminal;
import appeng.core.me.part.reporting.PartPatternTerminal;
import appeng.core.me.part.reporting.PartTerminal;


public class GuiCraftingStatus extends GuiCraftingCPU
{

	private final ContainerCraftingStatus status;
	private GuiButton selectCPU;

	private GuiTabButton originalGuiBtn;
	private GuiBridge originalGui;
	private ItemStack myIcon = null;

	public GuiCraftingStatus( final InventoryPlayer inventoryPlayer, final ITerminalHost te )
	{
		super( new ContainerCraftingStatus( inventoryPlayer, te ) );

		this.status = (ContainerCraftingStatus) this.inventorySlots;
		final Object target = this.status.getTarget();
		final ApiDefinitions definitions = AppEngApi.internalApi().definitions();
		final ApiParts parts = definitions.parts();

		if( target instanceof WirelessTerminalGuiObject )
		{
			myIcon = (ItemStack) definitions.items().wirelessTerminal().maybeStack( 1 ).orElse( null );

			this.originalGui = GuiBridge.GUI_WIRELESS_TERM;
		}

		if( target instanceof PartTerminal )
		{
			myIcon = (ItemStack) parts.terminal().maybeStack( 1 ).orElse( null );

			this.originalGui = GuiBridge.GUI_ME;
		}

		if( target instanceof PartCraftingTerminal )
		{
			myIcon = (ItemStack) parts.craftingTerminal().maybeStack( 1 ).orElse( null );

			this.originalGui = GuiBridge.GUI_CRAFTING_TERMINAL;
		}

		if( target instanceof PartPatternTerminal )
		{
			myIcon = (ItemStack) parts.patternTerminal().maybeStack( 1 ).orElse( null );

			this.originalGui = GuiBridge.GUI_PATTERN_TERMINAL;
		}
	}

	@Override
	protected void actionPerformed( final GuiButton btn ) throws IOException
	{
		super.actionPerformed( btn );

		final boolean backwards = Mouse.isButtonDown( 1 );

		if( btn == this.selectCPU )
		{
			try
			{
				NetworkHandler.instance.sendToServer( new PacketValueConfig( "Terminal.Cpu", backwards ? "Prev" : "Next" ) );
			}
			catch( final IOException e )
			{
				AELog.debug( e );
			}
		}

		if( btn == this.originalGuiBtn )
		{
			NetworkHandler.instance.sendToServer( new PacketSwitchGuis( this.originalGui ) );
		}
	}

	@Override
	public void initGui()
	{
		super.initGui();

		this.selectCPU = new GuiButton( 0, this.guiLeft + 8, this.guiTop + this.ySize - 25, 150, 20, GuiText.CraftingCPU.getLocal() + ": " + GuiText.NoCraftingCPUs );
		// selectCPU.enabled = false;
		this.buttonList.add( this.selectCPU );

		if( this.myIcon != null )
		{
			this.buttonList.add( this.originalGuiBtn = new GuiTabButton( this.guiLeft + 213, this.guiTop - 4, this.myIcon, this.myIcon.getDisplayName(), this.itemRender ) );
			this.originalGuiBtn.setHideEdge( 13 );
		}
	}

	@Override
	public void drawScreen( final int mouseX, final int mouseY, final float btn )
	{
		this.updateCPUButtonText();
		super.drawScreen( mouseX, mouseY, btn );
	}

	private void updateCPUButtonText()
	{
		String btnTextText = GuiText.NoCraftingJobs.getLocal();

		if( this.status.selectedCpu >= 0 )// && status.selectedCpu < status.cpus.size() )
		{
			if( this.status.myName.length() > 0 )
			{
				final String name = this.status.myName.substring( 0, Math.min( 20, this.status.myName.length() ) );
				btnTextText = GuiText.CPUs.getLocal() + ": " + name;
			}
			else
			{
				btnTextText = GuiText.CPUs.getLocal() + ": #" + this.status.selectedCpu;
			}
		}

		if( this.status.noCPU )
		{
			btnTextText = GuiText.NoCraftingJobs.getLocal();
		}

		this.selectCPU.displayString = btnTextText;
	}

	@Override
	protected String getGuiDisplayName( final String in )
	{
		return in; // the cup name is on the button
	}
}


package appeng.core.me.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.lib.bootstrap.BlockRenderingCustomizer;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.bootstrap.IBlockRendering;
import appeng.core.lib.bootstrap.IItemRendering;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.api.definitions.IMETileDefinitions;
import appeng.core.me.block.BlockCableBus;
import appeng.core.me.block.BlockCellWorkbench;
import appeng.core.me.block.BlockChest;
import appeng.core.me.block.BlockCondenser;
import appeng.core.me.block.BlockController;
import appeng.core.me.block.BlockCreativeEnergyCell;
import appeng.core.me.block.BlockDenseEnergyCell;
import appeng.core.me.block.BlockDrive;
import appeng.core.me.block.BlockEnergyAcceptor;
import appeng.core.me.block.BlockEnergyCell;
import appeng.core.me.block.BlockEnergyCellRendering;
import appeng.core.me.block.BlockIOPort;
import appeng.core.me.block.BlockInterface;
import appeng.core.me.block.BlockQuantumLinkChamber;
import appeng.core.me.block.BlockQuantumRing;
import appeng.core.me.block.BlockSecurity;
import appeng.core.me.block.BlockWireless;
import appeng.core.me.block.CableBusColor;
import appeng.core.me.block.CableModelCustomizer;
import appeng.core.me.tile.TileCableBus;
import appeng.core.me.tile.TileCellWorkbench;
import appeng.core.me.tile.TileChest;
import appeng.core.me.tile.TileCondenser;
import appeng.core.me.tile.TileController;
import appeng.core.me.tile.TileCreativeEnergyCell;
import appeng.core.me.tile.TileDenseEnergyCell;
import appeng.core.me.tile.TileDrive;
import appeng.core.me.tile.TileEnergyAcceptor;
import appeng.core.me.tile.TileEnergyCell;
import appeng.core.me.tile.TileIOPort;
import appeng.core.me.tile.TileInterface;
import appeng.core.me.tile.TileQuantumBridge;
import appeng.core.me.tile.TileSecurity;
import appeng.core.me.tile.TileWireless;


public class METileDefinitions extends Definitions<Class<? extends TileEntity>, ITileDefinition<? extends TileEntity, Class<? extends TileEntity>>> implements IMETileDefinitions
{

	private final ITileDefinition multiPart;
	
	private final ITileDefinition wirelessAccessPoint;
	
	private final ITileDefinition securityStation;
	//TODO 1.11-CN:R - Subdefine.
	private final ITileDefinition quantumRing;
//	private final ITileDefinition quantumLink;

	private final ITileDefinition controller;
	private final ITileDefinition drive;
	private final ITileDefinition chest;
	private final ITileDefinition iface;
	private final ITileDefinition cellWorkbench;
	private final ITileDefinition iOPort;
	private final ITileDefinition condenser;
	private final ITileDefinition energyAcceptor;
	
	private final ITileDefinition energyCell;
	private final ITileDefinition energyCellDense;
	private final ITileDefinition energyCellCreative;

	public METileDefinitions( FeatureFactory registry )
	{
		this.multiPart = registry.tile( "multipart_block", TileCableBus.class ).build();
		
		this.wirelessAccessPoint = registry.tile( "wireless_access_point", TileWireless.class ).features( AEFeature.WirelessAccessTerminal ).build();
		
		this.securityStation = registry.tile( "security_station", TileSecurity.class ).features( AEFeature.Security ).build();
		this.quantumRing = registry.tile( "quantum_ring", TileQuantumBridge.class ).features( AEFeature.QuantumNetworkBridge ).build();
//		this.quantumLink = registry.tile( "quantum_link", TileQuantumBridge.class ).features( AEFeature.QuantumNetworkBridge ).build();
		
		this.controller = registry.tile( "controller", TileController.class ).features( AEFeature.Channels ).build();
		this.drive = registry.tile( "drive", TileDrive.class ).features( AEFeature.StorageCells, AEFeature.MEDrive ).build();
		this.chest = registry.tile( "chest", TileChest.class ).features( AEFeature.StorageCells, AEFeature.MEChest ).build();
		this.iface = registry.tile( "interface", TileInterface.class ).build();
		this.cellWorkbench = registry.tile( "cell_workbench", TileCellWorkbench.class ).features( AEFeature.StorageCells ).build();
		this.iOPort = registry.tile( "ioport", TileIOPort.class ).features( AEFeature.StorageCells, AEFeature.IOPort ).build();
		this.condenser = registry.tile( "condenser", TileCondenser.class ).build();
		this.energyAcceptor = registry.tile( "energy_acceptor", TileEnergyAcceptor.class ).build();

		this.energyCell = registry.tile( "energy_cell", TileEnergyCell.class ).build();
		this.energyCellDense = registry.tile( "dense_energy_cell", TileDenseEnergyCell.class ).features( AEFeature.DenseEnergyCells ).build();
		this.energyCellCreative = registry.tile( "creative_energy_cell", TileCreativeEnergyCell.class ).features( AEFeature.Creative ).build();

		init();
	}

}

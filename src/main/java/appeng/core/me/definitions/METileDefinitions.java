
package appeng.core.me.definitions;


import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.me.api.definitions.IMETileDefinitions;
import appeng.core.me.tile.TileCableBus;
import appeng.core.me.tile.TileCellWorkbench;
import appeng.core.me.tile.TileChest;
import appeng.core.me.tile.TileCondenser;
import appeng.core.me.tile.TileController;
import appeng.core.me.tile.TileDrive;
import appeng.core.me.tile.TileIOPort;
import appeng.core.me.tile.TileInterface;
import appeng.core.me.tile.TileQuantumBridge;
import appeng.core.me.tile.TileSecurity;
import appeng.core.me.tile.TileWireless;
import appeng.core.tile.TileCreativeEnergyCell;
import appeng.core.tile.TileDenseEnergyCell;
import appeng.core.tile.TileEnergyAcceptor;
import appeng.core.tile.TileEnergyCell;


public class METileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements IMETileDefinitions
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
		this.multiPart = registry.tile( new ResourceLocation( AppEng.MODID, "multipart_block" ), TileCableBus.class ).build();
		
		this.wirelessAccessPoint = registry.tile( new ResourceLocation( AppEng.MODID, "wireless_access_point" ), TileWireless.class ).features( AEFeature.WirelessAccessTerminal ).build();
		
		this.securityStation = registry.tile( new ResourceLocation( AppEng.MODID, "security_station" ), TileSecurity.class ).features( AEFeature.Security ).build();
		this.quantumRing = registry.tile( new ResourceLocation( AppEng.MODID, "quantum_ring" ), TileQuantumBridge.class ).features( AEFeature.QuantumNetworkBridge ).build();
//		this.quantumLink = registry.tile( new ResourceLocation( AppEng.MOD_ID, "quantum_link" ), TileQuantumBridge.class ).features( AEFeature.QuantumNetworkBridge ).build();
		
		this.controller = registry.tile( new ResourceLocation( AppEng.MODID, "controller" ), TileController.class ).features( AEFeature.Channels ).build();
		this.drive = registry.tile( new ResourceLocation( AppEng.MODID, "drive" ), TileDrive.class ).features( AEFeature.StorageCells, AEFeature.MEDrive ).build();
		this.chest = registry.tile( new ResourceLocation( AppEng.MODID, "chest" ), TileChest.class ).features( AEFeature.StorageCells, AEFeature.MEChest ).build();
		this.iface = registry.tile( new ResourceLocation( AppEng.MODID, "interface" ), TileInterface.class ).build();
		this.cellWorkbench = registry.tile( new ResourceLocation( AppEng.MODID, "cell_workbench" ), TileCellWorkbench.class ).features( AEFeature.StorageCells ).build();
		this.iOPort = registry.tile( new ResourceLocation( AppEng.MODID, "ioport" ), TileIOPort.class ).features( AEFeature.StorageCells, AEFeature.IOPort ).build();
		this.condenser = registry.tile( new ResourceLocation( AppEng.MODID, "condenser" ), TileCondenser.class ).build();
		this.energyAcceptor = registry.tile( new ResourceLocation( AppEng.MODID, "energy_acceptor" ), TileEnergyAcceptor.class ).build();

		this.energyCell = registry.tile( new ResourceLocation( AppEng.MODID, "energy_cell" ), TileEnergyCell.class ).build();
		this.energyCellDense = registry.tile( new ResourceLocation( AppEng.MODID, "dense_energy_cell" ), TileDenseEnergyCell.class ).features( AEFeature.DenseEnergyCells ).build();
		this.energyCellCreative = registry.tile( new ResourceLocation( AppEng.MODID, "creative_energy_cell" ), TileCreativeEnergyCell.class ).features( AEFeature.Creative ).build();

		init();
	}

}

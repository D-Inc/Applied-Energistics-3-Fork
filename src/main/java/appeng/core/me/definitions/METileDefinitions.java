
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
import appeng.core.me.tile.TileInscriber;
import appeng.core.me.tile.TileInterface;
import appeng.core.me.tile.TileQuantumBridge;
import appeng.core.me.tile.TileSecurity;
import appeng.core.me.tile.TileWireless;


public class METileDefinitions extends Definitions<Class<TileEntity>, ITileDefinition<TileEntity>> implements IMETileDefinitions
{

	private final ITileDefinition multiPart;
	
	private final ITileDefinition wirelessAccessPoint;
	
	private final ITileDefinition securityStation;
	//TODO 1.11-CN:A - Subdefine?
	private final ITileDefinition quantumRing;
	private final ITileDefinition quantumLink;

	private final ITileDefinition inscriber;
	private final ITileDefinition controller;
	private final ITileDefinition drive;
	private final ITileDefinition chest;
	private final ITileDefinition iface;
	private final ITileDefinition cellWorkbench;
	private final ITileDefinition iOPort;
	private final ITileDefinition condenser;

	public METileDefinitions( FeatureFactory registry )
	{
		this.multiPart = registry.tile( new ResourceLocation( AppEng.MODID, "multipart_block" ), TileCableBus.class ).build();
		
		this.wirelessAccessPoint = registry.tile( new ResourceLocation( AppEng.MODID, "wireless_access_point" ), TileWireless.class ).features( AEFeature.WirelessAccessTerminal ).build();
		
		this.securityStation = registry.tile( new ResourceLocation( AppEng.MODID, "security_station" ), TileSecurity.class ).features( AEFeature.Security ).build();
		this.quantumRing = registry.tile( new ResourceLocation( AppEng.MODID, "quantum_ring" ), TileQuantumBridge.Ring.class ).features( AEFeature.QuantumNetworkBridge ).build();
		this.quantumLink = registry.tile( new ResourceLocation( AppEng.MODID, "quantum_link" ), TileQuantumBridge.Link.class ).features( AEFeature.QuantumNetworkBridge ).build();
		
		this.inscriber = registry.tile( new ResourceLocation( AppEng.MODID, "inscriber"), TileInscriber.class ).features( AEFeature.Inscriber ).build();
		this.controller = registry.tile( new ResourceLocation( AppEng.MODID, "controller" ), TileController.class ).features( AEFeature.Channels ).build();
		this.drive = registry.tile( new ResourceLocation( AppEng.MODID, "drive" ), TileDrive.class ).features( AEFeature.StorageCells, AEFeature.MEDrive ).build();
		this.chest = registry.tile( new ResourceLocation( AppEng.MODID, "chest" ), TileChest.class ).features( AEFeature.StorageCells, AEFeature.MEChest ).build();
		this.iface = registry.tile( new ResourceLocation( AppEng.MODID, "interface" ), TileInterface.class ).build();
		this.cellWorkbench = registry.tile( new ResourceLocation( AppEng.MODID, "cell_workbench" ), TileCellWorkbench.class ).features( AEFeature.StorageCells ).build();
		this.iOPort = registry.tile( new ResourceLocation( AppEng.MODID, "ioport" ), TileIOPort.class ).features( AEFeature.StorageCells, AEFeature.IOPort ).build();
		this.condenser = registry.tile( new ResourceLocation( AppEng.MODID, "condenser" ), TileCondenser.class ).build();

		init();
	}

}

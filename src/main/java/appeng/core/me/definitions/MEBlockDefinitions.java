
package appeng.core.me.definitions;


import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.api.definitions.IBlockDefinition;
import appeng.api.definitions.ITileDefinition;
import appeng.core.AppEng;
import appeng.core.lib.bootstrap.BlockRenderingCustomizer;
import appeng.core.lib.bootstrap.FeatureFactory;
import appeng.core.lib.bootstrap.IBlockRendering;
import appeng.core.lib.bootstrap.IItemRendering;
import appeng.core.lib.definitions.Definitions;
import appeng.core.lib.features.AEFeature;
import appeng.core.lib.item.AEBaseItemBlockChargeable;
import appeng.core.me.api.definitions.IMEBlockDefinitions;
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


public class MEBlockDefinitions extends Definitions<Block, IBlockDefinition<Block>> implements IMEBlockDefinitions
{

	private final IBlockDefinition multiPart;

	private final IBlockDefinition wirelessAccessPoint;
	
	private final IBlockDefinition securityStation;
	private final IBlockDefinition quantumRing;
	private final IBlockDefinition quantumLink;

	private final IBlockDefinition controller;
	private final IBlockDefinition drive;
	private final IBlockDefinition chest;
	private final IBlockDefinition iface;
	private final IBlockDefinition cellWorkbench;
	private final IBlockDefinition iOPort;
	private final IBlockDefinition condenser;
	private final IBlockDefinition energyAcceptor;
	
	private final IBlockDefinition energyCell;
	private final IBlockDefinition energyCellDense;
	private final IBlockDefinition energyCellCreative;

	public MEBlockDefinitions( FeatureFactory registry )
	{
		this.multiPart = registry.block( "multipart_block", new BlockCableBus() ).rendering( new BlockRenderingCustomizer(){
			@Override
			@SideOnly( Side.CLIENT )
			public void customize( IBlockRendering rendering, IItemRendering itemRendering )
			{
				rendering.modelCustomizer( new CableModelCustomizer()::customizeModel ).blockColor( new CableBusColor() );
			}
		} ).build();
		
		this.wirelessAccessPoint = registry.block( "wireless_access_point", new BlockWireless() ).features( AEFeature.WirelessAccessTerminal ).build();

		this.securityStation = registry.block( "security_station", new BlockSecurity() ).features( AEFeature.Security ).build();
		this.quantumRing = registry.block( "quantum_ring", new BlockQuantumRing() ).features( AEFeature.QuantumNetworkBridge ).build();
		this.quantumLink = registry.block( "quantum_link", new BlockQuantumLinkChamber() ).features( AEFeature.QuantumNetworkBridge ).build();
		
		this.controller = registry.block( "controller", new BlockController() ).features( AEFeature.Channels ).build();
		this.drive = registry.block( "drive", new BlockDrive() ).features( AEFeature.StorageCells, AEFeature.MEDrive ).build();
		this.chest = registry.block( "chest", new BlockChest() ).features( AEFeature.StorageCells, AEFeature.MEChest ).build();
		this.iface = registry.block( "interface", new BlockInterface() ).build();
		this.cellWorkbench = registry.block( "cell_workbench", new BlockCellWorkbench() ).features( AEFeature.StorageCells ).build();
		this.iOPort = registry.block( "ioport", new BlockIOPort() ).features( AEFeature.StorageCells, AEFeature.IOPort ).build();
		this.condenser = registry.block( "condenser", new BlockCondenser() ).build();
		this.energyAcceptor = registry.block( "energy_acceptor", new BlockEnergyAcceptor() ).build();
		
		this.energyCell = registry.block( "energy_cell", new BlockEnergyCell() ).withItemBlock( AEBaseItemBlockChargeable::new ).rendering( new BlockEnergyCellRendering( new ResourceLocation( AppEng.MOD_ID, "energy_cell" ) ) ).build();
		this.energyCellDense = registry.block( "dense_energy_cell", new BlockDenseEnergyCell() ).features( AEFeature.DenseEnergyCells ).withItemBlock( AEBaseItemBlockChargeable::new ).rendering( new BlockEnergyCellRendering( new ResourceLocation( AppEng.MOD_ID, "dense_energy_cell" ) ) ).build();
		this.energyCellCreative = registry.block( "creative_energy_cell", new BlockCreativeEnergyCell() ).features( AEFeature.Creative ).withItemBlock( AEBaseItemBlockChargeable::new ).build();

		init();
	}

}

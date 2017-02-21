
package appeng.core.me.definitions;


import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import appeng.api.definitions.IBlockDefinition;
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
		this.multiPart = registry.block( new ResourceLocation( AppEng.MODID, "multipart_block" ), new BlockCableBus() ).rendering( new BlockRenderingCustomizer(){
			@Override
			@SideOnly( Side.CLIENT )
			public void customize( IBlockRendering rendering, IItemRendering itemRendering )
			{
				rendering.modelCustomizer( new CableModelCustomizer()::customizeModel ).blockColor( new CableBusColor() );
			}
		} ).createDefaultItemBlock().build();
		
		this.wirelessAccessPoint = registry.block( new ResourceLocation( AppEng.MODID, "wireless_access_point" ), new BlockWireless() ).features( AEFeature.WirelessAccessTerminal ).createDefaultItemBlock().build();

		this.securityStation = registry.block( new ResourceLocation( AppEng.MODID, "security_station" ), new BlockSecurity() ).features( AEFeature.Security ).createDefaultItemBlock().build();
		this.quantumRing = registry.block( new ResourceLocation( AppEng.MODID, "quantum_ring" ), new BlockQuantumRing() ).features( AEFeature.QuantumNetworkBridge ).createDefaultItemBlock().build();
		this.quantumLink = registry.block( new ResourceLocation( AppEng.MODID, "quantum_link" ), new BlockQuantumLinkChamber() ).features( AEFeature.QuantumNetworkBridge ).createDefaultItemBlock().build();
		
		this.controller = registry.block( new ResourceLocation( AppEng.MODID, "controller" ), new BlockController() ).features( AEFeature.Channels ).createDefaultItemBlock().build();
		this.drive = registry.block( new ResourceLocation( AppEng.MODID, "drive" ), new BlockDrive() ).features( AEFeature.StorageCells, AEFeature.MEDrive ).createDefaultItemBlock().build();
		this.chest = registry.block( new ResourceLocation( AppEng.MODID, "chest" ), new BlockChest() ).features( AEFeature.StorageCells, AEFeature.MEChest ).createDefaultItemBlock().build();
		this.iface = registry.block( new ResourceLocation( AppEng.MODID, "interface" ), new BlockInterface() ).createDefaultItemBlock().build();
		this.cellWorkbench = registry.block( new ResourceLocation( AppEng.MODID, "cell_workbench" ), new BlockCellWorkbench() ).features( AEFeature.StorageCells ).createDefaultItemBlock().build();
		this.iOPort = registry.block( new ResourceLocation( AppEng.MODID, "ioport" ), new BlockIOPort() ).features( AEFeature.StorageCells, AEFeature.IOPort ).createDefaultItemBlock().build();
		this.condenser = registry.block( new ResourceLocation( AppEng.MODID, "condenser" ), new BlockCondenser() ).createDefaultItemBlock().build();
		this.energyAcceptor = registry.block( new ResourceLocation( AppEng.MODID, "energy_acceptor" ), new BlockEnergyAcceptor() ).createDefaultItemBlock().build();
		
		this.energyCell = registry.block( new ResourceLocation( AppEng.MODID, "energy_cell" ), new BlockEnergyCell() ).withItemBlock( AEBaseItemBlockChargeable::new ).rendering( new BlockEnergyCellRendering( new ResourceLocation( AppEng.MODID, "energy_cell" ) ) ).build();
		this.energyCellDense = registry.block( new ResourceLocation( AppEng.MODID, "dense_energy_cell" ), new BlockDenseEnergyCell() ).features( AEFeature.DenseEnergyCells ).withItemBlock( AEBaseItemBlockChargeable::new ).rendering( new BlockEnergyCellRendering( new ResourceLocation( AppEng.MODID, "dense_energy_cell" ) ) ).build();
		this.energyCellCreative = registry.block( new ResourceLocation( AppEng.MODID, "creative_energy_cell" ), new BlockCreativeEnergyCell() ).features( AEFeature.Creative ).withItemBlock( AEBaseItemBlockChargeable::new ).build();

		init();
	}

}

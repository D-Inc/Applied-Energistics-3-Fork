
package appeng.core.lib.crash;


import appeng.core.lib.AEConfig;


public class ModCrashEnhancement extends BaseCrashEnhancement
{
	private static final String MOD_VERSION = AEConfig.VERSION + " for Forge " + // WHAT?
			net.minecraftforge.common.ForgeVersion.majorVersion + '.' // majorVersion
			+ net.minecraftforge.common.ForgeVersion.minorVersion + '.' // minorVersion
			+ net.minecraftforge.common.ForgeVersion.revisionVersion + '.' // revisionVersion
			+ net.minecraftforge.common.ForgeVersion.buildVersion;

	public ModCrashEnhancement( final CrashInfo output )
	{
		super( "AE2 Version", MOD_VERSION );
	}
}

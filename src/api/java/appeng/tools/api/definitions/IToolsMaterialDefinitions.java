
package appeng.tools.api.definitions;


import appeng.api.definitions.IDefinitions;
import appeng.api.definitions.IMaterialDefinition;
import appeng.core.api.material.Material;


public interface IToolsMaterialDefinitions extends IDefinitions<Material, IMaterialDefinition<Material>>
{

	default IMaterialDefinition<Material> matterBall()
	{
		return get( "matter_ball" );
	}

}

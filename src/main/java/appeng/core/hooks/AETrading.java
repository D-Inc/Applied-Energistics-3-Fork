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

package appeng.core.hooks;


// TODO Pre-1.8 - Villager Trading!??!?!

public class AETrading
{

	/*
	 * @Override
	 * public void manipulateTradesForVillager( EntityVillager villager, MerchantRecipeList recipeList, Random random )
	 * {
	 * final IMaterials materials = AppEngApi.internalApi().definitions().materials();
	 * this.addMerchant( recipeList, materials.silicon(), 1, random, 2 );
	 * this.addMerchant( recipeList, materials.certusQuartzCrystal(), 2, random, 4 );
	 * this.addMerchant( recipeList, materials.certusQuartzDust(), 1, random, 3 );
	 * this.addTrade( recipeList, materials.certusQuartzDust(), materials.certusQuartzCrystal(), random, 2 );
	 * }
	 * private void addMerchant( MerchantRecipeList list, IItemDefinition item, int emera, Random rand, int greed )
	 * {
	 * for( ItemStack itemStack : item.maybeStack( 1 ).asSet() )
	 * {
	 * // Sell
	 * ItemStack from = itemStack.copy();
	 * ItemStack to = new ItemStack( Items.emerald );
	 * int multiplier = ( Math.abs( rand.nextInt() ) % 6 );
	 * final int emeraldCost = emera + ( Math.abs( rand.nextInt() ) % greed ) - multiplier;
	 * int mood = rand.nextInt() % 2;
	 * from.setCount(multiplier + mood);
	 * to.setCount(multiplier * emeraldCost - mood);
	 * if( to.getCount() < 0 )
	 * {
	 * from.shrink(to.getCount());
	 * to.shrink(to.getCount());
	 * }
	 * this.addToList( list, from, to );
	 * // Buy
	 * ItemStack reverseTo = from.copy();
	 * ItemStack reverseFrom = to.copy();
	 * reverseFrom.getCount() *= rand.nextFloat() * 3.0f + 1.0f;
	 * this.addToList( list, reverseFrom, reverseTo );
	 * }
	 * }
	 * private void addTrade( MerchantRecipeList list, IItemDefinition inputDefinition, IItemDefinition
	 * outputDefinition, Random rand, int conversionVariance )
	 * {
	 * final Optional<ItemStack> maybeInputStack = inputDefinition.maybeStack( 1 );
	 * final Optional<ItemStack> maybeOutputStack = outputDefinition.maybeStack( 1 );
	 * if( maybeInputStack.isPresent() && maybeOutputStack.isPresent() )
	 * {
	 * // Sell
	 * ItemStack inputStack = maybeInputStack.get().copy();
	 * ItemStack outputStack = maybeOutputStack.get().copy();
	 * inputStack.setCount(1 + ( Math.abs( rand.nextInt() ) % ( 1 + conversionVariance ) ));
	 * outputStack.setCount(1);
	 * this.addToList( list, inputStack, outputStack );
	 * }
	 * }
	 * private void addToList( MerchantRecipeList l, ItemStack a, ItemStack b )
	 * {
	 * if( a.getCount() < 1 )
	 * {
	 * a.setCount(1);
	 * }
	 * if( b.getCount() < 1 )
	 * {
	 * b.setCount(1);
	 * }
	 * if( a.getCount() > a.getMaxStackSize() )
	 * {
	 * a.setCount(a.getMaxStackSize());
	 * }
	 * if( b.getCount() > b.getMaxStackSize() )
	 * {
	 * b.setCount(b.getMaxStackSize());
	 * }
	 * l.add( new MerchantRecipe( a, b ) );
	 * }
	 */

}

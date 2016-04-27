package com.deanveloper.blok.block

import com.deanveloper.blok.item.Material

/**
 * @author Dean B
 */
class Fluid(
		val type: Material,
		var distance: Int = 0,
		var downward: Boolean = false
) : BlockData {
	override val id = when(type) {
		Material.FLOWING_WATER, Material.FLOWING_LAVA -> type.name.toLowerCase()
		else -> throw IllegalStateException("[type] is not flowing water/lava (is $type)")
	}

	override val intId: Int
		get() = when (type) {
			Material.FLOWING_WATER -> 8
			Material.FLOWING_LAVA -> 10
			else -> throw IllegalStateException("[type] is not flowing water/lava (is $type)")
		}

	override val extraData: Byte
		get() = (if (downward) {
			distance or 0x8
		} else {
			distance
		} ).toByte()

	override fun clone() = Fluid(type, distance, downward)

}
package com.deanveloper.blok.item

import com.deanveloper.blok.util.Data
import com.deanveloper.blok.util.Magic

/**
 * Data for an item
 *
 * @author Dean B
 */
open class SimpleItem(
		override val id: String
) : Data {
	override val isItem = true
	override val isBlock = false
	override val intId = Magic.stringIdToInt(id)
	override val extraData: Byte = 0
	override fun clone() = SimpleItem(id)
}
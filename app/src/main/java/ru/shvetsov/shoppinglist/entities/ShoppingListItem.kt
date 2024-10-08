package ru.shvetsov.shoppinglist.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_list_item")
data class ShoppingListItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "itemInfo")
    val itemInfo: String = "",
    @ColumnInfo(name = "itemChecked")
    val itemChecked: Boolean = false,
    @ColumnInfo(name = "listId")
    val listId: Int,
    @ColumnInfo(name = "itemType")
    val itemType: Int = 0
)
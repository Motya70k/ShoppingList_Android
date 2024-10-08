package ru.shvetsov.shoppinglist.dialogs

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import ru.shvetsov.shoppinglist.R
import ru.shvetsov.shoppinglist.databinding.NewListDialogBinding

object NewListDialog {
    fun showDialog(context: Context, listener: Listener, name: String) {
        var dialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        val binding = NewListDialogBinding.inflate(LayoutInflater.from(context))

        builder.setView(binding.root)
        binding.apply {
            edNewListName.setText(name)
            if (name.isNotEmpty()) buttonCreate.text = context.getString(R.string.update)
            buttonCreate.setOnClickListener {
                val listName = edNewListName.text.toString()
                if (listName.isNotEmpty()) {
                    listener.onClick(listName)
                }
                dialog?.dismiss()
            }
        }
        dialog = builder.create()
        dialog.window?.setBackgroundDrawable(null)
        dialog.show()
    }

    interface Listener {
        fun onClick(name: String)
    }
}
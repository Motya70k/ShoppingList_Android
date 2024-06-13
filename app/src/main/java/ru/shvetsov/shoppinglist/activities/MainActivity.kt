package ru.shvetsov.shoppinglist.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.shvetsov.shoppinglist.R
import ru.shvetsov.shoppinglist.databinding.ActivityMainBinding
import ru.shvetsov.shoppinglist.dialogs.NewListDialog
import ru.shvetsov.shoppinglist.fragments.FragmentManager
import ru.shvetsov.shoppinglist.fragments.NoteFragment
import ru.shvetsov.shoppinglist.fragments.ShoppingListNameFragment

class MainActivity : AppCompatActivity(), NewListDialog.Listener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FragmentManager.setFragment(ShoppingListNameFragment.newInstance(), this)
        setBottomNavListener()
    }

    private fun setBottomNavListener() {
        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> {}
                R.id.notes -> {
                    FragmentManager.setFragment(NoteFragment.newInstance(), this)
                }
                R.id.shop_list -> {
                    FragmentManager.setFragment(ShoppingListNameFragment.newInstance(), this)
                }
                R.id.new_item -> {
                    FragmentManager.currentFragment?.onClickNew()
                }
            }
            true
        }
    }

    override fun onClick(name: String) {
        Log.d("Log", "Name: $name")
    }
}
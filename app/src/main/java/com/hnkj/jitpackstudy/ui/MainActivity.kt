package com.hnkj.jitpackstudy.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.hnkj.jitpackstudy.MyApplication
import com.hnkj.jitpackstudy.R
import com.hnkj.jitpackstudy.viewModels.UserViewModel
import com.hnkj.jitpackstudy.viewModels.UserViewModelFactory

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((application as MyApplication).repository)
    }

    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            userViewModel.deleteAll()
            true
        }

        R.id.action_favorite -> {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            Snackbar.make(toolbar, "点击了收藏按钮", Snackbar.LENGTH_LONG).setAction("测试") {
                Toast.makeText(this, "点击了Snackbar设置的事件", Toast.LENGTH_SHORT).show()
            }.show()
            true
        }
        android.R.id.home -> {
            finish()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}
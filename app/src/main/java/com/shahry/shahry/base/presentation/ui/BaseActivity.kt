package com.shahry.shahry.base.presentation.ui

import android.annotation.SuppressLint
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity : AppCompatActivity() {


    /**
     * Inline Function used to define databinding layout and
     * Set the content view to the activty
     * @param resId [Int] layout resource id
     * @return [kotlin.Lazy]<[ViewDataBinding]> View Data Binding used to access view layout and bind data to view
     */
    protected inline fun <reified T : ViewDataBinding> binding(
        @LayoutRes resId: Int,
    ): T = DataBindingUtil.setContentView(this, resId)




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
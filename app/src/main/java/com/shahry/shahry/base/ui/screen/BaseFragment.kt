package com.shahry.shahry.base.ui.screen

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.shahry.shahry.base.ui.viewmodel.*

abstract class BaseFragment<DataBinding : ViewDataBinding, STATE : ViewState, EVENT : ViewEvent, ACTION : Action, RESULT : Result>(
    @LayoutRes layoutId: Int,
) : Fragment(layoutId) {

    abstract val viewModel: NewBaseViewModel<STATE, EVENT, ACTION, RESULT>

    private var onBackPressedCallback: OnBackPressedCallback? = null


    private var internalDataBinding: DataBinding? = null
    protected val dataBinding: DataBinding
        get() {
            return internalDataBinding ?: throw IllegalStateException(
                "data binding should not be requested before onViewCreated is called"
            )
        }

    fun addOnBackPressed(
        isEnabled: Boolean = false,
        onBackPressed: () -> Unit = { requireActivity().finish() },
    ) {
        onBackPressedCallback?.isEnabled = isEnabled

        if (onBackPressedCallback == null) {
            onBackPressedCallback =
                object : OnBackPressedCallback(isEnabled /* disabled by default */) {
                    override fun handleOnBackPressed() {
                        onBackPressed.invoke()
                    }
                }
            requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback!!)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        internalDataBinding = DataBindingUtil.bind<DataBinding>(view)?.apply {
            lifecycleOwner = this@BaseFragment
        }


        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { handleViewState(it) }
        }
    }


    /**
     * abstract function need to be implemented, used to receive new [ViewState] from the view model
     *
     * @param state is the new state of the ui to be handled
     */
    abstract fun handleViewState(state: STATE)

    /**
     * function used to initialize view events listener
     *
     * @param handleViewEvent callback function to receive new [ViewEvent] from the view model
     */
    fun initViewEvents(handleViewEvent: (event: EVENT) -> Unit) {
        lifecycleScope.launchWhenStarted {
            viewModel.uiEvent.collect { handleViewEvent(it) }
        }
    }


    override fun onDestroyView() {
        // Scoped to the lifecycle of the fragment's view (between onCreateView and onDestroyView)
        internalDataBinding = null
        super.onDestroyView()
    }

}
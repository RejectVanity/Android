package com.duckduckgo.duckplayer.api

import android.app.Dialog
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieCompositionFactory
import com.airbnb.lottie.LottieDrawable
import com.duckduckgo.duckplayer.api.databinding.BottomSheetDuckPlayerBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DuckPlayerBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDuckPlayerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = BottomSheetDuckPlayerBinding.inflate(inflater, container, false)
        LottieCompositionFactory.fromRawRes(context, R.raw.duckplayer)
        binding.duckPlayerAnimation.setAnimation(R.raw.duckplayer)
        binding.duckPlayerAnimation.playAnimation()
        binding.duckPlayerAnimation.repeatCount = LottieDrawable.INFINITE
        binding.dismissButton.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        return dialog
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        dismiss()
    }

    companion object {
        fun newInstance(): DuckPlayerBottomSheet =
            DuckPlayerBottomSheet()
    }
}

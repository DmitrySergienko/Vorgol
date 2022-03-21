package ru.ds.vorgol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.ds.vorgol.databinding.SectorsFragmentBinding

class SectorsFragment : Fragment() {

    private var _binding: SectorsFragmentBinding? = null
    private val binding: SectorsFragmentBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SectorsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = SectorsFragment()
    }
}
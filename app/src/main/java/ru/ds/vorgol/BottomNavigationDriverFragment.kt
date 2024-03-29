package ru.ds.vorgol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.ds.vorgol.databinding.BottomNavigationLayoutBinding


class BottomNavigationDriverFragment  : BottomSheetDialogFragment() {
    private var _binding: BottomNavigationLayoutBinding? = null
    private val binding: BottomNavigationLayoutBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomNavigationLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Sector_A->{
                    //startActivity(Intent(requireContext(),NavigationActivity::class.java))
                }
                R.id.Sector_B->{
                    //startActivity(Intent(requireContext(), BottomNavigationActivity::class.java))
                }
                R.id.Sector_C->{
                    //startActivity(Intent(requireContext(), LayoutActivity::class.java))
                }
                R.id.Sector_D->{
                    //startActivity(Intent(requireContext(), LayoutActivity::class.java))
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
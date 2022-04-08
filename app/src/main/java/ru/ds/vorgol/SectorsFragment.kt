package ru.ds.vorgol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ds.vorgol.databinding.SectorsFragmentBinding

class SectorsFragment : Fragment() {

    private var adapter:SectorsAdapter? =null
    private var index = 0

    private val imageIdList = listOf(
        R.drawable.bg_earth,
        R.drawable.bg_mars,
        R.drawable.bg_system,
    )


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    //настраиваем вид как будет отображаться шаблоны
    private fun init(){
        binding.apply {

            val list =ArrayList<Sectors>()

            recyclerView.layoutManager =LinearLayoutManager(requireContext())
            adapter = SectorsAdapter(list,requireContext())
            recyclerView.adapter = adapter

           button.setOnClickListener {
                if (index > 2) index = 0
                val sectorId = Sectors(imageIdList[index],"Sector $index")
                adapter?.addItemSector(sectorId)
                index++
           }
        }
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
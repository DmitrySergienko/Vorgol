package ru.ds.vorgol

import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.ds.vorgol.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    private var adapter: ImageAdapter? = null

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    //настраиваем вид как будет отображаться шаблоны
    private fun init() {
        binding.apply {
            val list = ArrayList<Sectors>()
            list.addAll(
                fillArray(
                    resources.getStringArray(R.array.sTitle_Array),
                    resources.getStringArray(R.array.sContent_Array),
                    getImageId(R.array.sImage_array)
                )
            )
            recycleView.hasFixedSize()
            recycleView.layoutManager = LinearLayoutManager(requireContext())
            adapter = ImageAdapter(list, requireContext())
            recycleView.adapter = adapter
        }
    }

    fun fillArray(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray,
    ): List<Sectors> {
        var listItemArray = ArrayList<Sectors>()
        for (n in titleArray.indices)
        {
            var listItem = Sectors(titleArray[n],contentArray[n],imageArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId: Int): IntArray {
        val tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
package ru.ds.vorgol

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import ru.ds.vorgol.databinding.SectorItemBinding

class ImageAdapter(listArray: ArrayList<Sectors>, context: Context): RecyclerView.Adapter<ImageAdapter.SectorsHolder>() {

    //создаем список элементов
    val sectorItemList = listArray
    val contextAdapter = context

//хранит ссылки на наши элемнты view
    class SectorsHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = SectorItemBinding.bind(item)

        fun bind(sectors: Sectors,context: Context) = with(binding) {
            imageView.setImageResource(sectors.image_id)
            textViewContent.text = sectors.title_text
            textViewTitle.text = sectors.contentText
            imageView.setOnClickListener {

            }
        }
    }
//надуваем шаблон и предаем в класс SectorHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectorsHolder {
        val view = LayoutInflater.from(contextAdapter).inflate(R.layout.sector_item,parent,false) //get layoutInflater
        return SectorsHolder(view)

    }

    override fun onBindViewHolder(holder: SectorsHolder, position: Int) {
        holder.bind(sectorItemList[position],contextAdapter)
    }

    override fun getItemCount(): Int {
        return sectorItemList.size
    }

    fun addItemSector(itemSector: Sectors){
        sectorItemList.add(itemSector)
         // показывает адаптеру что данные изменились
    }


}
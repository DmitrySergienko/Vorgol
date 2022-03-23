package ru.ds.vorgol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.vorgol.databinding.SectorItemBinding

class SectorsAdapter: RecyclerView.Adapter<SectorsAdapter.SectorsHolder>() {

    //создаем список элементов
    val sectorItemList = ArrayList<Sectors>()


    class SectorsHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = SectorItemBinding.bind(item)
        fun bind(sectors: Sectors) = with(binding) {
            imageViewSectors.setImageResource(sectors.imageId)
            textViewSectorsTitle.text = sectors.title
        }
    }
//надуваем шаблон и предаем в класс SectorHolder(который хранит ссылки на наши элемнты view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectorsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sector_item,parent,false) //get layoutInflater
        return SectorsHolder(view)
    }

    override fun onBindViewHolder(holder: SectorsHolder, position: Int) {
        holder.bind(sectorItemList[position])
    }

    override fun getItemCount(): Int {
        return sectorItemList.size
    }

    fun addItemSector(itemSector: Sectors){
        sectorItemList.add(itemSector)
        notifyDataSetChanged() // показывает адаптеру что данные изменились
    }
}
package ru.ds.vorgol

import android.app.LauncherActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ds.vorgol.databinding.SectorItemBinding

class SectorsAdapter(listArray: ArrayList<Sectors>,context: Context): RecyclerView.Adapter<SectorsAdapter.SectorsHolder>() {

    //создаем список элементов
    val sectorItemList = listArray
    val contextAdapter = context


    class SectorsHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = SectorItemBinding.bind(item)

        fun bind(sectors: Sectors,context: Context) = with(binding) {
            imageViewSectors.setImageResource(sectors.imageId)
            textViewSectorsTitle.text = sectors.title
        }
    }
//надуваем шаблон и предаем в класс SectorHolder(который хранит ссылки на наши элемнты view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectorsHolder {
        val inflater =LayoutInflater.from(contextAdapter)
        return SectorsHolder(inflater.inflate(R.layout.sector_item,parent,false))


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

    fun updateAdapter(listArray:ArrayList<Sectors>){
        sectorItemList.clear()
        sectorItemList.addAll(listArray)
        notifyDataSetChanged()
    }
}
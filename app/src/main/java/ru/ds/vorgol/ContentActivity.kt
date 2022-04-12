package ru.ds.vorgol


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.chrisbanes.photoview.PhotoView
import ru.ds.vorgol.databinding.SectorItemBinding


class ContentActivity : AppCompatActivity() {
    lateinit var binding: SectorItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SectorItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
//zoom PhotoView
        val photoView = binding.imageView as PhotoView
        photoView.setImageResource(intent.getIntExtra("image",R.drawable.ic_place_wiki))

       with(binding){
           textViewTitle.text = intent.getStringExtra("Title")
           textViewContent.text = intent.getStringExtra("context")
           imageView.setImageResource(intent.getIntExtra("image",R.drawable.bg_earth))
       }



    }
}
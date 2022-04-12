package ru.ds.vorgol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ds.vorgol.databinding.ActivityContentBinding
import ru.ds.vorgol.databinding.ContentFragmentBinding
import ru.ds.vorgol.databinding.MainFragmentBinding

class ContentActivity : AppCompatActivity() {
    lateinit var binding: ContentFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            textViewTitle.text = intent.getStringExtra("Title")
            textViewContext.text = intent.getStringExtra("context")
            imageView.setImageResource(intent.getIntExtra("image",R.drawable.bg_earth))
        }

    }
}
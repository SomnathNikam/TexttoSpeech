package com.example.asuper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech

import com.example.asuper.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    lateinit var tts:TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnspeak.setOnClickListener{
            tts = TextToSpeech(this, TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS){
                    tts.language = Locale.US
                    tts.setSpeechRate(0.0f)
                    tts.speak(binding.etmultitext.text.toString(),TextToSpeech.QUEUE_ADD,null)
                }
            })
        }


    }
}
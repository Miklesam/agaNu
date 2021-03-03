package com.miklesam.hamiton_test

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.examples.classification.tflite.Classifier

class MainActivity : AppCompatActivity() {

    lateinit var classifier: Classifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        classifier =
            Classifier.create(this, Classifier.Model.QUANTIZED_MOBILENET, Classifier.Device.CPU, 10)
        val icon: Bitmap = BitmapFactory.decodeResource(
            applicationContext.resources,
            R.drawable.dj
        )
        Log.w("Hamiton","Start")
        val result = classifier.recognizeImage(icon, 90)
        Log.w("Hamiton",result.toString())
    }
}
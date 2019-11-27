package pl.daftcode.wishes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var phoneNumberRetriever: Retriever

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        phoneNumberRetriever = PhoneNumberRetriever(context = this)
        selectPersonButton.setOnClickListener { }
        sendWishesButton.setOnClickListener { }
    }

    private fun getWishes(context: Context): Array<String> = context.resources.getStringArray(R.array.wishes)
}

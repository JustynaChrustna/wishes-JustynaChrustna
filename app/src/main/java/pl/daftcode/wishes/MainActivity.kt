package pl.daftcode.wishes

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE: Int=99
    val PICK_CONTACT_REQUEST = 1

    private lateinit var phoneNumberRetriever: Retriever
    var phoneNumber:String?=""
    var contactData:Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        phoneNumberRetriever = PhoneNumberRetriever(context = this)
        selectPersonButton.setOnClickListener {
            val intent=Intent(Intent.ACTION_PICK, Uri.parse("content://contacts")).also {
                pickContactIntent->
                pickContactIntent.type=ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
                startActivityForResult(pickContactIntent,PICK_CONTACT_REQUEST)

            }
            onActivityResult(REQUEST_CODE, Activity.RESULT_OK, intent)

        }
        sendWishesButton.setOnClickListener {
            val listItems= getWishes(this)
            val dialogBuilder=AlertDialog.Builder(this@MainActivity)
            dialogBuilder.setSingleChoiceItems(listItems, -1){
                dialogInterface, i->
                val text=listItems[i]
                dialogInterface.dismiss()
                val uri=Uri.parse("smsto:"+phoneNumber)
                val intent= Intent(Intent.ACTION_SENDTO, uri).apply {
                    putExtra("sms_body", text)
                }
                startActivity(intent)
                //

            }
            val dialog=dialogBuilder.create()
            dialog.show()


            }


        }


    private fun getWishes(context: Context): Array<String> = context.resources.getStringArray(R.array.wishes)


   @SuppressLint("MissingSuperCall")
   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                contactData=intent.data
                phoneNumber=phoneNumberRetriever.retrieve(ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
                txtView.text=phoneNumber
            }
        }
    }
}

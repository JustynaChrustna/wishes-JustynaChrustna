package pl.daftcode.wishes

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract

class PhoneNumberRetriever(private val context: Context) : Retriever {

    override fun retrieve(uri: Uri): String? {
        val projection: Array<String> = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
        val cursor = createCursor(uri, projection)
        return if (cursor != null && cursor.moveToFirst()) {
            val numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val number = cursor.getString(numberIndex)
            cursor.close()
            number
        } else {
            null
        }
    }

    private fun createCursor(uri: Uri, projection: Array<String>): Cursor? {
        return context.contentResolver.query(uri, projection, null, null, null)
    }
}

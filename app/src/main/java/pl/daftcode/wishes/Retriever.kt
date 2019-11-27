package pl.daftcode.wishes

import android.net.Uri

interface Retriever {
    fun retrieve(uri: Uri): String?
}

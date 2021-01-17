package com.example.aula46storage

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.net.toFile
import com.google.firebase.FirebaseApp
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.lang.System.currentTimeMillis

class MainActivity : AppCompatActivity() {

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnProcurar).setOnClickListener {
            procurarArquivo()
        }

        findViewById<Button>(R.id.btnEnviar).setOnClickListener {
            enviarArquivo()
        }
    }

    private fun enviarArquivo() {
        imageUri?.run {
            val firebase = FirebaseStorage.getInstance()
            val storage = firebase.getReference("uploads")

            val extension = MimeTypeMap.getSingleton()
                .getExtensionFromMimeType(contentResolver.getType(imageUri!!))

            val fileReference = storage.child("${currentTimeMillis()}.${extension}")

            fileReference.putFile(this)
                .addOnSuccessListener {
                    Toast.makeText(this@MainActivity, "Sucesso", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this@MainActivity, "Falhou", Toast.LENGTH_SHORT).show()
                }
                .addOnProgressListener {
                    Log.d("TAG", it.toString())
                }
        }
    }


    fun procurarArquivo() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, CONTENT_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == CONTENT_REQUEST_CODE && resultCode == RESULT_OK) {
            imageUri = data?.data
            findViewById<ImageView>(R.id.imgPreview).setImageURI(imageUri)
        }
    }

    companion object {
        const val CONTENT_REQUEST_CODE = 1
    }

    // retorna o nome
//    private fun getFileName(uri: Uri): String? {
//        var result: String? = null
//        if (uri.scheme == "content") {
//            val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
//            try {
//                if (cursor != null && cursor.moveToFirst()) {
//                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
//                }
//            } finally {
//                cursor?.close()
//            }
//        }
//        if (result == null) {
//            result = uri.path
//            val cut = result!!.lastIndexOf('/')
//            if (cut != -1) {
//                result = result.substring(cut + 1)
//            }
//        }
//        return result
//    }
}
package com.shashi.shashi_dce_desk.Fragments


import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.nfc.Tag
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.example.shashi_dce_desk.R
import com.example.shashi_dce_desk.R.id.medicalFormat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.FileOutputStream


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CounselingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounselingFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var imageView: ImageView
    lateinit var btnDocument :Button
    lateinit var documentsList :ImageView
    lateinit var btnMedicalFormat :Button
    lateinit var medical_format : ImageView
    lateinit var antiRagging : Button
    lateinit var btnFdoc : FloatingActionButton
    lateinit var constdoc : ConstraintLayout
    lateinit var fmedical : FloatingActionButton
    lateinit var medicalconst : ConstraintLayout
    var visibledocs = false
    var visibleMedical = false





    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_counseling, container, false)

        btnDocument = view.findViewById(R.id.btnDocument)
        documentsList = view.findViewById(R.id.documentsList)
        btnMedicalFormat = view.findViewById(medicalFormat)
        medical_format = view.findViewById(R.id.medical)
        antiRagging = view.findViewById(R.id.antiRagging)
        constdoc = view.findViewById(R.id.dList)
        btnFdoc = view.findViewById(R.id.fdoc)
        fmedical = view.findViewById(R.id.fmedical)
        medicalconst = view.findViewById(R.id.medicalconst)





        btnDocument.setOnClickListener {
            if(visibledocs == false){
                constdoc.visibility = View.VISIBLE
                visibledocs = true

                if(visibleMedical == true){
                    visibleMedical = false
                    medicalconst.visibility = View.GONE
                }
            }
            else{
                constdoc.visibility = View.GONE
                visibledocs = false
            }

        }

        btnFdoc.setOnClickListener {

            if(checkPermission()){

                downloadImage()
                getImage(documentsList)
            }
            else{

                requestPermission()
            }


        }

        btnMedicalFormat.setOnClickListener {
            if(visibleMedical == false){
                medicalconst.visibility = View.VISIBLE
                visibleMedical = true

                if(visibledocs == true){
                    visibledocs = false
                    constdoc.visibility = View.GONE
                }
            }
            else{
                medicalconst.visibility = View.GONE
                visibleMedical = false
            }


            fmedical.setOnClickListener {

                if (checkPermission()) {

                    downloadImage()
                    getImage(medical_format)
                } else {

                    requestPermission()
                }

            }
        }

        antiRagging.setOnClickListener {
            Toast.makeText(activity , "Available Soon",Toast.LENGTH_SHORT).show()

        }



        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CounselingFragment.
         */
        // TODO: Rename and change types and number of parameters

        private const val STORAGE_PERMISSION_CODE = 100
        private const val TAG = "PERMISSION_TAG"


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CounselingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }







    fun getImage(iv :ImageView){


        val bitmap = iv.getDrawable().toBitmap()


        var outStream: FileOutputStream? = null
        val sdCard = Environment.getExternalStorageDirectory()
        val dir = File(sdCard.absolutePath + "/DceDesk")
       val download =  dir.mkdirs()


        if(download){
            Toast.makeText(activity as Context ,"Download in  ${dir.absolutePath}",Toast.LENGTH_LONG).show()

        }
        else{

            Toast.makeText(activity as Context ,"Downloaded /Storage/emulated/0/DceDesk",Toast.LENGTH_LONG).show()


        }
        val fileName = String.format("%d.jpg", System.currentTimeMillis())
        val outFile = File(dir, fileName)
        outStream = FileOutputStream(outFile)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream)
        outStream.flush()
        outStream.close()
    }



    private fun downloadImage(){
        val foldername = "DceDesk"


        val file = File(Environment.getExternalStorageDirectory().toString()+"/"+foldername)
        val folderCreated = file.mkdir()
//
//        if(folderCreated){
//          //   Toast.makeText(activity as Context ,"Downloaded ${file.absolutePath}",Toast.LENGTH_LONG).show()
//
//        }
//        else{
//
//            Toast.makeText(activity as Context ,"Not Downloaded ",Toast.LENGTH_LONG).show()
//
//
//        }


    }


    private fun requestPermission(){
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.R){

            try {
                Log.d(TAG,"requestPermission: try")
                val intent = Intent()
                intent.action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
                val uri = Uri.fromParts("package",requireContext().packageName,null)
                intent.data = uri
                storageActivityResultLauncher.launch(intent)


            }catch (e : Exception){

                Log.e(TAG,"requestPermission: " ,e)
                val intent = Intent()
                intent.action = Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION
                storageActivityResultLauncher.launch(intent)
            }
        }
        else{
            //below android 11

            ActivityCompat.requestPermissions(
                requireActivity(),
           arrayOf( Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE),STORAGE_PERMISSION_CODE)
        }
    }

    private  val storageActivityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        Log.d(TAG,"storageActivityResultLauncher: ")

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.R){

            if(Environment.isExternalStorageManager()){
                Log.d(TAG,"storageActivityResultLauncher: ")
                downloadImage()
            }else{
                Log.d(TAG,"storageActivityResultLauncher: ")
                Toast.makeText(activity as Context,"Manage External Permission is Denied",Toast.LENGTH_LONG).show()
            }
        }else
        {
            //below android 11
        }

    }
    private fun checkPermission() : Boolean
    {
        //android 11

        return if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.R){
            Environment.isExternalStorageManager()
        }else{
            val write = ContextCompat.checkSelfPermission(requireActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val read = ContextCompat.checkSelfPermission(requireActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)

             write == PackageManager.PERMISSION_GRANTED && read == PackageManager.PERMISSION_GRANTED
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == STORAGE_PERMISSION_CODE){
            if(grantResults.isNotEmpty()) {
                val write = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val read = grantResults[1] == PackageManager.PERMISSION_GRANTED

                if (write && read) {
                    Log.d(TAG,"onRequestPermissionResult: ")
                    downloadImage()
                }
                else{
                    Log.d(TAG,"onRequestPermissionREsult: ")
                    Toast.makeText(activity as Context,"External Storage Permission Denied",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
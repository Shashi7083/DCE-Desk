package com.shashi.shashi_dce_desk.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.webkit.WebView
import androidx.fragment.app.Fragment
import android.webkit.WebViewClient
import android.widget.RelativeLayout
import com.example.shashi_dce_desk.R
import com.shashi.shashi_dce_desk.Activity.MainActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QueriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QueriesFragment : Fragment() {
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

    lateinit var webView : WebView
    lateinit var loading : RelativeLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_queries, container, false)



        loading = view.findViewById(R.id.loading)
        webView = view.findViewById(R.id.qweb)
        Handler(Looper.getMainLooper()).postDelayed({
            loading.visibility=View.GONE
            webView.visibility=View.VISIBLE
        }, 1500)

        webView.webViewClient = WebViewClient()
        webView.loadUrl(" https://docs.google.com/forms/d/e/1FAIpQLSc_zlq4ayB-de9CYWbvBoP1oyVXrhSTjZb55pmo4WllBtBaNg/viewform?usp=send_form")
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        webView.canGoBack()
        webView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == MotionEvent.ACTION_UP && webView.canGoBack()) {
                webView.goBack()
                return@OnKeyListener true
            }
            false
        })



        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QueriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QueriesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
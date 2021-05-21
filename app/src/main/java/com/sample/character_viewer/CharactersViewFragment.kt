package com.sample.character_viewer

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sample.character_viewer.model.BaseURL
import com.sample.character_viewer.model.Characters
import com.sample.character_viewer.model.RelatedTopics
import com.sample.character_viewer.model.RestAPI
import kotlinx.android.synthetic.main.fragment_character_view_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharactersViewFragment : Fragment() {

    private lateinit var searchInput: EditText
    private lateinit var mCharactersList: MutableList<RelatedTopics>
    private lateinit var mAdapter: CharactersViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_character_view_list, container, false)

        val searchButton: FloatingActionButton = view.findViewById(R.id.searchChat)
        searchButton.setOnClickListener{
            openChatSearch(it)
        }
        searchInput = view.findViewById(R.id.chatSearchInput)

        searchInput.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString())
            }

        })

        var query = "simpsons+characters"
        if (BuildConfig.APPLICATION_ID.equals("com.sample.simpsonsviewer")) {
            query = "simpsons+characters"
        } else if (BuildConfig.APPLICATION_ID.equals("com.sample.wireviewer")) {
            query = "the+wire+characters"
        }

        val restAPI : RestAPI = BaseURL.getClient()
        restAPI.getEventListByMatch(query, "json").enqueue(object :
            Callback<Characters> {
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                loadData(response)
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                Log.d("onFailure", "error" + t)
            }

        })

        return view
    }

    private fun loadData(response: Response<Characters>) {
        val characters: Characters? = response.body()
        mCharactersList = characters!!.relatedTopics as MutableList<RelatedTopics>
        recycler_view.layoutManager = LinearLayoutManager(context)
        mAdapter = CharactersViewAdapter(mCharactersList)
        recycler_view.adapter = mAdapter
        header_title.text =characters.heading
    }

    private fun filter(text: String) {
        val temp: MutableList<RelatedTopics> = ArrayList()
        for (d in mCharactersList) {
            if (d.text.toLowerCase().contains(text.toLowerCase()) || d.result.toLowerCase().contains(text.toLowerCase())) {
                temp.add(d)
            }
        }
        mAdapter.updateList(temp)
    }

    private fun openChatSearch(view: View) {
        val interpolator = OvershootInterpolator()
        if (chatSearchInput.getVisibility() == View.VISIBLE) {
            ViewCompat.animate(view)
                .rotation(0f)
                .withLayer()
                .setDuration(300)
                .setInterpolator(interpolator)
                .start()
            searchInput.setVisibility(View.GONE)
            header_title.visibility = View.VISIBLE
            hideSoftKeyboard(context, view)
        } else {
            ViewCompat.animate(view)
                .rotation(90f)
                .withLayer()
                .setDuration(300)
                .setInterpolator(interpolator)
                .start()
            header_title.visibility = View.GONE
            searchInput.setVisibility(View.VISIBLE)
        }
    }
    private fun hideSoftKeyboard(context: Context?, view: View) {
        val inputManager: InputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.SHOW_FORCED)
    }
}
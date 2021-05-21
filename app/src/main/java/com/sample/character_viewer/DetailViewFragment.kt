package com.sample.character_viewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.sample.character_viewer.model.BaseURL
import com.sample.character_viewer.model.RelatedTopics
import com.squareup.picasso.Picasso


class DetailViewFragment : Fragment() {
    private val args: DetailViewFragmentArgs by navArgs()
    private lateinit var relatedTopics: RelatedTopics



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail_view, container, false)
        relatedTopics = args.characters
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView: ImageView = view.findViewById(R.id.image_view)
        val description: TextView = view.findViewById(R.id.tv_description)
        description.text = relatedTopics.text
        val path: String
        if (relatedTopics.icon.url.isNotEmpty()) {
            path = BaseURL.BASE_URL + relatedTopics.icon.url
        } else {
            path = BaseURL.BASE_URL + "/i/caa07f01.png"
        }
        Picasso.get().load(path).error(R.drawable.ic_launcher_background).fit().centerCrop().into(imageView)
    }
}
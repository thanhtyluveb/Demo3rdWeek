package com.example.demo3rdweek.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo3rdweek.R
import com.example.demo3rdweek.adapter.AdapterInbox
import com.example.demo3rdweek.adapter.ITranferData
import com.example.demo3rdweek.model.InBoxModel
import kotlinx.android.synthetic.main.fragment_in_box.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [InBoxFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [InBoxFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class InBoxFragment : androidx.fragment.app.Fragment(), ITranferData {
    override fun sendData(name: String) {
        val itemInboxData2: InBoxModel = InBoxModel(name, numberMess = 3)
        listDataInbox.add(0, itemInboxData2)
        adapterInbox.setListData(listDataInbox)
    }

    var listDataInbox: ArrayList<InBoxModel> = ArrayList()
    var itemInboxData: InBoxModel = InBoxModel("Nguyen Duc Thanh")
    var itemInboxData1: InBoxModel = InBoxModel("Nguyen Van Thanh", numberMess = 1)
    var adapterInbox: AdapterInbox = AdapterInbox()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 1..20) {
            listDataInbox.add(itemInboxData)
            listDataInbox.add(itemInboxData1)
        }
        adapterInbox.setListData(listDataInbox)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_in_box, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        rvInboxFragment.apply {
            adapter = adapterInbox
            layoutManager = LinearLayoutManager(activity)
        }
    }
}

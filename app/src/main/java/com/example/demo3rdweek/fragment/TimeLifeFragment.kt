package com.example.demo3rdweek.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo3rdweek.R
import com.example.demo3rdweek.adapter.AdapterItemTimeLife
import com.example.demo3rdweek.model.TimeLifeModel
import kotlinx.android.synthetic.main.fragment_time_life.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TimeLifeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TimeLifeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TimeLifeFragment : androidx.fragment.app.Fragment() {
    private var firstItem: TimeLifeModel = TimeLifeModel("Nguyen Duc Thanh")
    private var listData: ArrayList<TimeLifeModel> = ArrayList()
    private var mAdapter: AdapterItemTimeLife = AdapterItemTimeLife(null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 1..20) {
            listData.add(firstItem)
        }
        mAdapter.setListData(listData)
    }

    override fun onStart() {
        super.onStart()
        rvTimeLife.adapter = mAdapter
        rvTimeLife.layoutManager = LinearLayoutManager(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_time_life, container, false)
    }
}

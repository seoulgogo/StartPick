package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.JobAdapter
import com.seoulapp.startpick.adapter.SupportAdapter
import com.seoulapp.startpick.data.JobData
import com.seoulapp.startpick.data.SupportData
import kotlinx.android.synthetic.main.fragment_mypage_scrap.*
import org.jetbrains.anko.textColorResource

class MypageScrapFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var mypageScrapRecyclerViewAdapter : JobAdapter
    lateinit var mypageSupportBusinessAdapter : SupportAdapter

    var btn_selector = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_mypage_scrap, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        selector()
        setOnClickListener()
        setRecyclerView()
    }

    fun setOnClickListener(){
        btn_selector_business_myapge_scrap_fg.setOnClickListener {
            btn_selector = false
            selector()

            //통신 recyclerview()나오도록
            setRecyclerView()

        }

        btn_selector_job_myapge_scrap_fg.setOnClickListener {
            btn_selector = true
            selector()

            //통신 recyclerview 통신
            setRecyclerView()
        }
    }

    fun selector(){
        if(btn_selector) {
            btn_selector_job_myapge_scrap_fg.setBackgroundResource(R.color.maincolor)
            tv_selector_job_myapge_scrap_fg.textColorResource = R.color.white

            btn_selector_business_myapge_scrap_fg.setBackgroundResource(R.drawable.mypage_scrap_selector_box)
            tv_selector_business_myapge_scrap_fg.textColorResource = R.color.maincolor
        }
        else{
            btn_selector_job_myapge_scrap_fg.setBackgroundResource(R.drawable.mypage_scrap_selector_box)
            tv_selector_job_myapge_scrap_fg.textColorResource = R.color.maincolor

            btn_selector_business_myapge_scrap_fg.setBackgroundResource(R.color.maincolor)
            tv_selector_business_myapge_scrap_fg.textColorResource = R.color.white
        }
    }

    //리사이클러뷰
    fun setRecyclerView() {

        if(btn_selector){
            var mypageScrapData: ArrayList<JobData> = ArrayList()

            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 1", "서울시창업지원센터", "콘텐츠"))
            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 2", "서울시창업지원센터", "콘텐츠"))
            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 3", "서울시창업지원센터", "콘텐츠"))
            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 4", "서울시창업지원센터", "콘텐츠"))
            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 5", "서울시창업지원센터", "콘텐츠"))
            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 6", "서울시창업지원센터", "콘텐츠"))
            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 7", "서울시창업지원센터", "콘텐츠"))
            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 8", "서울시창업지원센터", "콘텐츠"))
            mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 9", "서울시창업지원센터", "콘텐츠"))

            mypageScrapRecyclerViewAdapter = JobAdapter(activity!!, mypageScrapData)
            rv_mypage_scrap_fg.adapter = mypageScrapRecyclerViewAdapter
            rv_mypage_scrap_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
        else{
            var dataList: ArrayList<SupportData> = ArrayList()
            dataList.add(SupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("공고 1", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("공고 2", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("공고 3", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("공고 4", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("공고 5", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("공고 6", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("공고 7", "고용노동부", "~19.09.09"))
            dataList.add(SupportData("공고 8", "고용노동부", "~19.09.09"))


            mypageSupportBusinessAdapter = SupportAdapter(activity!!, dataList)
            rv_mypage_scrap_fg.adapter = mypageSupportBusinessAdapter
            rv_mypage_scrap_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
    }
}
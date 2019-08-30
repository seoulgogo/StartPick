package com.seoulapp.smartpick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.seoulapp.smartpick.base.BasePagerAdapter
import com.seoulapp.smartpick.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewPager
        activity_main_vp_container.run {
            adapter = BasePagerAdapter(supportFragmentManager).apply {
                addFragment(HomeFragment())
                addFragment(JobFragment())
                addFragment(SupportBusinessFragment())
                addFragment(MapFragment())
                addFragment(MypageFragment())
            }
            offscreenPageLimit = 4
        }

        // TabLayout
        activity_main_tl_navi.run{
            val navigationLayout: View =
                    LayoutInflater.from(this@MainActivity).inflate(R.layout.activity_main_navi, null, false)
            setupWithViewPager(activity_main_vp_container)
            getTabAt(0)!!.customView =
                    navigationLayout.findViewById(R.id.activity_main_navi_home_container) as LinearLayout
            getTabAt(1)!!.customView =
                    navigationLayout.findViewById(R.id.activity_main_navi_rank_container) as LinearLayout
            getTabAt(2)!!.customView =
                    navigationLayout.findViewById(R.id.activity_main_navi_vote_container) as LinearLayout
            getTabAt(3)!!.customView =
                    navigationLayout.findViewById(R.id.activity_main_navi_community_container) as LinearLayout
            getTabAt(4)!!.customView =
                    navigationLayout.findViewById(R.id.activity_main_navi_mypage_container) as LinearLayout
        }
    }

}

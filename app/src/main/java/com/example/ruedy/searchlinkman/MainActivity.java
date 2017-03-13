package com.example.ruedy.searchlinkman;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    private IndexWord iwMain;
    private TextView tvMain;
    private Handler handler = new Handler();
    /**
     * 联系人的集合
     */
    private ArrayList<Person> persons;
    private LinkAdapter linkadapter;
    private int childCount;
    private LinearLayoutManager linearmanger;
    private int childCount1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();//初始化数据
        initview();//初始化布局
    }

    private void initview() {
        rvMain = ((RecyclerView) findViewById(R.id.rv_main));
        rvMain.setLayoutManager(linearmanger = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvMain.setAdapter(linkadapter = new LinkAdapter(this, persons, rvMain));
        iwMain = ((IndexWord) findViewById(R.id.iw_main));
        tvMain = ((TextView) findViewById(R.id.tv_main));
        setTvWord();
    }

    private void setTvWord() {
        iwMain.setIndexPressWord(new IndexWord.IndexPressWord() {
            @Override
            public void setIndexPressWord(String word) {

                getWord(word);//让recycleview跳动到此字幕的位置
                tvMain.setVisibility(View.VISIBLE);
                tvMain.setText(word);
                /**
                 * 延缓两秒钟让textview消失
                 */
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tvMain.setVisibility(View.GONE);
                    }
                }, 2000);
            }
        });
    }

    /**
     * 此方法是让recycleview滑动到指定位置，并且是让其到顶部
     * @param manager
     * @param mRecyclerView
     * @param n
     */
    public void MoveToPosition(LinearLayoutManager manager, RecyclerView mRecyclerView, int n) {
        int firstItem = manager.findFirstVisibleItemPosition();
        int lastItem = manager.findLastVisibleItemPosition();
        if (n <= firstItem) {
            mRecyclerView.scrollToPosition(n);
        } else if (n <= lastItem) {
            int top = mRecyclerView.getChildAt(n - firstItem).getTop();
            mRecyclerView.scrollBy(0, top);
        } else {
            mRecyclerView.scrollToPosition(n);
        }

    }

    private void getWord(String word) {
        Log.e("childCount1", "childCount1: " + childCount1);

        for (int i = 0; i < persons.size(); i++) {
            String substring = persons.get(i).getPinyin().substring(0, 1);

            if (substring.equals(word) && persons.size() >= i) {
                Log.e("substring", "substring: " + substring);
                View childAt = rvMain.getChildAt(i);
                MoveToPosition(linearmanger, rvMain, i);
                break;
            }
        }
    }

    private void initData() {

        persons = new ArrayList<>();
        persons.add(new Person("夏侯氏"));
        persons.add(new Person("刘备"));
        persons.add(new Person("张飞"));
        persons.add(new Person("关羽"));

        persons.add(new Person("诸葛亮"));
        persons.add(new Person("夏侯霸"));
        persons.add(new Person("孙尚香"));
        persons.add(new Person("刘禅"));

        persons.add(new Person("左慈"));
        persons.add(new Person("黄月英"));
        persons.add(new Person("甘夫人"));
        persons.add(new Person("简雍"));
        persons.add(new Person("糜烂"));

        persons.add(new Person("陈芳"));
        persons.add(new Person("陈庆之"));
        persons.add(new Person("白起"));
        persons.add(new Person("吴起"));
        persons.add(new Person("庞统"));
        persons.add(new Person("姜维"));
        persons.add(new Person("赵云"));

        persons.add(new Person("黄忠"));
        persons.add(new Person("魏延"));
        persons.add(new Person("马岱"));
        persons.add(new Person("马超"));
        persons.add(new Person("孙权"));

        persons.add(new Person("步练师"));
        persons.add(new Person("孙策"));
        persons.add(new Person("孙坚"));
        persons.add(new Person("周瑜"));

        persons.add(new Person("黄盖"));
        persons.add(new Person("程普"));


        persons.add(new Person("陆逊"));
        persons.add(new Person("吴国太"));
        persons.add(new Person("甘宁"));
        persons.add(new Person("吕蒙"));

        persons.add(new Person("大乔"));
        persons.add(new Person("小乔"));
        persons.add(new Person("二张"));
        persons.add(new Person("鲁肃"));

        persons.add(new Person("丁奉"));
        persons.add(new Person("周泰"));
        persons.add(new Person("曹操"));
        persons.add(new Person("郭嘉"));
        persons.add(new Person("荀彧"));

        persons.add(new Person("曹丕"));
        persons.add(new Person("曹植"));
        persons.add(new Person("曹冲"));
        persons.add(new Person("曹仁"));
        persons.add(new Person("曹爽"));
        persons.add(new Person("曹真"));

        persons.add(new Person("张辽"));
        persons.add(new Person("程昱"));
        persons.add(new Person("李典"));
        persons.add(new Person("甄姬"));
        persons.add(new Person("邓艾"));

        persons.add(new Person("钟会"));
        persons.add(new Person("张合"));
        persons.add(new Person("典韦"));
        persons.add(new Person("吕布"));

        persons.add(new Person("貂蝉"));
        persons.add(new Person("教主"));


        persons.add(new Person("大嘴"));
        persons.add(new Person("甲鱼"));
        persons.add(new Person("双雄"));
        persons.add(new Person("马腾"));

        persons.add(new Person("孔融"));
        persons.add(new Person("坨子"));


        persons.add(new Person("庞德"));
        persons.add(new Person("法正"));
        persons.add(new Person("张松"));
        persons.add(new Person("夏侯渊"));
        persons.add(new Person("夏侯敦"));
        persons.add(new Person("司马懿"));
        persons.add(new Person("张春华"));

        persons.add(new Person("满宠"));
        persons.add(new Person("太史慈"));
        persons.add(new Person("凌统"));
        persons.add(new Person("袁术"));
        persons.add(new Person("公孙瓒"));
        persons.add(new Person("刘协"));
        persons.add(new Person("祝融"));

        persons.add(new Person("孟获"));


        persons.add(new Person("A情债"));
        persons.add(new Person("A一起走过的日子"));
        persons.add(new Person("A真永远"));
        persons.add(new Person("A夜太黑"));

        persons.add(new Person("A挥着翅膀的女孩"));
        persons.add(new Person("A红豆"));
        persons.add(new Person("A孤星泪"));
        persons.add(new Person("A练习"));


        persons.add(new Person("A第一次"));
        persons.add(new Person("A缠绵"));
        persons.add(new Person("A给自己的情书"));
        persons.add(new Person("A樵心遇郎君，妾心连衣裳。"));

        persons.add(new Person("A你们男人造的孽，非要说什么红颜祸水"));
        persons.add(new Person("A缠绵"));
        persons.add(new Person("A给自己的情书"));
        persons.add(new Person("A樵心遇郎君，妾心连衣裳。"));

        persons.add(new Person("A好一筹将计就计。"));


        //排序
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person lhs, Person rhs) {
                return lhs.getPinyin().compareTo(rhs.getPinyin());
            }
        });

    }
}

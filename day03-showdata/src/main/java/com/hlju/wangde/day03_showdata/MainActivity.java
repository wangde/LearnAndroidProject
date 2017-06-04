package com.hlju.wangde.day03_showdata;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hlju.wangde.day03_showdata.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DbOperate dbOperate;
    private Person person;
    List<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.dataList);
        personList = new ArrayList<Person>();
        dbOperate = new DbOperate(this);
        //创建50条数据
//        for(int i = 0 ; i<50 ; i++){
//            dbOperate.insertApp("张"+i,"155555"+i,200+i);
//        }
        //查询数据库
        Cursor cursor = dbOperate.select();
        while (cursor.moveToNext()){
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            int salary = cursor.getInt(3);

            person = new Person(name,phone,salary);
            personList.add(person);
        }
//        LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
//        for (Person person: personList){
//            //创建文本框
//            TextView textView = new TextView(this);
//            textView.setText(person.toString());
//            textView.setTextSize(15);
//            //把TextView设置为线性布局的子节点
//            ll.addView(textView);
//        }

        listView.setAdapter(new MyAdapter());
    }
    class MyAdapter extends BaseAdapter{

        //获知模型层有多少数据，系统调用
        @Override
        public int getCount() {
            return personList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //系统调用，返回的View对象作为Listview条目显示在屏幕上
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //converView：系统之前缓存的条目
            Person p =personList.get(position);
//            TextView textView = new TextView(MainActivity.this);
//            textView.setText(p.toString());
//            textView.setTextSize(16);
            View view = null;
//            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
//            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//            View view = inflater.inflate(R.layout.item_listview, null);
            if(convertView == null) {
                view = View.inflate(MainActivity.this, R.layout.item_listview, null);
            }
            else {
                view = convertView;
            }



            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText(p.getName());

            TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
            tv_phone.setText(p.getPhone());

            TextView tv_salary = (TextView) view.findViewById(R.id.tv_salary);
            tv_salary.setText(p.getSalary()+"");

            return view;
        }
    }
}

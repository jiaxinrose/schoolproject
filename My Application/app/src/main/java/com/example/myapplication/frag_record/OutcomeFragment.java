package com.example.myapplication.frag_record;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.db.DBManager;
import com.example.myapplication.db.TypeBean;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public  class OutcomeFragment extends BaseRecordFragment {

    // 重写
    @Override
    public void loadDataToGV() {
        super.loadDataToGV();
        //获取数据库当中的数据源
        List<TypeBean> outlist = DBManager.getTypeList(0);
        typeList.addAll(outlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("其他");
        typeIv.setImageResource(R.mipmap.ic_qita_fs);
    }

    @Override
    public void saveAccountToDB() {

        accountBean.setKind(0);
        DBManager.insertItemToAccounttb(accountBean);
    }
}

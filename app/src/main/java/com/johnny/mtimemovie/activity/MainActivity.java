package com.johnny.mtimemovie.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.johnny.mtimemovie.R;
import com.johnny.mtimemovie.fragment.MallFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.layout_container)
    FrameLayout layoutContainer;
    @BindView(R.id.radioButton_firstPage)
    RadioButton radioButtonFirstPage;
    @BindView(R.id.radioButton_payTicket)
    RadioButton radioButtonPayTicket;
    @BindView(R.id.radioButton_shop)
    RadioButton radioButtonShop;
    @BindView(R.id.radioButton_discover)
    RadioButton radioButtonDiscover;
    @BindView(R.id.radioButton_user)
    RadioButton radioButtonUser;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    private FragmentManager manager = null;
    private FragmentTransaction fragmentTransaction = null;
    private MallFragment mallFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化数据
        initData();
    }
    private void initData() {
        manager = getSupportFragmentManager();
        //第一个RadioButton被选中
        radioButtonFirstPage.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.tab_home02,0,0);
        setTabSelected(0);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                //先让图片的颜色全部变为未被选中的状态
                changeRadioButtonDrawTopId();
                switch (checkId) {
                    case R.id.radioButton_firstPage:
                        radioButtonFirstPage.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.tab_home02,0,0);
                        setTabSelected(0);
                        break;
                    case R.id.radioButton_payTicket:
                        radioButtonPayTicket.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.tab_payticket02,0,0);
                        setTabSelected(1);
                        break;

                    case R.id.radioButton_shop:
                        radioButtonShop.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.tab_shop02,0,0);
                        setTabSelected(2);
                        break;
                    case R.id.radioButton_discover:
                        radioButtonDiscover.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.tab_discover02,0,0);
                        setTabSelected(3);
                        break;
                    case R.id.radioButton_user:
                        radioButtonUser.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.user02,0,0);
                        setTabSelected(4);
                        break;
                }
            }
        });
    }

    private void setTabSelected(int tabIndex) {
        fragmentTransaction = manager.beginTransaction();
        //先把其他的Fragment隐藏
        hideFragment(fragmentTransaction);
        switch (tabIndex) {
            case 0:

                break;
            case 1:

                break;
            case 2:
                if (mallFragment == null){
                    mallFragment = new MallFragment();
                    fragmentTransaction.add(R.id.layout_container,mallFragment);
                }else{
                    fragmentTransaction.show(mallFragment);
                }
                break;
            case 3:

                break;
        }
        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mallFragment != null){
            transaction.hide(mallFragment);
        }
    }

    public void changeRadioButtonDrawTopId(){
        radioButtonFirstPage.setCompoundDrawablesWithIntrinsicBounds(0,R.mipmap.tab_home01,0,0);
        radioButtonPayTicket.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_payticket01, 0, 0);
        radioButtonShop.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_shop01, 0, 0);
        radioButtonDiscover.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_discover01, 0, 0);
        radioButtonUser.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.user01, 0, 0);
    }

}

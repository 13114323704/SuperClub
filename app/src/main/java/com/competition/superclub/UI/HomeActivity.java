package com.competition.superclub.UI;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.competition.superclub.MainActivity;
import com.competition.superclub.R;

import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

/**
 * Created by 黄庆 on 2018/2/5.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout linearLayout_mainpager,linearLayout_circle,linearLayout_club,linearLayout_mine;
    private ImageView imageView_mainpager,imageView_cirle,imageView_club,imageView_mine;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private MainpagerFragment mainpagerFragment;
    private CircleFragment circleFragment;
    private ClubFragment clubFragment;
    private MineFragment mineFragment;

    //再按一次退出相关变量
    private static long currenttime=0;//获取当前时间
    private long touchtime=2000;//反映时间
    private long lasttime=0;//上次按键时间

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initListener();
        initMainPager();
    }

    private void initView() {
        linearLayout_mainpager=this.findViewById(R.id.linelayout_mainpager);
        linearLayout_circle=this.findViewById(R.id.linelayout_circle);
        linearLayout_club=this.findViewById(R.id.linelayout_club);
        linearLayout_mine=this.findViewById(R.id.linelayout_mine);

        imageView_mainpager=this.findViewById(R.id.imageView_mainpager);
        imageView_cirle=this.findViewById(R.id.imageView_circle);
        imageView_club=this.findViewById(R.id.imageView_club);
        imageView_mine=this.findViewById(R.id.imageView_mine);
    }

    private void initListener() {
        linearLayout_mainpager.setOnClickListener(this);
        linearLayout_circle.setOnClickListener(this);
        linearLayout_club.setOnClickListener(this);
        linearLayout_mine.setOnClickListener(this);
    }
    private void initMainPager() {
        mainpagerFragment=new MainpagerFragment();
        circleFragment=new CircleFragment();
        clubFragment=new ClubFragment();
        mineFragment=new MineFragment();

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content,mainpagerFragment,"MainpagerFragment");
        fragmentTransaction.commit();
        freshlabel(1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {
            currenttime=System.currentTimeMillis();//获取当前时间
            if(currenttime-lasttime>=touchtime) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                lasttime=currenttime;//将当前时间记录为上次按键时间
            }
            else {
                //如果小于时间间隔说明连续按键，希望退出
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        }
        //	return super.onKeyDown(keyCode, event);
        return true;//需要返回当前的按键信息，如返回super，将直接退出不会有按两次退出效果
    }

    @Override
    public void onClick(View v) {
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.linelayout_mainpager:
                fragmentTransaction.replace(R.id.content,mainpagerFragment,"MainpagerFragment");
                freshlabel(1);
                break;
            case R.id.linelayout_circle:
                fragmentTransaction.replace(R.id.content,circleFragment,"CircleFragment");
                freshlabel(2);
                break;
            case R.id.linelayout_club:
                fragmentTransaction.replace(R.id.content,clubFragment,"ClubFragment");
                freshlabel(3);
                break;
            case R.id.linelayout_mine:
                fragmentTransaction.replace(R.id.content,mineFragment,"MineFragment");
                freshlabel(4);
                break;
            default:

                break;
        }
        fragmentTransaction.commit();
    }

    private void freshlabel(int i){
        switch (i){
            case 1:
                imageView_mainpager.setImageResource(R.mipmap.icon_mainpager_pressed);
                imageView_cirle.setImageResource(R.mipmap.icon_circle_normal);
                imageView_club.setImageResource(R.mipmap.icon_club_normal);
                imageView_mine.setImageResource(R.mipmap.icon_mine_normal);
                break;
            case 2:
                imageView_mainpager.setImageResource(R.mipmap.icon_mainpager_normal);
                imageView_cirle.setImageResource(R.mipmap.icon_circle_pressed);
                imageView_club.setImageResource(R.mipmap.icon_club_normal);
                imageView_mine.setImageResource(R.mipmap.icon_mine_normal);
                break;
            case 3:
                imageView_mainpager.setImageResource(R.mipmap.icon_mainpager_normal);
                imageView_cirle.setImageResource(R.mipmap.icon_circle_normal);
                imageView_club.setImageResource(R.mipmap.icon_club_pressed);
                imageView_mine.setImageResource(R.mipmap.icon_mine_normal);
                break;
            case 4:
                imageView_mainpager.setImageResource(R.mipmap.icon_mainpager_normal);
                imageView_cirle.setImageResource(R.mipmap.icon_circle_normal);
                imageView_club.setImageResource(R.mipmap.icon_club_normal);
                imageView_mine.setImageResource(R.mipmap.icon_mine_pressed);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        /*if(requestCode==0){
            String result = data.getExtras().getString("result");
            Toast.makeText(MainActivity.this,"扫描结果为"+result,Toast.LENGTH_LONG).show();
        }*/
        //交到子fragment去处理
        this.getSupportFragmentManager().findFragmentByTag("CircleFragment").onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //适配6.0以上机型请求权限
        PermissionGen.with(HomeActivity.this)
                .addRequestCode(100)
                .permissions(
                        Manifest.permission.CAMERA
                )
                .request();
    }

    //以下三个方法用于6.0以上权限申请适配
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode = 100)
    public void doSomething(){
        //Toast.makeText(this, "相关权限已允许", Toast.LENGTH_SHORT).show();
    }

    @PermissionFail(requestCode = 100)
    public void doFailSomething(){
        //Toast.makeText(this, "相关权限已拒绝", Toast.LENGTH_SHORT).show();
    }

}

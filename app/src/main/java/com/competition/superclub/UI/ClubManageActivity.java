package com.competition.superclub.UI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.competition.superclub.CustomView.MyDialog;
import com.competition.superclub.R;
import com.competition.superclub.utils.ImageCacheUtil;
import com.competition.superclub.utils.StatusHeightUtils;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 黄庆 on 2018/2/25.
 */

public class ClubManageActivity extends AppCompatActivity {

    private ImageView image_back;
    private TextView textView_title;

    private ImageView imageView_qrcode;
    private MyDialog myDialog;

    private RelativeLayout rela_info, rela_member, rela_honor, rela_track, rela_fellowship;

    private FloatingActionsMenu floatingActionsMenu;
    private FloatingActionButton fb_member,fb_honor,fb_track,fb_other;

    private int screenHeight;
    private View view_popupwindow;
    private PopupWindow popupWindow_publish;
    private ImageView imageView_close,popup_image_select,popup_image_content;
    private Button popup_btn_publish;
    private EditText editText_publish_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_manage);

        initData();
        initView();
        initListener();
    }

    private void initData() {
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        screenHeight = size.y;
    }

    private void initView() {
        image_back = findViewById(R.id.image_back);
        textView_title = findViewById(R.id.textview_title);
        imageView_qrcode = findViewById(R.id.imageview_club_qrcode);
        textView_title.setText("社团管理");

        myDialog = new MyDialog(ClubManageActivity.this, R.style.dialogTheme, R.layout.dialog_qrcode);

        rela_info = findViewById(R.id.info_manager_layout);
        rela_member = findViewById(R.id.member_manager_layout);
        rela_honor = findViewById(R.id.honor_manager_layout);
        rela_track = findViewById(R.id.track_manager_layout);
        rela_fellowship = findViewById(R.id.fellowship_manage_layout);

        floatingActionsMenu=findViewById(R.id.multiple_actions_down);
        fb_member=findViewById(R.id.float_button_member);
        fb_honor=findViewById(R.id.float_button_honor);
        fb_track=findViewById(R.id.float_button_track);
        fb_other=findViewById(R.id.float_button_other);

        view_popupwindow = LayoutInflater.from(ClubManageActivity.this).inflate(R.layout.popupwindow_publish_info, null);
        popupWindow_publish=new PopupWindow(view_popupwindow, WindowManager.LayoutParams.MATCH_PARENT, screenHeight - StatusHeightUtils.getStatusBarHeight(ClubManageActivity.this));
        popupWindow_publish.setAnimationStyle(R.style.popup_enter_style);
        popupWindow_publish.setFocusable(true);

        editText_publish_content=(EditText)view_popupwindow.findViewById(R.id.edittext_content);
        imageView_close=view_popupwindow.findViewById(R.id.image_close);
        popup_btn_publish=view_popupwindow.findViewById(R.id.popup_btn_publish);
        popup_image_content=view_popupwindow.findViewById(R.id.image_content);
        popup_image_select=view_popupwindow.findViewById(R.id.image_select);
    }

    private void initListener() {
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final Window window = myDialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.fade_in_out);
        imageView_qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
                WindowManager.LayoutParams params = window.getAttributes();
                Point size = new Point();
                getWindowManager().getDefaultDisplay().getSize(size);
                params.width = (int) ((size.x) * 0.6);
                params.dimAmount = 0.4f;
                window.setAttributes(params);
            }
        });

        rela_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubManageActivity.this, InfoModifyActivity.class);
                startActivity(intent);
            }
        });
        rela_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubManageActivity.this, MemberManageActivity.class);
                startActivity(intent);
            }
        });
        rela_honor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubManageActivity.this, ClubHonorActivity.class);
                startActivity(intent);
            }
        });
        rela_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubManageActivity.this, ClubTrackActivity.class);
                startActivity(intent);
            }
        });
        rela_fellowship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClubManageActivity.this, ClubFellowshipActivity.class);
                startActivity(intent);
            }
        });
        fb_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingActionsMenu.toggle();
                popupWindow_publish.showAtLocation(v, Gravity.CENTER,0,0);
            }
        });
        fb_honor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingActionsMenu.toggle();
                popupWindow_publish.showAtLocation(v, Gravity.CENTER,0,0);
            }
        });
        fb_track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingActionsMenu.toggle();
                popupWindow_publish.showAtLocation(v, Gravity.CENTER,0,0);
            }
        });
        fb_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingActionsMenu.toggle();
                popupWindow_publish.showAtLocation(v, Gravity.CENTER,0,0);
            }
        });
        imageView_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow_publish.dismiss();
            }
        });
        popup_btn_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editText_publish_content.getText().toString())){
                    Toast.makeText(ClubManageActivity.this,"请输入要发表的内容",Toast.LENGTH_LONG).show();
                }else{
                    popupWindow_publish.dismiss();
                    Toast.makeText(ClubManageActivity.this,"发布成功",Toast.LENGTH_LONG).show();
                }
            }
        });
        popup_image_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra("return-data", true);
                intent.putExtra("crop", "circle");
                // 使用Intent.ACTION_GET_CONTENT这个Action
                intent.setAction(Intent.ACTION_GET_CONTENT);
                // 取得相片后返回本画面
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            Bitmap bitmap = ImageCacheUtil.getResizedBitmap(null, null,
                    ClubManageActivity.this, data.getData(), 100, true);
            BitmapDrawable drawable = new BitmapDrawable(null, bitmap);
            popup_image_content.setImageDrawable(drawable);
        }
    }
}

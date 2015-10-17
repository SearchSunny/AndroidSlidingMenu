package com.example.androidslidingmenuuse;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.androidslidingmenuuse.tool.BaseTools;
import com.example.androidslidingmenuuse.view.DrawerView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
/**
 * slidingMenu的使用
 * @author miaowei
 *
 */
public class MainActivity extends FragmentActivity {
	
	protected SlidingMenu side_drawer;
	/**head 头部 的左侧菜单 按钮 **/
	ImageView top_head;
	/** head 头部 的右侧菜单 按钮*/
	ImageView top_more;
	/** 屏幕宽度 */
	private int mScreenWidth = 0;
	/** Item宽度 */
	private int mItemWidth = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mScreenWidth = BaseTools.getWindowsWidth(this);
		mItemWidth = mScreenWidth / 7;// 一个Item宽度为屏幕的1/7
		initSlidingMenu();
		
		initView();
	}

	
	protected void initView(){
		
		top_head = (ImageView) findViewById(R.id.top_head);
		top_more = (ImageView)findViewById(R.id.top_more);
		top_head.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(side_drawer.isMenuShowing()){
					side_drawer.showContent();
				}else{
					side_drawer.showMenu();
				}
			}
		});
		top_more.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(side_drawer.isSecondaryMenuShowing()){
					side_drawer.showContent();
				}else{
					side_drawer.showSecondaryMenu();
				}
			}
		});
	}
	/**
	 * 初始化slidingMenu
	 */
	protected void initSlidingMenu() {
		
		side_drawer = new DrawerView(this).initSlidingMenu();
	}
}

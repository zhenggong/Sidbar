package com.example.sidbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class PeopleListFragment extends Fragment {
	
	private ListView mPeopleListView;
    //ユーザー情報アレイ
    private List<People> peoples = new ArrayList<People>();
    private Callback mCallback;
	public PeopleListFragment() {
	  }

	  public static PeopleListFragment newInstance() {
	    return new PeopleListFragment();
	  }

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	  }
	  
	  @Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		  
		View view = inflater.inflate(R.layout.fragment_people_list, container, false);
	    mPeopleListView = (ListView) view.findViewById(R.id.hotel_list_view);
	    //Data　クラスを作る Dataクラスのデータをアレイに入れる
        for(Data.ANDROID_CN_PEOPLE data : Data.ANDROID_CN_PEOPLE.values()){
            peoples.add(data.getPeople());
        }
        //peopleをシャッフルする
        Collections.shuffle(peoples);
        //シャッフル後のpeopleからcopyを作る
        ArrayList<People> copy = new ArrayList<People>(peoples);
        //copyをpeoplesに戻す
        peoples.addAll(copy);   
        
        mPeopleListView.setAdapter(new DemoAdaptar(getActivity(), R.id.item, peoples));
        
	    return view;
	  }
	  
	  public void setCallback(Callback callback) {
		    this.mCallback = callback;
		  }
	  
	  public interface Callback {
		    public void onShowComplete();
		  }
	
}

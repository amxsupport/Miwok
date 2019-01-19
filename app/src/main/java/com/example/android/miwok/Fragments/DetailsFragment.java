package com.example.android.miwok.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.android.miwok.R;
import com.example.android.miwok.Word;
import com.example.android.miwok.WordAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private WordAdapter itemAdapter;
    public static final int TYPE_NUMBERS = 0;
    public static final int TYPE_PHRASES = 1;
    public static final int TYPE_COLORS = 2;
    public static final int TYPE_FAMILY = 3;

    private static final String ARG_CATEGORY_TYPE = "category_type";


    // TODO: Rename and change types of parameters
    private int categoryType;


    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param categorytype Parameter 1.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(int categorytype) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CATEGORY_TYPE,categorytype);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            categoryType = getArguments().getInt(ARG_CATEGORY_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.word_list, container, false);

        if(categoryType == TYPE_NUMBERS){

            final ArrayList<Word> wordss = new ArrayList<Word>();
            wordss.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
            wordss.add(new Word("Tow","otiiko",R.drawable.number_two,R.raw.number_two));
            wordss.add(new Word("Three","tolookosu",R.drawable.number_three,R.raw.number_three));
            wordss.add(new Word("Four","oyyisa",R.drawable.number_four,R.raw.number_four));
            wordss.add(new Word("Five","massokka",R.drawable.number_five,R.raw.number_five));
            wordss.add(new Word("Six","temmokka",R.drawable.number_six,R.raw.number_six));
            wordss.add(new Word("Seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
            wordss.add(new Word("Eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
            wordss.add(new Word("nine","wo’e",R.drawable.number_nine,R.raw.number_nine));
            wordss.add(new Word("Ten","na’aacha",R.drawable.number_ten,R.raw.number_ten));

            Object getSas = getActivity().getSystemService(Context.AUDIO_SERVICE);
            itemAdapter = new WordAdapter(getActivity(), wordss, R.color.category_numbers,getSas);

        }else if(categoryType == TYPE_FAMILY){
            ArrayList<Word> family = new ArrayList<Word>();
            family.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
            family.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
            family.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
            family.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
            family.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
            family.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
            family.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
            family.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
            family.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
            family.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

            itemAdapter = new WordAdapter(getActivity(), family,R.color.category_family,getActivity().getSystemService(Context.AUDIO_SERVICE));

        }else if(categoryType == TYPE_COLORS){
            ArrayList<Word> color = new ArrayList<Word>();
            color.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
            color.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
            color.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
            color.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
            color.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
            color.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
            color.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
            color.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

            itemAdapter = new WordAdapter(getActivity(), color,R.color.category_colors,getActivity().getSystemService(Context.AUDIO_SERVICE));

        }else {
            ArrayList<Word> phrases = new ArrayList<Word>();
            phrases.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
            phrases.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
            phrases.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
            phrases.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
            phrases.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
            phrases.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
            phrases.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
            phrases.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
            phrases.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
            phrases.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

            itemAdapter = new WordAdapter(getActivity(), phrases,R.color.category_phrases,getActivity().getSystemService(Context.AUDIO_SERVICE));

        }

        ListView listView = (ListView) v.findViewById(R.id.list);
        listView.setAdapter(itemAdapter);

        return v;
    }

    @Override
    public void onStop() {
        super.onStop();
        itemAdapter.releaseMediaPlayer();
    }

}

package com.example.android.miwok;
/**
 * Created by aziz on 11/9/18.
 */
import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static com.example.android.miwok.R.raw.color_black;

public class WordAdapter extends ArrayAdapter<com.example.android.miwok.Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int backGround;
    private MediaPlayer mp;

    private AudioManager mAudioManager;
    private Object getSAS;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListner;


    public void releaseMediaPlayer(){
        if (mp != null){
            mp.release();
            mp = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListner);
//            Toast toat = Toast.makeText(getContext(),"it's done", Toast.LENGTH_SHORT);
//            toat.show();
        }
    }

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param word    A List of AndroidFlavor objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<com.example.android.miwok.Word> word, int background,Object getsas ) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, word);
        backGround = background;
        getSAS = getsas;

        mAudioManager = (AudioManager) getSAS;

        mOnAudioFocusChangeListner = new AudioManager.OnAudioFocusChangeListener() {
            public void onAudioFocusChange(int focusChange) {
                if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                    mp.pause();
                    mp.seekTo(0);
                } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    // Resume playback
                    mp.start();
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {

                    releaseMediaPlayer();
                }
            }};

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list

        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.version_number);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getDefulTranslation());


        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.version_miwok);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getDefultNumber());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        if (currentWord.imageState() == true) {
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        }else {
            ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setVisibility(View.GONE);
        }


        View frameLinearLayout = listItemView.findViewById(R.id.frame_list_word);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        int Ccolor = ContextCompat.getColor(getContext(),backGround);
        frameLinearLayout.setBackgroundColor(Ccolor);


        View listWordLinearlayout = listItemView.findViewById(R.id.list_word_linearlayout);
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        listWordLinearlayout.setBackgroundResource(outValue.resourceId);


        listWordLinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListner,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                mp = MediaPlayer.create(getContext(),currentWord.getAudioFile());
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                     releaseMediaPlayer();
                    }
                });
            }}

        });

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
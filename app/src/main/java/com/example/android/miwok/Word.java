package com.example.android.miwok;
/**
 * Created by aziz on 11/9/18.
 */

public class Word {

    private String mDefultNumber;
    private String mDefultTranslation;
    private int mImageResourceId;
    private int mAudioFile;

    public Word(String DefultNumber, String DefultTranslation, int imageId,int audiofile)
    {
        mDefultNumber = DefultNumber;
        mDefultTranslation = DefultTranslation;
        mImageResourceId = imageId;
        mAudioFile = audiofile;
    }

    public Word(String DefultNumber, String DefultTranslation, int audiofile)
    {
        mDefultNumber = DefultNumber;
        mDefultTranslation = DefultTranslation;
        mAudioFile = audiofile;
    }

    public String getDefultNumber() {
        return mDefultNumber;
    }

    public String getDefulTranslation(){
        return mDefultTranslation;
    }

    public int getImageResourceId(){return mImageResourceId;}

    public int getAudioFile(){return mAudioFile;}

    public boolean imageState(){
        if (mImageResourceId == 0){
            return false;
        }else {
            return true;
        }
        
    }

}

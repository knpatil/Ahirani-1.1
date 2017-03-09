package com.projects.kamlakarpatil.ahirani;

/**
 * Created by kamlakar.patil on 2/26/17.
 */

public class Word {
    private String mDefaultTranslation;
    private String mAhiraniTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId = NO_AUDIO_PROVIDED;
    private static final int NO_AUDIO_PROVIDED = -1;

    public Word(String mAhiraniTranslation, String mDefaultTranslation) {
        this.mAhiraniTranslation = mAhiraniTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
    }

    public Word(String mDefaultTranslation, String mAhiraniTranslation, int mImageResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mAhiraniTranslation = mAhiraniTranslation;
        this.mImageResourceId = mImageResourceId;
    }

    public Word(String mDefaultTranslation, String mAhiraniTranslation, int mImageResourceId, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mAhiraniTranslation = mAhiraniTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmAhiraniTranslation() {
        return mAhiraniTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public boolean hasAudio() {
        return mAudioResourceId != NO_AUDIO_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mAhiraniTranslation='" + mAhiraniTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}

package com.example.deep_link_test_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.net.URISyntaxException;
import java.util.Arrays;

public class testActivity {
    private static Intent mDeepLinkIntent;

    static {
        try {
            mDeepLinkIntent = Intent.parseUri("what", Intent.URI_INTENT_SCHEME);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String[] strArr = null;
        Bundle extras;

        Intent intent = mDeepLinkIntent;
        Log.d("launch", intent.toUri(0));
        if (intent != null && (extras = intent.getExtras()) != null) {
            strArr = extras.getStringArray("args");
            Log.d("launch", "Forwarding intent extra arguments to the engine");

        }
    }
}
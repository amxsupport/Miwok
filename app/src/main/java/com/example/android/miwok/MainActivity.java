/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.Fragments.MainFragment;

import static android.R.attr.duration;
import static com.example.android.miwok.R.id.numbers;

public class MainActivity extends AppCompatActivity {
    private WordAdapter itemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        FragmentManager fM = getSupportFragmentManager();
        MainFragment mainfragment = (MainFragment) fM.findFragmentById(R.id.fragment_container);
        if (mainfragment == null){
            mainfragment = new MainFragment();
            FragmentTransaction transact = fM.beginTransaction();
            transact.add(R.id.fragment_container,mainfragment);
            transact.commit();
        }
    }
}

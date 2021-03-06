package co.adrianblan.noraoke;

/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

public class SongLibraryFragment extends Fragment {

    public static SongLibraryFragment newInstance() {
        SongLibraryFragment f = new SongLibraryFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }

    @Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_song_library,container,false);

        ListView listView = (ListView) rootView.findViewById(R.id.library_song_list);
        listView.setAdapter(new SongAdapter(getActivity()));

        //We add a listener to each item in the list
        //When pressed, opens info page to backstreet boys
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), SongInfoActivity.class);
                getActivity().startActivity(intent);

            }
        });

        final Context context = this.getActivity();
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.library_fab);
        fab.attachToListView(listView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(context)
                        .setTitle("Sort songs")
                        .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
                        .setNegativeButton("Cancel", null)
                        .setPositiveButton("Sort", null)
                        .show();
            }
        });

        ViewCompat.setElevation(rootView, 50);
        return rootView;
    }
}

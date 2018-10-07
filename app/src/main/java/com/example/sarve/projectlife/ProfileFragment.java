package com.example.sarve.projectlife;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;
import static com.google.android.gms.flags.impl.SharedPreferencesFactory.getSharedPreferences;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {



    @BindView(R.id.profile_name)
    TextView profileName;

    @BindView(R.id.profile_email)
    TextView profileEmail;

    @BindView(R.id.profile_number)
    TextView profileNumber;

    @BindView(R.id.contact_1_name)
    TextView contact1name;

    @BindView(R.id.contact_1_number)
    TextView contact1no;

    @BindView(R.id.contact_2_name)
    TextView contact2name;

    @BindView(R.id.contact_2_number)
    TextView contact2no;


    public ProfileFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);

        final SharedPreferences sharedPreferences = getActivity().getSharedPreferences("your_preferences", MODE_PRIVATE);
        String emailid = sharedPreferences.getString("mail","temp");

        SQLiteDatabase db=getActivity().openOrCreateDatabase("signup", MODE_PRIVATE,null);
        db = getActivity().openOrCreateDatabase("signup", MODE_PRIVATE, null);


        Cursor c = db.rawQuery("select name from details where email='"+emailid+"'  ", null);
        String p = null;
        if (c.moveToFirst()){

            do {
                p =c.getString(0);
            } while (c.moveToNext());
        }

        profileName.setText(p);
        profileEmail.setText(emailid);

        c = db.rawQuery("select cno from details where email='" + emailid + "'  ", null);
        p = null;
        if (c.moveToFirst()){

            do {
                p =c.getString(0);
            } while (c.moveToNext());
        }
        profileNumber.setText(p);

        c = db.rawQuery("select ec1 from details where email='" + emailid + "'  ", null);
        p = null;
        if (c.moveToFirst()){

            do {
                p =c.getString(0);
            } while (c.moveToNext());
        }
        contact1name.setText(p);

        c = db.rawQuery("select ec2 from details where email='" + emailid + "'  ", null);
        p = null;
        if (c.moveToFirst()){

            do {
                p =c.getString(0);
            } while (c.moveToNext());
        }
        contact2name.setText(p);

        c = db.rawQuery("select en1 from details where email='" + emailid + "'  ", null);
        p = null;
        if (c.moveToFirst()){

            do {
                p =c.getString(0);
            } while (c.moveToNext());
        }
        contact1no.setText(p);

        c = db.rawQuery("select en2 from details where email='" + emailid + "'  ", null);
        p = null;
        if (c.moveToFirst()){

            do {
                p =c.getString(0);
            } while (c.moveToNext());
        }
        contact2no.setText(p);
        return view;
    }

    @OnClick({R.id.contact_1_name, R.id.contact_1_number})
    public void callContact1() {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(contact1no.getText().toString())));
    }

    @OnClick({R.id.contact_2_name, R.id.contact_2_number})
    public void callContact2() {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(contact2no.getText().toString())));
    }

}

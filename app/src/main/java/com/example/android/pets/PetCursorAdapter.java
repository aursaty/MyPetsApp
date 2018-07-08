package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

public class PetCursorAdapter extends CursorAdapter {
    PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context)
                .inflate(R.layout.pet_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName = view.findViewById(R.id.name);
        TextView tvBreed = view.findViewById(R.id.breed);

        String name =
                cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME));
        String breed =
                cursor.getString(cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED));

        tvName.setText(name);
        tvBreed.setText(breed);
    }
}

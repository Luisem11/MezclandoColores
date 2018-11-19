package com.edu.udea.mezclandocolores;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.udea.mezclandocolores.DB.DbHelper;
import com.edu.udea.mezclandocolores.DB.StatusContract;

public class MainActivity extends AppCompatActivity {


    SharedPreferences pref;
    SharedPreferences.Editor edit;
    TextView name_color1, name_color2, resultTextV;
    CardView card1, card2, card3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_color1 = findViewById(R.id.colorname1);
        card1 = findViewById(R.id.card_1);
        name_color2 = findViewById(R.id.colorname2);
        card2 = findViewById(R.id.card_2);
        resultTextV = findViewById(R.id.result);
        card3 = findViewById(R.id.card_3);
        pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        edit = pref.edit();
        edit.putInt("color1", 0);
        edit.putInt("color2", 0);
        edit.putInt("result", 0);
        edit.commit();
        refresh();

    }


    public void showDialogColor1(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_color1);
        CardView card_primary1 = dialog.findViewById(R.id.card_primary1);
        CardView card_primary2 = dialog.findViewById(R.id.card_primary2);
        CardView card_primary3 = dialog.findViewById(R.id.card_primary3);
        Button save = dialog.findViewById(R.id.action_color1);
        final CardView card1_border = dialog.findViewById(R.id.card_primary1_);
        final CardView card2_border = dialog.findViewById(R.id.card_primary2_);
        final CardView card3_border = dialog.findViewById(R.id.card_primary3_);
        ImageView close = dialog.findViewById(R.id.close_dialog_steps);
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = new DbHelper(this).getReadableDatabase();

        Cursor cursor = db.query(StatusContract.TABLE_PRIMARY,
                null,
                null,
                null,
                null,
                null,
                null);

        cursor.moveToFirst();
        card_primary1.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        cursor.moveToNext();
        card_primary2.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        cursor.moveToNext();
        card_primary3.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        card_primary1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card1_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.BLACK);
                card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                card3_border.setCardBackgroundColor(Color.TRANSPARENT);
            }
        });
        card_primary2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card2_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                card2_border.setCardBackgroundColor(Color.BLACK);
                card3_border.setCardBackgroundColor(Color.TRANSPARENT);
            }
        });
        card_primary3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (card3_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card3_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                card3_border.setCardBackgroundColor(Color.BLACK);

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (card1_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK ||
                        card2_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK ||
                        card3_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    int code;
                    if (card1_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                        code = 1;
                    } else if (card2_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                        code = 2;
                    } else {
                        code = 3;
                    }


                    edit.putInt("color1", code);
                    edit.commit();
                    refresh();

                    dialog.dismiss();

                } else {
                    Toast.makeText(view.getContext(), "Debes seleccionar un color!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    public void showDialogColor2(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_color2);
        CardView card_primary1 = dialog.findViewById(R.id.card_primary1);
        CardView card_primary2 = dialog.findViewById(R.id.card_primary2);
        CardView card_primary3 = dialog.findViewById(R.id.card_primary3);
        CardView card_primary4 = dialog.findViewById(R.id.card_primary4);
        CardView card_primary5 = dialog.findViewById(R.id.card_primary5);
        CardView card_primary6 = dialog.findViewById(R.id.card_primary6);
        Button save = dialog.findViewById(R.id.action_color1);
        final CardView card1_border = dialog.findViewById(R.id.card_primary1_);
        final CardView card2_border = dialog.findViewById(R.id.card_primary2_);
        final CardView card3_border = dialog.findViewById(R.id.card_primary3_);
        final CardView card4_border = dialog.findViewById(R.id.card_primary4_);
        final CardView card5_border = dialog.findViewById(R.id.card_primary5_);
        final CardView card6_border = dialog.findViewById(R.id.card_primary6_);
        ImageView close = dialog.findViewById(R.id.close_dialog_steps);
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = new DbHelper(this).getReadableDatabase();

        Cursor cursor = db.query(StatusContract.TABLE_PRIMARY,
                null,
                null,
                null,
                null,
                null,
                null);

        cursor.moveToFirst();
        card_primary1.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        cursor.moveToNext();
        card_primary2.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        cursor.moveToNext();
        card_primary3.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        cursor.moveToNext();
        card_primary4.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        cursor.moveToNext();
        card_primary5.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        cursor.moveToNext();
        card_primary6.setCardBackgroundColor(Color.parseColor("#" +
                cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));


        card_primary1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card1_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.BLACK);
                card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                card3_border.setCardBackgroundColor(Color.TRANSPARENT);
                card4_border.setCardBackgroundColor(Color.TRANSPARENT);
                card5_border.setCardBackgroundColor(Color.TRANSPARENT);
                card6_border.setCardBackgroundColor(Color.TRANSPARENT);
            }
        });
        card_primary2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card2_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                card2_border.setCardBackgroundColor(Color.BLACK);
                card3_border.setCardBackgroundColor(Color.TRANSPARENT);
                card4_border.setCardBackgroundColor(Color.TRANSPARENT);
                card5_border.setCardBackgroundColor(Color.TRANSPARENT);
                card6_border.setCardBackgroundColor(Color.TRANSPARENT);
            }
        });
        card_primary3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (card3_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card3_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                card3_border.setCardBackgroundColor(Color.BLACK);
                card4_border.setCardBackgroundColor(Color.TRANSPARENT);
                card5_border.setCardBackgroundColor(Color.TRANSPARENT);
                card6_border.setCardBackgroundColor(Color.TRANSPARENT);

            }
        });
        card_primary4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card4_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card4_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                card3_border.setCardBackgroundColor(Color.TRANSPARENT);
                card4_border.setCardBackgroundColor(Color.BLACK);
                card5_border.setCardBackgroundColor(Color.TRANSPARENT);
                card6_border.setCardBackgroundColor(Color.TRANSPARENT);
            }
        });
        card_primary5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card5_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card5_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                card3_border.setCardBackgroundColor(Color.TRANSPARENT);
                card4_border.setCardBackgroundColor(Color.TRANSPARENT);
                card5_border.setCardBackgroundColor(Color.BLACK);
                card6_border.setCardBackgroundColor(Color.TRANSPARENT);
            }
        });
        card_primary6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card6_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    card6_border.setCardBackgroundColor(Color.TRANSPARENT);
                    return;
                }
                card1_border.setCardBackgroundColor(Color.TRANSPARENT);
                card2_border.setCardBackgroundColor(Color.TRANSPARENT);
                card3_border.setCardBackgroundColor(Color.TRANSPARENT);
                card4_border.setCardBackgroundColor(Color.TRANSPARENT);
                card5_border.setCardBackgroundColor(Color.TRANSPARENT);
                card6_border.setCardBackgroundColor(Color.BLACK);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int code = 0;
                if (card1_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    code = 1;
                } else if (card2_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    code = 2;
                } else if (card3_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    code = 3;
                } else if (card4_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    code = 4;
                } else if (card5_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    code = 5;
                } else if (card6_border.getCardBackgroundColor().getDefaultColor() == Color.BLACK) {
                    code = 6;
                } else {
                    Toast.makeText(view.getContext(), "Debes seleccionar un color!", Toast.LENGTH_SHORT).show();
                }
                DbHelper dbHelper = new DbHelper(view.getContext());
                SQLiteDatabase db = new DbHelper(view.getContext()).getReadableDatabase();
                int code2 = pref.getInt("color1", 0);
                Cursor cursor = db.query(StatusContract.TABLE_SECONDARY,
                        null,
                        StatusContract.Column_Secondary_Color.COLOR1 + " = ? AND " +
                                StatusContract.Column_Secondary_Color.COLOR2 + " = ?",
                        new String[]{"" + code2, "" + code},
                        null,
                        null,
                        null);
                if (cursor.moveToFirst()){
                    int result = cursor.getInt(cursor.getColumnIndex(StatusContract.Column_Secondary_Color.RESULT));
                    edit.putInt("color2", code);
                    edit.putInt("result", result);
                    edit.commit();

                }

                refresh();

                dialog.dismiss();


            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    public void refresh() {
        int code = pref.getInt("color1", 0);
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = new DbHelper(this).getReadableDatabase();
        Cursor cursor;
        if (code == 0) {
            name_color1.setText("");
            card1.setCardBackgroundColor(Color.GRAY);
            name_color2.setText("");
            card2.setCardBackgroundColor(Color.GRAY);
            return;
        }else {

            cursor = db.query(StatusContract.TABLE_PRIMARY,
                    null,
                    StatusContract.Column_Primary_Color.ID + " = ?",
                    new String[]{"" + code},
                    null,
                    null,
                    null);

            cursor.moveToFirst();
            name_color1.setText(cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.NAME)));
            card1.setCardBackgroundColor(Color.parseColor("#" +
                    cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        }

        int code2 = pref.getInt("color2", 0);
        if (code2 == 0) {
            name_color2.setText("");
            card2.setCardBackgroundColor(Color.GRAY);
            return;
        }else {

            cursor = db.query(StatusContract.TABLE_PRIMARY,
                    null,
                    StatusContract.Column_Primary_Color.ID + " = ?",
                    new String[]{"" + code2},
                    null,
                    null,
                    null);

            cursor.moveToFirst();
            name_color2.setText(cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.NAME)));
            card2.setCardBackgroundColor(Color.parseColor("#" +
                    cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        }

        int result = pref.getInt("result", 0);
        if (result == 0) {
            resultTextV.setText("Resultado:    ");
            card3.setCardBackgroundColor(Color.GRAY);
            return;
        }else{
            cursor = db.query(StatusContract.TABLE_PRIMARY,
                    null,
                    StatusContract.Column_Primary_Color.ID + " = ?",
                    new String[]{"" + result},
                    null,
                    null,
                    null);

            cursor.moveToFirst();
            resultTextV.setText("Resultado: " +cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.NAME)));
            card3.setCardBackgroundColor(Color.parseColor("#" +
                    cursor.getString(cursor.getColumnIndex(StatusContract.Column_Primary_Color.CODE))));
        }



    }
}

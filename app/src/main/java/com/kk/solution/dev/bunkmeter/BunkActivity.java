package com.kk.solution.dev.bunkmeter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BunkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunk);

        SharedPreferences loadRecord = getSharedPreferences(save, 0);
        attend = loadRecord.getInt("attended", 0);
        display(attend);
        bunk = loadRecord.getInt("bunked", 0);
        displayyy(bunk);
        free = loadRecord.getInt("free", 0);
        displayBunk(free);
        present_percent = loadRecord.getInt("present percent", 0);
        display_present_percent(present_percent);
        sub1 = loadRecord.getString("subject", "Subject");
        subject(sub1);
        percent = loadRecord.getInt("percent", 75);
        subjectpercent(percent);
        attend2 = loadRecord.getInt("attended2", 0);
        display2(attend2);
        bunk2 = loadRecord.getInt("bunked2", 0);
        displayyy2(bunk2);
        free2 = loadRecord.getInt("free2", 0);
        displayBunk2(free2);
        present_percent2 = loadRecord.getInt("present percent2", 0);
        display_present_percent2(present_percent2);
        sub2 = loadRecord.getString("subject2", "Subject");
        subject2(sub2);
        percent2 = loadRecord.getInt("percent2", 75);
        subjectpercent2(percent2);
        attend3 = loadRecord.getInt("attended3", 0);
        display3(attend3);
        bunk3 = loadRecord.getInt("bunked3", 0);
        displayyy3(bunk3);
        free3 = loadRecord.getInt("free3", 0);
        displayBunk3(free3);
        present_percent3 = loadRecord.getInt("present percent3", 0);
        display_present_percent3(present_percent3);
        sub3 = loadRecord.getString("subject3", "Subject");
        subject3(sub3);
        percent3 = loadRecord.getInt("percent3", 75);
        subjectpercent3(percent3);
        attend4 = loadRecord.getInt("attended4", 0);
        display4(attend4);
        bunk4 = loadRecord.getInt("bunked4", 0);
        displayyy4(bunk4);
        free4 = loadRecord.getInt("free4", 0);
        displayBunk4(free4);
        present_percent4 = loadRecord.getInt("present percent4", 0);
        display_present_percent4(present_percent4);
        sub4 = loadRecord.getString("subject4", "Subject");
        subject4(sub4);
        percent4 = loadRecord.getInt("percent4", 75);
        subjectpercent4(percent4);
        attend5 = loadRecord.getInt("attended5", 0);
        display5(attend5);
        bunk5 = loadRecord.getInt("bunked5", 0);
        displayyy5(bunk5);
        free5 = loadRecord.getInt("free5", 0);
        displayBunk5(free5);
        present_percent5 = loadRecord.getInt("present percent5", 0);
        display_present_percent5(present_percent5);
        sub5 = loadRecord.getString("subject5", "Subject");
        subject5(sub5);
        percent5 = loadRecord.getInt("percent5", 75);
        subjectpercent5(percent5);
        attend6 = loadRecord.getInt("attended6", 0);
        display6(attend6);
        bunk6 = loadRecord.getInt("bunked6", 0);
        displayyy6(bunk6);
        free6 = loadRecord.getInt("free6", 0);
        displayBunk6(free6);
        present_percent6 = loadRecord.getInt("present percent6", 0);
        display_present_percent6(present_percent6);
        sub6 = loadRecord.getString("subject6", "Subject");
        subject6(sub6);
        percent6 = loadRecord.getInt("percent6", 75);
        subjectpercent6(percent6);
    }
    String save = "Record";
    int percent;
    int free;
    int attend;
    int bunk;
    int present_percent;
    String sub1;

    public void increment1(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended);
        attend = Integer.parseInt(editText_attend.getText().toString());
        attend = attend + 1;
        display(attend);
    }

    public void decrement1(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended);
        attend = Integer.parseInt(editText_attend.getText().toString());
        if (attend == 0) {
            return;
        }
        attend = attend - 1;
        display(attend);
    }

    private void display(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.attended);
        quantityTextView.setText("" + num);
    }


    public void increment2(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked);
        bunk = Integer.parseInt(editText_bunked.getText().toString());
        bunk = bunk + 1;
        displayyy(bunk);
    }

    public void decrement2(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked);
        bunk = Integer.parseInt(editText_bunked.getText().toString());
        if (bunk == 0) {
            return;
        }
        bunk = bunk - 1;
        displayyy(bunk);
    }

    private void displayyy(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.bunked);
        quantityTextView.setText("" + num);
    }

    private int calculateBunks() {
        if (attend == 0 && bunk >= 0) {
            return free = 0;
        }
        free = ((attend * 100) / percent) - attend - bunk;
        if (free <= 0) {
            free = 0;
        }
        return free;

    }

    private void displayBunk(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.free_bunks);
        quantityTextView.setText("" + number);
    }

    private int present_percent() {
        if (attend == 0 && bunk >= 0) {
            return present_percent = 0;
        }
        present_percent = (attend * 100) / (attend + bunk);
        return present_percent;
    }

    private void display_present_percent(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.present_percent);
        quantityTextView.setText("" + number);
    }

    public void working(View view) {
        sub1 = displaySubject1();
        subject(sub1);
        EditText editText_attend = (EditText) findViewById(R.id.attended);
        attend = Integer.parseInt(editText_attend.getText().toString());
        EditText editText_bunked = (EditText) findViewById(R.id.bunked);
        bunk = Integer.parseInt(editText_bunked.getText().toString());
        percent = 75;
        percent = displaypercent();
        subjectpercent(percent);
        EditText editText_percent = (EditText) findViewById(R.id.percentage);
        percent = Integer.parseInt(editText_percent.getText().toString());
        if (percent == 0 || percent > 100) {
            Toast.makeText(this, "Invalid percentage entered", Toast.LENGTH_SHORT).show();
            return;
        }
        displayBunk(calculateBunks());
        display_present_percent(present_percent());
        SharedPreferences saveRecord = getSharedPreferences(save, MODE_PRIVATE);
        SharedPreferences.Editor editor = saveRecord.edit();
        editor.putInt("attended", attend).putInt("bunked", bunk).putInt("free", free).putInt("present percent", present_percent).putString("subject", sub1).putInt("percent", percent);
        editor.apply();
    }

    private String displaySubject1() {
        EditText editText = (EditText) findViewById(R.id.sub1);
        String sub = editText.getText().toString();
        return sub;
    }

    private void subject(String number) {
        TextView quantityTextView = (TextView) findViewById(R.id.sub1);
        quantityTextView.setText("" + number);
    }
    private int displaypercent() {
        EditText editText = (EditText) findViewById(R.id.percentage);
        int sub = Integer.parseInt(editText.getText().toString());
        return sub;
    }

    private void subjectpercent(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.percentage);
        quantityTextView.setText("" + number);
    }
    int percent2;
    int free2;
    int attend2;
    int bunk2;
    int present_percent2;
    String sub2;
    public void increment3(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended2);
        attend2 = Integer.parseInt(editText_attend.getText().toString());
        attend2 = attend2 + 1;
        display2(attend2);
    }

    public void decrement3(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended2);
        attend2 = Integer.parseInt(editText_attend.getText().toString());
        if (attend2 == 0) {
            return;
        }
        attend2 = attend2 - 1;
        display2(attend2);
    }

    private void display2(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.attended2);
        quantityTextView.setText("" + num);
    }


    public void increment4(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked2);
        bunk2 = Integer.parseInt(editText_bunked.getText().toString());
        bunk2 = bunk2 + 1;
        displayyy2(bunk2);
    }

    public void decrement4(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked2);
        bunk2 = Integer.parseInt(editText_bunked.getText().toString());
        if (bunk2 == 0) {
            return;
        }
        bunk2 = bunk2 - 1;
        displayyy2(bunk2);
    }

    private void displayyy2(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.bunked2);
        quantityTextView.setText("" + num);
    }

    private int calculateBunks2() {
        if (attend2 == 0 && bunk2 >= 0) {
            return free2 = 0;
        }
        free2 = ((attend2 * 100) / percent2) - attend2 - bunk2;
        if (free2 <= 0) {
            free2 = 0;
        }
        return free2;

    }

    private void displayBunk2(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.free_bunks2);
        quantityTextView.setText("" + number);
    }

    private int present_percent2() {
        if (attend2 == 0 && bunk2 >= 0) {
            return present_percent2 = 0;
        }
        present_percent2 = (attend2 * 100) / (attend2 + bunk2);
        return present_percent2;
    }

    private void display_present_percent2(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.present_percent2);
        quantityTextView.setText("" + number);
    }

    public void working2(View view) {
        sub2 = displaySubject2();
        subject2(sub2);
        EditText editText_attend = (EditText) findViewById(R.id.attended2);
        attend2 = Integer.parseInt(editText_attend.getText().toString());
        EditText editText_bunked = (EditText) findViewById(R.id.bunked2);
        bunk2 = Integer.parseInt(editText_bunked.getText().toString());
        percent2 = 75;
        percent2 = displaypercent2();
        subjectpercent2(percent2);
        EditText editText_percent = (EditText) findViewById(R.id.percentage2);
        percent2 = Integer.parseInt(editText_percent.getText().toString());
        if (percent2 == 0 || percent2 > 100) {
            Toast.makeText(this, "Invalid percentage entered", Toast.LENGTH_SHORT).show();
            return;
        }
        displayBunk2(calculateBunks2());
        display_present_percent2(present_percent2());
        SharedPreferences saveRecord = getSharedPreferences(save, MODE_PRIVATE);
        SharedPreferences.Editor editor = saveRecord.edit();
        editor.putInt("attended2", attend2).putInt("bunked2", bunk2).putInt("free2", free2).putInt("present percent2", present_percent2).putString("subject2", sub2).putInt("percent2", percent2);
        editor.apply();
    }

    private String displaySubject2() {
        EditText editText = (EditText) findViewById(R.id.sub2);
        String sub = editText.getText().toString();
        return sub;
    }

    private void subject2(String number) {
        TextView quantityTextView = (TextView) findViewById(R.id.sub2);
        quantityTextView.setText("" + number);
    }
    private int displaypercent2() {
        EditText editText = (EditText) findViewById(R.id.percentage2);
        int sub = Integer.parseInt(editText.getText().toString());
        return sub;
    }

    private void subjectpercent2(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.percentage2);
        quantityTextView.setText("" + number);
    }
    int percent3;
    int free3;
    int attend3;
    int bunk3;
    int present_percent3;
    String sub3;
    public void increment5(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended3);
        attend3 = Integer.parseInt(editText_attend.getText().toString());
        attend3 = attend3 + 1;
        display3(attend3);
    }

    public void decrement5(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended3);
        attend3 = Integer.parseInt(editText_attend.getText().toString());
        if (attend3 == 0) {
            return;
        }
        attend3 = attend3 - 1;
        display3(attend3);
    }

    private void display3(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.attended3);
        quantityTextView.setText("" + num);
    }


    public void increment6(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked3);
        bunk3 = Integer.parseInt(editText_bunked.getText().toString());
        bunk3 = bunk3 + 1;
        displayyy3(bunk3);
    }

    public void decrement6(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked3);
        bunk3 = Integer.parseInt(editText_bunked.getText().toString());
        if (bunk3 == 0) {
            return;
        }
        bunk3 = bunk3 - 1;
        displayyy3(bunk3);
    }

    private void displayyy3(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.bunked3);
        quantityTextView.setText("" + num);
    }

    private int calculateBunks3() {
        if (attend3 == 0 && bunk3 >= 0) {
            return free3 = 0;
        }
        free3 = ((attend3 * 100) / percent3) - attend3 - bunk3;
        if (free3 <= 0) {
            free3 = 0;
        }
        return free3;

    }

    private void displayBunk3(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.free_bunks3);
        quantityTextView.setText("" + number);
    }

    private int present_percent3() {
        if (attend3 == 0 && bunk3 >= 0) {
            return present_percent3 = 0;
        }
        present_percent3 = (attend3 * 100) / (attend3 + bunk3);
        return present_percent3;
    }

    private void display_present_percent3(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.present_percent3);
        quantityTextView.setText("" + number);
    }

    public void working3(View view) {
        sub3 = displaySubject3();
        subject3(sub3);
        EditText editText_attend = (EditText) findViewById(R.id.attended3);
        attend3 = Integer.parseInt(editText_attend.getText().toString());
        EditText editText_bunked = (EditText) findViewById(R.id.bunked3);
        bunk3 = Integer.parseInt(editText_bunked.getText().toString());
        percent3 = 75;
        percent3 = displaypercent3();
        subjectpercent3(percent3);
        EditText editText_percent = (EditText) findViewById(R.id.percentage3);
        percent3 = Integer.parseInt(editText_percent.getText().toString());
        if (percent3 == 0 || percent3 > 100) {
            Toast.makeText(this, "Invalid percentage entered", Toast.LENGTH_SHORT).show();
            return;
        }
        displayBunk3(calculateBunks3());
        display_present_percent3(present_percent3());
        SharedPreferences saveRecord = getSharedPreferences(save, MODE_PRIVATE);
        SharedPreferences.Editor editor = saveRecord.edit();
        editor.putInt("attended3", attend3).putInt("bunked3", bunk3).putInt("free3", free3).putInt("present percent3", present_percent3).putString("subject3", sub3).putInt("percent3", percent3);
        editor.apply();
    }

    private String displaySubject3() {
        EditText editText = (EditText) findViewById(R.id.sub3);
        String sub = editText.getText().toString();
        return sub;
    }

    private void subject3(String number) {
        TextView quantityTextView = (TextView) findViewById(R.id.sub3);
        quantityTextView.setText("" + number);
    }
    private int displaypercent3() {
        EditText editText = (EditText) findViewById(R.id.percentage3);
        int sub = Integer.parseInt(editText.getText().toString());
        return sub;
    }

    private void subjectpercent3(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.percentage3);
        quantityTextView.setText("" + number);
    }
    int percent4;
    int free4;
    int attend4;
    int bunk4;
    int present_percent4;
    String sub4;
    public void increment7(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended4);
        attend4 = Integer.parseInt(editText_attend.getText().toString());
        attend4 = attend4 + 1;
        display4(attend4);
    }

    public void decrement7(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended4);
        attend4 = Integer.parseInt(editText_attend.getText().toString());
        if (attend4 == 0) {
            return;
        }
        attend4 = attend4 - 1;
        display4(attend4);
    }

    private void display4(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.attended4);
        quantityTextView.setText("" + num);
    }


    public void increment8(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked4);
        bunk4 = Integer.parseInt(editText_bunked.getText().toString());
        bunk4 = bunk4 + 1;
        displayyy4(bunk4);
    }

    public void decrement8(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked4);
        bunk4 = Integer.parseInt(editText_bunked.getText().toString());
        if (bunk4 == 0) {
            return;
        }
        bunk4 = bunk4 - 1;
        displayyy4(bunk4);
    }

    private void displayyy4(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.bunked4);
        quantityTextView.setText("" + num);
    }

    private int calculateBunks4() {
        if (attend4 == 0 && bunk4 >= 0) {
            return free4 = 0;
        }
        free4 = ((attend4 * 100) / percent4) - attend4 - bunk4;
        if (free4 <= 0) {
            free4 = 0;
        }
        return free4;

    }

    private void displayBunk4(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.free_bunks4);
        quantityTextView.setText("" + number);
    }

    private int present_percent4() {
        if (attend4 == 0 && bunk4 >= 0) {
            return present_percent4 = 0;
        }
        present_percent4 = (attend4 * 100) / (attend4 + bunk4);
        return present_percent4;
    }

    private void display_present_percent4(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.present_percent4);
        quantityTextView.setText("" + number);
    }

    public void working4(View view) {
        sub4 = displaySubject4();
        subject4(sub4);
        EditText editText_attend = (EditText) findViewById(R.id.attended4);
        attend4 = Integer.parseInt(editText_attend.getText().toString());
        EditText editText_bunked = (EditText) findViewById(R.id.bunked4);
        bunk4 = Integer.parseInt(editText_bunked.getText().toString());
        percent4 = 75;
        percent4 = displaypercent4();
        subjectpercent4(percent4);
        EditText editText_percent = (EditText) findViewById(R.id.percentage4);
        percent4 = Integer.parseInt(editText_percent.getText().toString());
        if (percent4 == 0 || percent4 > 100) {
            Toast.makeText(this, "Invalid percentage entered", Toast.LENGTH_SHORT).show();
            return;
        }
        displayBunk4(calculateBunks4());
        display_present_percent4(present_percent4());
        SharedPreferences saveRecord = getSharedPreferences(save, MODE_PRIVATE);
        SharedPreferences.Editor editor = saveRecord.edit();
        editor.putInt("attended4", attend4).putInt("bunked4", bunk4).putInt("free4", free4).putInt("present percent4", present_percent4).putString("subject4", sub4).putInt("percent4", percent4);
        editor.apply();
    }

    private String displaySubject4() {
        EditText editText = (EditText) findViewById(R.id.sub4);
        String sub = editText.getText().toString();
        return sub;
    }

    private void subject4(String number) {
        TextView quantityTextView = (TextView) findViewById(R.id.sub4);
        quantityTextView.setText("" + number);
    }
    private int displaypercent4() {
        EditText editText = (EditText) findViewById(R.id.percentage4);
        int sub = Integer.parseInt(editText.getText().toString());
        return sub;
    }

    private void subjectpercent4(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.percentage4);
        quantityTextView.setText("" + number);
    }
    int percent5;
    int free5;
    int attend5;
    int bunk5;
    int present_percent5;
    String sub5;
    public void increment9(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended5);
        attend5 = Integer.parseInt(editText_attend.getText().toString());
        attend5 = attend5 + 1;
        display5(attend5);
    }

    public void decrement9(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended5);
        attend5 = Integer.parseInt(editText_attend.getText().toString());
        if (attend5 == 0) {
            return;
        }
        attend5 = attend5 - 1;
        display5(attend5);
    }

    private void display5(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.attended5);
        quantityTextView.setText("" + num);
    }


    public void increment10(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked5);
        bunk5 = Integer.parseInt(editText_bunked.getText().toString());
        bunk5 = bunk5 + 1;
        displayyy5(bunk5);
    }

    public void decrement10(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked5);
        bunk5 = Integer.parseInt(editText_bunked.getText().toString());
        if (bunk5 == 0) {
            return;
        }
        bunk5 = bunk5 - 1;
        displayyy5(bunk5);
    }

    private void displayyy5(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.bunked5);
        quantityTextView.setText("" + num);
    }

    private int calculateBunks5() {
        if (attend5 == 0 && bunk5 >= 0) {
            return free5 = 0;
        }
        free5 = ((attend5 * 100) / percent5) - attend5 - bunk5;
        if (free5 <= 0) {
            free5 = 0;
        }
        return free5;

    }

    private void displayBunk5(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.free_bunks5);
        quantityTextView.setText("" + number);
    }

    private int present_percent5() {
        if (attend5 == 0 && bunk5 >= 0) {
            return present_percent5 = 0;
        }
        present_percent5 = (attend5 * 100) / (attend5 + bunk5);
        return present_percent5;
    }

    private void display_present_percent5(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.present_percent5);
        quantityTextView.setText("" + number);
    }

    public void working5(View view) {
        sub5 = displaySubject5();
        subject5(sub5);
        EditText editText_attend = (EditText) findViewById(R.id.attended5);
        attend5 = Integer.parseInt(editText_attend.getText().toString());
        EditText editText_bunked = (EditText) findViewById(R.id.bunked5);
        bunk5 = Integer.parseInt(editText_bunked.getText().toString());
        percent5 = 75;
        percent5 = displaypercent5();
        subjectpercent5(percent5);
        EditText editText_percent = (EditText) findViewById(R.id.percentage5);
        percent5 = Integer.parseInt(editText_percent.getText().toString());
        if (percent5 == 0 || percent5 > 100) {
            Toast.makeText(this, "Invalid percentage entered", Toast.LENGTH_SHORT).show();
            return;
        }
        displayBunk5(calculateBunks5());
        display_present_percent5(present_percent5());
        SharedPreferences saveRecord = getSharedPreferences(save, MODE_PRIVATE);
        SharedPreferences.Editor editor = saveRecord.edit();
        editor.putInt("attended5", attend5).putInt("bunked5", bunk5).putInt("free5", free5).putInt("present percent5", present_percent5).putString("subject5", sub5).putInt("percent5", percent5);
        editor.apply();
    }

    private String displaySubject5() {
        EditText editText = (EditText) findViewById(R.id.sub5);
        String sub = editText.getText().toString();
        return sub;
    }

    private void subject5(String number) {
        TextView quantityTextView = (TextView) findViewById(R.id.sub5);
        quantityTextView.setText("" + number);
    }
    private int displaypercent5() {
        EditText editText = (EditText) findViewById(R.id.percentage5);
        int sub = Integer.parseInt(editText.getText().toString());
        return sub;
    }

    private void subjectpercent5(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.percentage5);
        quantityTextView.setText("" + number);
    }
    int percent6;
    int free6;
    int attend6;
    int bunk6;
    int present_percent6;
    String sub6;
    public void increment11(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended6);
        attend6 = Integer.parseInt(editText_attend.getText().toString());
        attend6 = attend6 + 1;
        display6(attend6);
    }

    public void decrement11(View view) {
        EditText editText_attend = (EditText) findViewById(R.id.attended6);
        attend6 = Integer.parseInt(editText_attend.getText().toString());
        if (attend6 == 0) {
            return;
        }
        attend6 = attend6 - 1;
        display6(attend6);
    }

    private void display6(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.attended6);
        quantityTextView.setText("" + num);
    }


    public void increment12(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked6);
        bunk6 = Integer.parseInt(editText_bunked.getText().toString());
        bunk6 = bunk6 + 1;
        displayyy6(bunk6);
    }

    public void decrement12(View view) {
        EditText editText_bunked = (EditText) findViewById(R.id.bunked6);
        bunk6 = Integer.parseInt(editText_bunked.getText().toString());
        if (bunk6 == 0) {
            return;
        }
        bunk6 = bunk6 - 1;
        displayyy6(bunk6);
    }

    private void displayyy6(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.bunked6);
        quantityTextView.setText("" + num);
    }

    private int calculateBunks6() {
        if (attend6 == 0 && bunk6 >= 0) {
            return free6 = 0;
        }
        free6 = ((attend6 * 100) / percent6) - attend6 - bunk6;
        if (free6 <= 0) {
            free6 = 0;
        }
        return free6;

    }

    private void displayBunk6(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.free_bunks6);
        quantityTextView.setText("" + number);
    }

    private int present_percent6() {
        if (attend6 == 0 && bunk6 >= 0) {
            return present_percent6 = 0;
        }
        present_percent6 = (attend6 * 100) / (attend6 + bunk6);
        return present_percent6;
    }

    private void display_present_percent6(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.present_percent6);
        quantityTextView.setText("" + number);
    }

    public void working6(View view) {
        sub6 = displaySubject6();
        subject6(sub6);
        EditText editText_attend = (EditText) findViewById(R.id.attended6);
        attend6 = Integer.parseInt(editText_attend.getText().toString());
        EditText editText_bunked = (EditText) findViewById(R.id.bunked6);
        bunk6 = Integer.parseInt(editText_bunked.getText().toString());
        percent6 = 75;
        percent6 = displaypercent6();
        subjectpercent6(percent6);
        EditText editText_percent = (EditText) findViewById(R.id.percentage6);
        percent6 = Integer.parseInt(editText_percent.getText().toString());
        if (percent6 == 0 || percent6 > 100) {
            Toast.makeText(this, "Invalid percentage entered", Toast.LENGTH_SHORT).show();
            return;
        }
        displayBunk6(calculateBunks6());
        display_present_percent6(present_percent6());
        SharedPreferences saveRecord = getSharedPreferences(save, MODE_PRIVATE);
        SharedPreferences.Editor editor = saveRecord.edit();
        editor.putInt("attended6", attend6).putInt("bunked6", bunk6).putInt("free6", free6).putInt("present percent6", present_percent6).putString("subject6", sub6).putInt("percent6", percent6);
        editor.apply();
    }

    private String displaySubject6() {
        EditText editText = (EditText) findViewById(R.id.sub6);
        String sub = editText.getText().toString();
        return sub;
    }

    private void subject6(String number) {
        TextView quantityTextView = (TextView) findViewById(R.id.sub6);
        quantityTextView.setText("" + number);
    }
    private int displaypercent6() {
        EditText editText = (EditText) findViewById(R.id.percentage6);
        int sub = Integer.parseInt(editText.getText().toString());
        return sub;
    }

    private void subjectpercent6(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.percentage6);
        quantityTextView.setText("" + number);
    }

    @Override
    public void onBackPressed() {
        Intent mainIntent = new Intent(BunkActivity.this,MainActivity.class);
        startActivity(mainIntent);
        super.onBackPressed();
        finish();
    }
}

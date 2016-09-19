package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int teamATotal = 0, teamBTotal = 0;
    private boolean isBasketballDisplayed = true;   /*Since there are only two sports being
                                                      displayed a bool will work just fine to
                                                      keep track of which sport is currently
                                                      being displayed.  */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView sportName = (TextView) findViewById(R.id.sport_name);
        sportName.setText(R.string.basketball);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void add3PointsA(View view) {
        teamATotal += 3;
        displayForTeamA(teamATotal);
    }

    public void add2PointsA(View view) {
        teamATotal += 2;
        displayForTeamA(teamATotal);
    }

    public void add1PointA(View view) {
        teamATotal++;
        displayForTeamA(teamATotal);
    }

    public void add3PointsB(View view) {
        teamBTotal += 3;
        displayForTeamB(teamBTotal);
    }

    public void add2PointsB(View view) {
        teamBTotal += 2;
        displayForTeamB(teamBTotal);
    }

    public void add1PointB(View view) {
        teamBTotal++;
        displayForTeamB(teamBTotal);
    }

    public void resetScoreboard(View view) {
        teamATotal = teamBTotal = 0;
        displayForTeamA(teamATotal);
        displayForTeamB(teamBTotal);
    }

    public void changeSport(View view) {
        TextView sportName = (TextView) findViewById(R.id.sport_name);
        TextView a3 = (TextView) findViewById(R.id.btn3PointsTeamA);
        TextView a2 = (TextView) findViewById(R.id.btn2PointsTeamA);
        TextView a1 = (TextView) findViewById(R.id.btn1PointTeamA);
        TextView b3 = (TextView) findViewById(R.id.btn3PointsTeamB);
        TextView b2 = (TextView) findViewById(R.id.btn2PointsTeamB);
        TextView b1 = (TextView) findViewById(R.id.btn1PointTeamB);
        TextView a6 = (TextView) findViewById(R.id.btnTouchdownTeamA);
        TextView b6 = (TextView) findViewById(R.id.btnTouchdownTeamB);

        if (isBasketballDisplayed) {
            sportName.setText(R.string.football);
            a3.setText(R.string.field_goal);
            b3.setText(R.string.field_goal);
            a2.setText(R.string.football_2_points);
            b2.setText(R.string.football_2_points);
            a1.setText(R.string.add_one_point);
            b1.setText(R.string.add_one_point);
            a6.setVisibility(View.VISIBLE);
            b6.setVisibility(View.VISIBLE);
        } else {
            sportName.setText(R.string.basketball);
            a3.setText(R.string.points_3);
            b3.setText(R.string.points_3);
            a2.setText(R.string.points_2);
            b2.setText(R.string.points_2);
            a1.setText(R.string.points_1);
            b1.setText(R.string.points_1);
            a6.setVisibility(View.GONE);
            b6.setVisibility(View.GONE);
        }
        isBasketballDisplayed = !isBasketballDisplayed;
        resetScoreboard(view);
    }

    public void add6PointsA(View view) {
        teamATotal += 6;
        displayForTeamA(teamATotal);
    }

    public void add6PointB(View view) {
        teamBTotal += 6;
        displayForTeamB(teamBTotal);
    }
}

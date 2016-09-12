package com.example.android.courtcounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private int teamATotal = 0,
            teamBTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
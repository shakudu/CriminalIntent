package no.gitt.criminalintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "no.gitt.criminalintent.crime_id";
    private UUID mCrimeId;

    @Override
    protected Fragment createFragment() {
        mCrimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(mCrimeId);
    }

    public static Intent newIntent(Context packageContext, UUID crimeID) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeID);
        return intent;
    }


    public static UUID getModifiedCrimeId(Intent result) {
        return (UUID) result.getSerializableExtra(EXTRA_CRIME_ID);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_CRIME_ID,mCrimeId);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}

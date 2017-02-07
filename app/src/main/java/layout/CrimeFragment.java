package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.ionic.in.criminalintent.Crime;
import com.ionic.in.criminalintent.CrimeActivity;
import com.ionic.in.criminalintent.CrimeLab;
import com.ionic.in.criminalintent.R;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment {
  private  static final String ARG_CRIME_ID = "crime_id";
  private Crime mCrime;
  private EditText mTitleField;
  private Button mDateBtn;
  private CheckBox mSolvedCheckBox;


  public static CrimeFragment newInstance(UUID crimeId){
      Bundle args = new Bundle();
      args.putSerializable(ARG_CRIME_ID, crimeId);

      CrimeFragment fragment = new CrimeFragment();
      fragment.setArguments(args);
      return fragment;
  }
  public CrimeFragment() {
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
      UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
      mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState)
  {
    View v = inflater.inflate(R.layout.fragment_crime, container, false);

    mTitleField = (EditText) v.findViewById(R.id.crime_title);
    mTitleField.setText(mCrime.getTitle());
    mTitleField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Intentionally blank!
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        mCrime.setTitle(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {
        // Intentionally blank!
      }
    });

    mDateBtn = (Button) v.findViewById(R.id.crime_date);
    mDateBtn.setText(mCrime.getDate().toString());
    mDateBtn.setEnabled(false);

    mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
    mSolvedCheckBox.setChecked(mCrime.isSolved());
    mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mCrime.setSolved(isChecked);
      }
    });

    return v;
  }

}

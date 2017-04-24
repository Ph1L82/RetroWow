package cl.philipsoft.ph1l.retrowow;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import cl.philipsoft.ph1l.retrowow.data.RealmsData;
import cl.philipsoft.ph1l.retrowow.models.Realm;
import cl.philipsoft.ph1l.retrowow.views.CharacterActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner realmSp, characterSp;
    private Button searchBtn;
    private EditText characterEt;
    private String realm, characterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillRealmSpinner();
        addListenersOnSpinnersItemSelection();
        addListenerOnButton();

    }

    public void fillRealmSpinner() {
        List<Realm> realmList = new RealmsData().realms();
        realmSp = (Spinner) findViewById(R.id.realmSp);
        realmSp.setEnabled(false);

        ArrayAdapter<Realm> dataAdapter = new ArrayAdapter<Realm>(this,
                android.R.layout.simple_spinner_item, realmList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        realmSp.setAdapter(dataAdapter);
        realmSp.setEnabled(true);
    }

    public void addListenersOnSpinnersItemSelection() {
        characterSp = (Spinner) findViewById(R.id.charactersSp);
        characterSp.setEnabled(false);
        realmSp = (Spinner) findViewById(R.id.realmSp);
        realmSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                realm = String.valueOf(realmSp.getSelectedItem());
                characterSp.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, Resources.getSystem().getString(R.string.choose_realm), Toast.LENGTH_SHORT).show();
            }
        });
        characterSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                characterName = String.valueOf(characterSp.getSelectedItem());
                if (realm.length() <= 0) {
                    Toast.makeText(MainActivity.this, Resources.getSystem().getString(R.string.choose_realm), Toast.LENGTH_SHORT).show();
                } else {
                    characterDetails();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, Resources.getSystem().getString(R.string.choose_character), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerOnButton() {
        realmSp = (Spinner) findViewById(R.id.realmSp);
        searchBtn = (Button) findViewById(R.id.searchBtn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCharacterName()) {
                    characterName = characterEt.getText().toString();
                    characterDetails();
                } else {
                    Toast.makeText(MainActivity.this, Resources.getSystem().getString(R.string.search_character), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkCharacterName() {
        characterEt = (EditText) findViewById(R.id.characterEt);
        if (characterEt.getText().toString().trim().length() <= 0) {
            Toast.makeText(this, Resources.getSystem().getString(R.string.search_character), Toast.LENGTH_SHORT).show();
            return false;
        } else {
            searchBtn = (Button) findViewById(R.id.searchBtn);
            searchBtn.setEnabled(true);
            return true;
        }
    }

    private void characterDetails() {
        Intent intent = new Intent(MainActivity.this, CharacterActivity.class);
        intent.putExtra("realm", realm);
        intent.putExtra("characterName", characterName);
        startActivity(intent);
    }

}

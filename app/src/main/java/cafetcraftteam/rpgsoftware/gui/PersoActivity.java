package cafetcraftteam.rpgsoftware.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.support.test.espresso.core.deps.guava.collect.ImmutableCollection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cafetcraftteam.rpgsoftware.R;

public abstract class PersoActivity extends AppCompatActivity implements InformationList.PersonneAdapterListener {

    private ListView mListViewInformation;
    private BaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perso);

        //Récupération de la liste des personnes
        ArrayList<Personne> listP = Personne.getAListOfPersonne();

        //Création et initialisation de l'Adapter pour les personnes
        InformationList adapter = new InformationList(this, listP);

        //Récupération du composant ListView
        ListView list = (ListView) findViewById(R.id.listView_Information);

        //Initialisation de la liste avec les données
        list.setAdapter(adapter);

        //Ecoute des évènements sur votre liste
        adapter.addListener(this);
    }

    public void onClickNom(Personne item, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Personne");

        builder.setMessage("Vous avez cliqué sur : " + item.nom);
        builder.setPositiveButton("Oui", null);
        builder.setNegativeButton("Non", null);
        builder.show();
    }

}

package cafetcraftteam.rpgsoftware.gui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cafetcraftteam.rpgsoftware.R;

/**
 * Created by defig on 09.03.2016.
 */
public class InformationList extends BaseAdapter {
    // Une liste de personnes
    private List<Personne> mListP;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;

    @Override
    public int getCount() {
        return mListP.size();
    }

    @Override
    public Object getItem(int position) {
        return mListP.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.information_list, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView tv_Nom = (TextView)layoutItem.findViewById(R.id.textView_Name);
        TextView tv_Prenom = (TextView)layoutItem.findViewById(R.id.textView_NickName);

        //(3) : Renseignement des valeurs
        tv_Nom.setText(mListP.get(position).nom);
        tv_Prenom.setText(mListP.get(position).prenom);

        //(4) Changement de la couleur du fond de notre item
        if (mListP.get(position).genre == Personne.MASCULIN) {
            layoutItem.setBackgroundColor(Color.BLUE);
        } else {
            layoutItem.setBackgroundColor(Color.MAGENTA);
        }

        //On mémorise la position de la "Personne" dans le composant textview
        tv_Nom.setTag(position);

        //On ajoute un listener
        tv_Nom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Lorsque l'on clique sur le nom, on récupère la position de la "Personne"
                Integer position = (Integer)v.getTag();

                //On prévient les listeners qu'il y a eu un clic sur le TextView "TV_Nom".
                sendListener(mListP.get(position), position);

            }

        });

        //On retourne l'item créé.
        return layoutItem;

    }

    /**
     * Interface pour écouter les évènements sur le nom d'une personne
     */
    public interface PersonneAdapterListener {
        public void onClickNom(Personne item, int position);
    }

    //Contient la liste des listeners
    private ArrayList<PersonneAdapterListener> mListListener = new ArrayList<PersonneAdapterListener>();
    /**
     * Pour ajouter un listener sur notre adapter
     */
    public void addListener(PersonneAdapterListener aListener) {
        mListListener.add(aListener);
    }

    private void sendListener(Personne item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickNom(item, position);
        }
    }

    public InformationList(Context context, List<Personne> aListP) {
        mContext = context;
        mListP = aListP;
        mInflater = LayoutInflater.from(mContext);
    }
}

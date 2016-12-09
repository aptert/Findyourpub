package com.example.tomapter.findyourpub.content;

import android.content.Intent;
import android.widget.ImageView;

import com.example.tomapter.findyourpub.MainActivity;
import com.example.tomapter.findyourpub.PubListActivity;
import com.example.tomapter.findyourpub.R;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PubContent {

    /**
     * An array of sample (pub) items.
     */
    public static final List<PubItem> ITEMS = new ArrayList<PubItem>();

    /**
     * A map of sample (pub) items, by ID.
     */
    public static final Map<String, PubItem> ITEM_MAP = new HashMap<String, PubItem>();

    private static final int COUNT = 25;
    static{

        String city = MainActivity.getCity();
        // Add some sample items.
       /* addItem(new PubItem("1", "Phoenix","02476 520387", "122 Gosford Street, Coventry, CV1 5DL",R.drawable.phoenix_logo));
        addItem(new PubItem("2", "Quid\'s Inn","024 7622 9551", "118 gosford street, Coventry, CV1 5DL",R.drawable.quids_inn));
        addItem(new PubItem("3", "Castle Ground","024 7663 0862", "7 Little Park St, Coventry CV1 2UR",R.drawable.castle_ground));
        addItem(new PubItem("4", "Las Iguanas","02476 239 120", "SU4, Cathedral Lanes Shopping Centre, Broadgate, Coventry CV1 1LL, UK",R.drawable.las_iguanas));
*/
        switch(city){
            case ("Coventry"):
                addItem(new PubItem("1", "Phoenix","02476 520387", "122 Gosford Street, Coventry, CV1 5DL",R.drawable.phoenix_logo));
                addItem(new PubItem("2", "Quid\'s Inn","024 7622 9551", "118 gosford street, Coventry, CV1 5DL",R.drawable.quids_inn));
                addItem(new PubItem("3", "Castle Ground","024 7663 0862", "7 Little Park St, Coventry CV1 2UR",R.drawable.castle_ground));
                addItem(new PubItem("4", "Las Iguanas","02476 239 120", "SU4, Cathedral Lanes Shopping Centre, Broadgate, Coventry CV1 1LL, UK",R.drawable.las_iguanas));
                addItem(new PubItem("5", "The Establishment","+44 20 7387 0221", "THE OLD COUNTY HALL BAYLEY LANE, Coventry CV1 5RN",R.drawable.establishment ));
                break;
            case ("London"):
                addItem(new PubItem("1", "Ain't Nothin But...","+44 20 7287 0514", "20 Kingly Street, Soho, W1B 5PZ",R.drawable.aint_nothing));
                addItem(new PubItem("2", "The Albany","+44 24 7622 2727", "240 Great Portland St, Paddington, London W1W 5QU",R.drawable.albany ));
                addItem(new PubItem("3", "68 & Boston"," +44 20 7287 3713", "5 Greek St, Soho, London W1D 4DD",R.drawable.boston));
                addItem(new PubItem("4", "Ape & Bird","+44 20 7836 3119", "142 Shaftesbury Ave, Soho, London WC2H 8HJ",R.drawable.apebird));
                addItem(new PubItem("5", "Bar Termini","+44 7860 945018", "7 Old Compton St, Soho, London W1D 5JE",R.drawable.termini));
                break;
        }

    }

    private static void addItem(PubItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /*private static PubItem createPubItem(int position) {
        return new PubItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }*/

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A pub item representing a piece of content.
     */
    public static class PubItem {
        public final String id;
        public final String name;
        public final String tel;
        public final String address;
        public LatLng location;
        public int logo;

        public PubItem(String id, String name, String tel, String address, int logo) {
            this.id = id;
            this.name = name;
            this.tel = tel;
            this.address = address;

            this.logo = logo;
        }

        @Override
        public String toString() {
            return name;
        }
    }


}

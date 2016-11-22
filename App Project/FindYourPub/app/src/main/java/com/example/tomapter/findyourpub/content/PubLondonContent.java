package com.example.tomapter.findyourpub.content;

import android.widget.ImageView;

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
public class PubLondonContent {

    /**
     * An array of sample (pub) items.
     */
    public static final List<PubItem> ITEMS = new ArrayList<PubItem>();

    /**
     * A map of sample (pub) items, by ID.
     */
    public static final Map<String, PubItem> ITEM_MAP = new HashMap<String, PubItem>();

    static {
        // Add some sample items.
        addItem(new PubItem("1", "tomlondon","02476 520387", "122 Gosford Street, Coventry, CV1 5DL",R.drawable.phoenix_logo));
        addItem(new PubItem("2", "Quid\'s Inn","024 7622 9551", "118 gosford street, Coventry, CV1 5DL",R.drawable.quids_inn));
        //addItem(new PubItem("3", "Castle Ground","024 7663 0862", "7 Little Park St, Coventry CV1 2UR"));
        /*for (int i = 1; i <= COUNT; i++) {
            addItem(createPubItem(i));
        }*/
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

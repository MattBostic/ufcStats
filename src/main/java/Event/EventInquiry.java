package Event;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

//Filter for various event needs.
public class EventInquiry {

    public EventInquiry() {
    }

    public JsonElement getCorner(String corner, JsonObject element){
        if(!element.getAsJsonObject().has(corner)){
            return null;
        }
        return element.getAsJsonObject().get(corner);
    }


    public ArrayList<JsonElement> FilterByRound(String round, ArrayList<EventResults> eventList){
        var rounds = new ArrayList<JsonElement>();

                eventList.iterator().forEachRemaining(
                        e -> {
                            if(e.getRoundStats().has(round)){
                                rounds.add(e.getRoundStats().get(round));
                            }
                        });
        return rounds;
    }

}

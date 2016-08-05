package com.lps.lpsapp.positions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by dle on 28.06.2016.
 */
public class BeaconGroup extends HashMap<Integer, Point2D> {

public boolean isEquals(BeaconGroup group) {
    if(this.size() != group.size()) {
        return false;
    }

    for(Integer nr:this.keySet()) {
        if(!group.keySet().contains(nr)) {
            return false;
        }
    }

    return true;
}
    public Boolean IsValide(float xDelta, float yDelta) {
        //return true;

        List<Float> x = new ArrayList<>();
        List<Float> y = new ArrayList<>();

        float mX = 0;
        float mY = 0;


        for (Point2D point : this.values()) {
            x.add(point.x);
            y.add(point.y);
        }

        for (int i = 0; i < x.size(); i++) {
            mX += x.get(i);
        }
        mX = mX / x.size();
        for (int i = 0; i < y.size(); i++) {
            mY += y.get(i);
        }
        mY = mY / x.size();

        double diffX = 0;

        for (int i = 0; i < x.size(); i++) {
            double diff = Math.abs(mX - x.get(i));
            if (diff > diffX) {
                diffX = diff;
            }

        }

        double diffY = 0;
        for (int i = 0; i < y.size(); i++) {
            double diff = Math.abs(mY - y.get(i));
            if (diff > diffY) {
                diffY = diff;
            }

        }


        if (diffX < xDelta || diffY < yDelta) {
            return false;
        }

        return true;

    }

    public float getSummDistance(HashMap<Integer, Double> distances) {
        float distance = 0;
        for (Integer key : this.keySet()) {
            if (distances.containsKey(key)) {
                distance += distances.get(key);
            }
        }
        return distance;
    }


}

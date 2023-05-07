package com.credibanco.assessment.card.util;

public class Utils {

    public static String enmascararPan (Long pan){
        int nPan = (int) Math.floor(Math.log10(Math.abs(pan)+1));
        long panH = (long) Math.floor(pan/(Math.pow(10,nPan-6)));
        long panL = (long) Math.floor(pan%10000);
        String panMasK = panH + "******" + panL;
        return panMasK;
    }
}

package com.company.GUI.OptionsList;

import java.util.ArrayList;
import java.util.List;

public class OptionsList {
    private List<String> optionsList = new ArrayList<String>();

    public void loadLine(String p){
        optionsList.add(p);
    }
    public List getOptionsList(){
        return optionsList;
    }
}

package com.company.OptionsList;

import com.company.Util.txtPersistance.FilesManager;

public class OptionsListDAOFileImplementation implements OptionsListDAO {
    @Override
    public OptionsList checkFiles(String filePath) {
        FilesManager fm = new FilesManager();
        return(fm.getOptionsList(filePath));
    }
}

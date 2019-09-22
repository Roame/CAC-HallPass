package com.hallpass.roame.cac_hallpass;

import com.hallpass.roame.cac_hallpass.models.BasicPass;

public interface FragCommunication {

    void navSelection(String selected);
    void passInput(BasicPass pass);
    void resetPass(boolean reset);


}

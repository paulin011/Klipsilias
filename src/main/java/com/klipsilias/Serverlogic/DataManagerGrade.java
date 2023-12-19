package com.klipsilias.Serverlogic;
import com.klipsilias.Serverlogic.KlipsiliasWebFacade;
interface DataManagerGrade extends DataManager {
    double getGradeNumber();

    void setGradeNumber(int gradeNumber);
}

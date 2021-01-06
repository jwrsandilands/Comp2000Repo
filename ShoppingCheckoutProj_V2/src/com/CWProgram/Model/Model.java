package com.CWProgram.Model;

import java.util.ArrayList;
import java.util.List;


public class Model implements IModelSubject {
    public List<IModelObserver> iModelObserver = new ArrayList<IModelObserver> ();

    @Override
    public void add(IModelObserver observer) {
        iModelObserver.add(observer);
    }
}

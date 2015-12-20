package com.example.copycontacts.ui;


import com.example.copycontacts.base.Repository;
import com.example.copycontacts.domain.entities.Calls;

import java.util.List;

/**
 * Created by Михайлик on 06.12.2015.
 */
public class Presenter {
    CallsView viewer;
    Repository repository;

    public Presenter(CallsView viewer, Repository repository) {
        this.viewer = viewer;
        this.repository = repository;
    }
    public void showCalls()
         {
             List<Calls> list = repository.getCalls();
             viewer.showCalls(list);
         }
    public void insertCalls(Calls calls)
    {
        repository.insertCalls(calls);
    }


}

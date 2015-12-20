package com.example.copycontacts.ui;


import com.example.copycontacts.domain.entities.Calls;

import java.util.List;

/**
 * Created by Михайлик on 06.12.2015.
 */
    public interface CallsView {
        public void showCalls(List<Calls> list);
    }

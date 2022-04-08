package com.kreitek.editor;

import com.kreitek.editor.history.EditorCareTaker;

import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<String> documentLines);
}

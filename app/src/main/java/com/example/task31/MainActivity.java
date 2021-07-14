package com.example.task31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView displayText;
    DLL list;
    Node node;
    Node nodeTrial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = findViewById(R.id.displayText);
        node = new Node(50);
        nodeTrial = new Node(70);
        list = new DLL();
        list.push(10);
        list.push(5);
        list.push(14);
        displayText.setText("added at first - push method : " + list.push(20) + "\ninsert at specific index " + list.insertAt(node, 1)
                + "\ndisplay all list backward : " + list.printValuesBackward() + " \n\nremove last node and return it : " + node.toString() + "\n the size of the array is :"
                + list.size() + " \n list contains 3 : " + list.contains(3) + " list contains 10 : " + list.contains(10));
    }
}
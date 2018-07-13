package com.example.ahmedpc.retrofitwithkotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ReadPdf extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_pdf);

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("simple_android.pdf").load();
        pdfView.useBestQuality(true);
    }
}

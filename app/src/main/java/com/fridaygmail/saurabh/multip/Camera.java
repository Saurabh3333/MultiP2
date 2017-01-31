package com.fridaygmail.saurabh.multip;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    Button b1;
    ImageView civ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        b1 = (Button)findViewById(R.id.cameraCapture);
        civ = (ImageView)findViewById(R.id.cameraImageView);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(imageCapture,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap b = (Bitmap) data.getExtras().get("data");
        civ.setImageBitmap(b);
    }
}

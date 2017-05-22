package com.app.datasharing;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void shareText(View v) {
        Intent sendIntent = new Intent();
        // Set the action to be performed i.e 'Send Data'
        sendIntent.setAction(Intent.ACTION_SEND);
        // Add the text to the intent
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Salam..How is your day today?");
        // Set the type of data i.e 'text/plain'
        sendIntent.setType("text/plain");
        // Launches the activity; Open 'Text editor' if you set it as default app to handle Text
        startActivity(sendIntent);
    }


    public void shareTextusingChooser(View v) {
        Intent sendIntent = new Intent();
        // Set the action to be performed i.e 'Send Data'
        sendIntent.setAction(Intent.ACTION_SEND);
        // Add the text to the intent
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Salam..How is your day today?");
        // Set the type of data i.e 'text/plain'
        sendIntent.setType("text/plain");
        // Shows chooser (List of Apps) that can handle Text data; You have to choose one among them
        startActivity(Intent.createChooser(sendIntent,
                getResources().getText(R.string.chooser_text)));
    }


    public void shareImage(View v) {

        String imagePath = Environment.getExternalStorageDirectory()
                + "/res/drawable/" + "/sample_2.png";
        File imageFileToShare = new File(imagePath);
        // Get the URI of the image 'pic1.png' exists under pgguru right under SD card
        Uri uri = Uri.fromFile(imageFileToShare);
        // Set the action to be performed i.e 'Send Data'
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        // Add the URI holding a stream of data
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        // Set the type of data i.e 'image/* which means image/png, image/jpg, image/jpeg etc.,'
        sendIntent.setType("image/*");
        // Launches the activity; Open 'Gallery' if you set it as default app to handle Image
        startActivity(sendIntent);

    }


    public void shareImageusingChooser(View v) {
        String imagePath = Environment.getExternalStorageDirectory()
                + "/sample_2/" + "/sample_2.png";
        File imageFileToShare = new File(imagePath);
        Uri uri = Uri.fromFile(imageFileToShare);
        // Set the action to be performed i.e 'Send Data'
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        // Add the URI holding a stream of data
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        // Set the type of data i.e 'image/* which means image/png, image/jpg, image/jpeg etc.,'
        sendIntent.setType("image/*");
        //  Shows chooser (List of Apps) that can handle Image; You have to choose one among them
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.chooser_text)));
    }


    public void shareMultipleImages(View v) {
        String imagePath1 = Environment.getExternalStorageDirectory()
                + "/pgguru/" + "/pic1.png";
        String imagePath2 = Environment.getExternalStorageDirectory()
                + "/pgguru/" + "/pic2.png";
        // Multiple Images' file objects
        File image1FileToShare = new File(imagePath1);
        File image2FileToShare = new File(imagePath2);
        // Get URI of Image's location
        Uri image1URI = Uri.fromFile(image1FileToShare);
        Uri image2URI = Uri.fromFile(image2FileToShare);
        ArrayList<Uri> imageUris = new ArrayList<Uri>();
        imageUris.add(image1URI); // Add your image URIs here
        imageUris.add(image2URI); // Add your image URIs here
        // Set the action to be performed i.e 'Send Multiple Data'
        Intent sendIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        // Add the URIs holding a stream of data
        sendIntent.putExtra(Intent.EXTRA_STREAM, imageUris);
        // Set the type of data i.e 'image/* which means image/png, image/jpg, image/jpeg etc.,'
        sendIntent.setType("image/*");
        // Launches the activity; Open 'Gallery' if you set it as default app to handle Image
        startActivity(sendIntent);
    }
    public void setCalendar(View v){
    Intent calIntent = new Intent(Intent.ACTION_INSERT);
    calIntent.setData(CalendarContract.Events.CONTENT_URI);
    startActivity(calIntent);
  }

}

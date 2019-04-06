package com.example.admin.lab09.exercise01;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.lab09.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercise01 extends AppCompatActivity {
    private static final String DEFAULT_DOWNLOAD_LINK = "https://www.nicepng.com/png/full/18-180932_android-png-images-picture-transparent-stock-android-jetpack.png";
    private URL downloadUrl = null;
    private InputStream is = null;
    private Bitmap bmImg = null;
    private Button btnDownloadSyncTask;
    private ImageView imageView = null;
    private ProgressDialog progressDialog;
    private EditText edtLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_01);

        btnDownloadSyncTask = (Button) findViewById(R.id.btnDownloadSyncTask);
        edtLink = (EditText) findViewById(R.id.edtLink);
        imageView = (ImageView) findViewById(R.id.image);

        edtLink.setText(DEFAULT_DOWNLOAD_LINK);

        btnDownloadSyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String downloadUrl = edtLink.getText().toString().trim();
                if (downloadUrl.isEmpty()) {
                    Toast.makeText(Exercise01.this, "Download link cannot be empty!!!", Toast.LENGTH_LONG).show();
                    return;
                }
                AsyncTaskExample asyncTask = new AsyncTaskExample();
                asyncTask.execute(downloadUrl);
            }
        });
    }

    private class AsyncTaskExample extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Exercise01.this);
            progressDialog.setMessage("Downloading...");
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                downloadUrl = new URL(strings[0]);
                HttpURLConnection httpURLConnection = createHttpConnection(downloadUrl);
//                downloadImage(downloadUrl, httpURLConnection);
                publishProgress("10%");
                displayDownloadedImage(httpURLConnection);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bmImg;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.i(Exercise01.class.getName(), values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (imageView != null) {
                progressDialog.hide();
                imageView.setImageBitmap(bitmap);
            } else {
                progressDialog.show();
            }
        }
    }

    private HttpURLConnection createHttpConnection(URL downloadUrl) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) downloadUrl.openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private void downloadImage(URL downloadUrl, HttpURLConnection httpURLConnection) throws IOException {
        int count;
        String root = Environment.getExternalStorageDirectory().toString();
        System.out.println("Downloading...");
        // getting file length
        int lenghtOfFile = httpURLConnection.getContentLength();

        // input stream to read file - with 8k buffer
        InputStream input = new BufferedInputStream(downloadUrl.openStream(), 8192);

        // Output stream to write file
        OutputStream output = new FileOutputStream(root+"/downloadedfile.jpg");
        byte data[] = new byte[lenghtOfFile];

        long total = 0;
        while ((count = input.read(data)) != -1) {
            total += count;

            // writing data to file
            output.write(data, 0, count);

        }

        // flushing output
        output.flush();

        // closing streams
        output.close();
        input.close();
    }

    private void displayDownloadedImage(HttpURLConnection httpURLConnection) throws IOException {
        is = httpURLConnection.getInputStream();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        bmImg = BitmapFactory.decodeStream(is, null, options);
    }

}
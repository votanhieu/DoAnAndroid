package es.cice.cookiemonstersgame;

import android.os.AsyncTask;

/**
 * Created by SGU Group 2
 */

public class ovenAsyntask extends AsyncTask<Integer, Integer, Void>{
    private tarroGalletas tarroG;
    private static final int REST=10;

    @Override
    protected Void doInBackground(Integer... params) {
        //cada cierto tiempo, especificado en params genera una cantidad de galletas
        while (!isCancelled()) {
            tarroG.ponGalletas(REST);
            try {
                Thread.sleep(params[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }


    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}

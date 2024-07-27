package edu.sfsu.shrine.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.sfsu.shrine.code.model.RandomUserModel;
import edu.sfsu.shrine.databinding.FragmentHomeBinding;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends Fragment {
    Context context;

    private FragmentHomeBinding binding;

    public RecyclerView recyclerView;
    public ArrayList<RandomUserModel> randomUserModel = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final String URL = "https://randomuser.me/api/?results=2";

        Log.v("LOG", "HomeFragment Loaded...");

        // mims
        // LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        /*
        homeViewModel.getState().observe(getViewLifecycleOwner(), uiState -> {
            textView.setText("White Woman");
        });
         */

        new AsyncRandomUser().execute(URL);

        return root;
    }

    public class AsyncRandomUser extends AsyncTask<String, Void, String> {

        /*
        @Override
        protected void onPreExecute(){}
        */

        @Override
        protected String doInBackground(String... param) {
            Log.v("LOG", "Inside of doInBackground()");

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(param[0]).build();

            try {
                Response response = client.newCall(request).execute();

                if(!response.isSuccessful())
                    return null;

                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /*
        @Override
        protected void onProgressUpdate(Progress... values){ }
        */

        @Override
        protected void onPostExecute(String result) { // onPostExecute - runs on the main thread.
            super.onPostExecute(result);

            @SuppressLint("SimpleDateFormat") SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

            // background thread to open and parse the downloaded json.
            final Handler handler = new Handler();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Log.v("LOG", "Inside of the new Runnable Thread!");

                    try {
                        File file = new File(requireContext().getFilesDir(), fmt.format(new Date()) + "_shrine.txt");
                        FileWriter fileWriter = new FileWriter(file);

                        // Write JSON response to disk.
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(result.toString());
                        bufferedWriter.close();

                        // Read JSON response from disk.
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String line = bufferedReader.readLine();

                        while(line != null) {
                            stringBuilder.append(line).append("\n");
                            line = bufferedReader.readLine();
                        }

                        bufferedReader.close();

                        // This is being populated from disk.
                        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                        JSONArray obj = jsonObject.getJSONArray("results");

                        for(int i =  0; i < obj.length(); i++) {
                            randomUserModel.add(new RandomUserModel(
                                    obj.getJSONObject(i).getString("cell"),
                                    obj.getJSONObject(i).getJSONObject("location").getJSONObject("coordinates").getString("latitude"),
                                    obj.getJSONObject(i).getJSONObject("location").getJSONObject("coordinates").getString("longitude"),
                                    obj.getJSONObject(i).getJSONObject("dob").getInt("age"),
                                    obj.getJSONObject(i).getJSONObject("dob").getString("date"),
                                    obj.getJSONObject(i).getString("email"),
                                    obj.getJSONObject(i).getString("gender"),
                                    obj.getJSONObject(i).getJSONObject("id").getString("name"),
                                    obj.getJSONObject(i).getJSONObject("id").getString("value"),
                                    obj.getJSONObject(i).getJSONObject("location").getString("city"),
                                    obj.getJSONObject(i).getJSONObject("location").getString("country"),
                                    obj.getJSONObject(i).getJSONObject("location").getInt("postcode"),
                                    obj.getJSONObject(i).getJSONObject("location").getString("state"),
                                    obj.getJSONObject(i).getJSONObject("location").getJSONObject("street").getInt("number"),
                                    obj.getJSONObject(i).getJSONObject("location").getJSONObject("street").getString("name"),
                                    obj.getJSONObject(i).getJSONObject("login").getString("md5"),
                                    obj.getJSONObject(i).getJSONObject("login").getString("password"),
                                    obj.getJSONObject(i).getJSONObject("login").getString("salt"),
                                    obj.getJSONObject(i).getJSONObject("login").getString("sha1"),
                                    obj.getJSONObject(i).getJSONObject("login").getString("sha256"),
                                    obj.getJSONObject(i).getJSONObject("login").getString("username"),
                                    obj.getJSONObject(i).getJSONObject("login").getString("uuid"),
                                    obj.getJSONObject(i).getJSONObject("name").getString("first"),
                                    obj.getJSONObject(i).getJSONObject("name").getString("last"),
                                    obj.getJSONObject(i).getJSONObject("name").getString("title"),
                                    obj.getJSONObject(i).getString("nat"),
                                    obj.getJSONObject(i).getString("phone"),
                                    obj.getJSONObject(i).getJSONObject("picture").getString("large"),
                                    obj.getJSONObject(i).getJSONObject("picture").getString("medium"),
                                    obj.getJSONObject(i).getJSONObject("picture").getString("thumbnail"),
                                    obj.getJSONObject(i).getJSONObject("registered").getInt("age"),
                                    obj.getJSONObject(i).getJSONObject("registered").getString("date"),
                                    obj.getJSONObject(i).getJSONObject("location").getJSONObject("timezone").getString("description"),
                                    obj.getJSONObject(i).getJSONObject("location").getJSONObject("timezone").getString("offset")));
                        }
                    } catch (JSONException | IOException e) {
                        throw new RuntimeException(e);
                    }

                    // Handler allows the UI to be updated.
                    /*
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            RecyclerViewAdapter adapter = new RecyclerViewAdapter(newsModel);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                            adapter.setListener(new RecyclerViewAdapter.Listener() {
                                @Override
                                public void onClick(int position) {
                                    Intent intent = new Intent(getActivity(), ContentActivity.class);
                                    Log.v("LOG", "[ July 17, 2024 onClick intent in HomeFragment was clicked ] => " + position);
                                    String url = newsModel.get(position).getUrlToImage();
                                    String content = newsModel.get(position).getContent();

                                    intent.putExtra("image", url);
                                    intent.putExtra("content", content);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                    */
                }
            }).start();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
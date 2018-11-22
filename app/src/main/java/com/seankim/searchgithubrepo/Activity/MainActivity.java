package com.seankim.searchgithubrepo.Activity;


import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.seankim.searchgithubrepo.Adapter.RepoListAdapter;
import com.seankim.searchgithubrepo.Net.GithubAPI;
import com.seankim.searchgithubrepo.R;
import com.seankim.searchgithubrepo.Utils.SeparatorDeco;
import com.seankim.searchgithubrepo.model.ResponseModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String SORT_STARS = "stars";
    private final String ORDER_DESC = "desc";
    private RepoListAdapter mRepoAdapter;

    @BindView(R.id.et_search)
    EditText mEditTextSearch;
    @BindView(R.id.btn_search)
    Button mBtnSearch;
    @BindView(R.id.rv_list)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.INTERNET }, 0);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GithubAPI mGithubAPI = retrofit.create(GithubAPI.class);

        mEditTextSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    queryToServer(mGithubAPI, mEditTextSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryToServer(mGithubAPI, mEditTextSearch.getText().toString());
            }
        });

        mRepoAdapter = new RepoListAdapter();
        mRecyclerView.setAdapter(mRepoAdapter);
        SeparatorDeco decoration = new SeparatorDeco(this, Color.GRAY, 1.0f);
        mRecyclerView.addItemDecoration(decoration);
    }

    private void queryToServer(GithubAPI githubAPI, String q) {
        githubAPI.reponse(q, SORT_STARS, ORDER_DESC).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.isSuccessful()) {
                    ResponseModel responseModel = response.body();

                    if (responseModel != null) {
                        mRepoAdapter.displayRelults(responseModel.getSearchResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
            }
        });
    }
}

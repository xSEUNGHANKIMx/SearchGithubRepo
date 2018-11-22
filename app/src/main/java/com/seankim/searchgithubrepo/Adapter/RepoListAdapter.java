package com.seankim.searchgithubrepo.Adapter;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seankim.searchgithubrepo.R;
import com.seankim.searchgithubrepo.model.RepoInfoModel;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepoListAdapter extends RecyclerView.Adapter<RepoListAdapter.RepoViewHolder> {
    List<RepoInfoModel> mResults = new ArrayList<>();
    Context mContext;

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        mContext = parent.getContext();
        return new RepoViewHolder(inflater.inflate(R.layout.list_item_repo_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bind(mResults.get(position));
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public void displayRelults(List<RepoInfoModel> results) {
        this.mResults = results;
        notifyDataSetChanged();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivAvatar;
        private final TextView tvRepoName;
        private final TextView tvRepoDesc;
        private final TextView tvRepoUpdated;
        private final TextView tvLanguage;
        private final TextView tvStars;


        RepoViewHolder(View itemView) {
            super(itemView);

            ivAvatar = itemView.findViewById((R.id.iv_repo_avatar));
            tvRepoName = itemView.findViewById(R.id.tv_repo_fullname);
            tvRepoDesc = itemView.findViewById(R.id.tv_repo_desc);
            tvRepoUpdated = itemView.findViewById(R.id.tv_repo_updated);
            tvLanguage = itemView.findViewById(R.id.tv_repo_language);
            tvStars = itemView.findViewById(R.id.tv_repo_stars);
        }

        void bind(RepoInfoModel result) {
            if(result != null ) {
                if(result.getOwner() != null) {
                    setOwnerImage(result.getOwner().getAvatar_url());
                }
                tvRepoName.setText(result.getFullName());
                tvRepoDesc.setText(result.getDescription());
                setUpdatedTime(result.getUpdatedAt());
                tvLanguage.setText(result.getLanguage());
                tvStars.setText("\u2605 " + "\n" + String.valueOf(result.getStargazersCount()));
            }
        }

        void setOwnerImage(String url) {
            if (!url.equalsIgnoreCase(""))
                Picasso.with(mContext).load(url).placeholder(R.drawable.github_default).into(ivAvatar);
        }

        void setUpdatedTime(String time) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy h:mm a");
            String formattedTime = "";

            try {
                Date d = sdf.parse(time);
                formattedTime = sdf2.format(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(!formattedTime.isEmpty()) {
                tvRepoUpdated.setText(formattedTime);
            }
        }
    }
}
